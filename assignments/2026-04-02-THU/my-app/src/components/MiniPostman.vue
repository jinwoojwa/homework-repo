<script setup>
import { ref, computed } from 'vue';
import axios from 'axios';

const method = ref('GET');
const baseUrl = ref('/api/data');
const id = ref('');
const body = ref('{}');
const response = ref(null);

const needsId = computed(() =>
  ['PUT', 'PATCH', 'DELETE'].includes(method.value),
);
const hasBody = computed(() => ['POST', 'PUT', 'PATCH'].includes(method.value));

const finalUrl = computed(() => {
  if (needsId.value && id.value) {
    return `${baseUrl.value}/${id.value}`;
  }
  return baseUrl.value;
});

const formattedResponse = computed(() => {
  if (typeof response.value === 'string') return response.value;
  try {
    return JSON.stringify(response.value, null, 2);
  } catch {
    return 'Invalid JSON';
  }
});

const sendRequest = async () => {
  try {
    let data;

    if (hasBody.value) {
      try {
        data = JSON.parse(body.value);
      } catch {
        response.value = 'Invalid JSON body';
        return;
      }
    }

    const res = await axios({
      method: method.value,
      url: finalUrl.value,
      data,
    });

    response.value = res.data;
  } catch (err) {
    response.value = err.message?.data || err.message;
  }
};
</script>

<template>
  <div class="container">
    <h1 class="title">Mini Postman</h1>

    <div class="request-panel">
      <select v-model="method" class="method-select">
        <option value="GET">GET</option>
        <option value="POST">POST</option>
        <option value="PUT">PUT</option>
        <option value="PATCH">PATCH</option>
        <option value="DELETE">DELETE</option>
      </select>

      <input
        v-model="baseUrl"
        type="text"
        placeholder="Base URL (e.g. /api/data)"
        class="url-input"
      />

      <input
        v-if="needsId"
        v-model="id"
        type="number"
        placeholder="id"
        class="id-input"
      />

      <button @click="sendRequest" class="send-btn">Send</button>
    </div>

    <transition name="body-panel">
      <div v-if="hasBody" class="body-panel">
        <h3>Request Body (JSON)</h3>
        <textarea v-model="body" placeholder='{ "name": "value" }'></textarea>
      </div>
    </transition>

    <div class="response-panel">
      <h3>Response</h3>
      <pre>{{ formattedResponse }}</pre>
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 1200px;
  width: 95%;
  margin: 40px auto;
  font-family: Arial, sans-serif;
}

.title {
  text-align: center;
  margin-bottom: 30px;
  font-size: 48px;
}

.request-panel {
  display: flex;
  gap: 10px;
  margin-bottom: 30px;
}

.method-select {
  padding: 10px;
  font-size: 16px;
}

.url-input {
  flex: 1;
  padding: 10px;
  font-size: 16px;
}

.id-input {
  width: 100px;
  padding: 10px;
  font-size: 16px;
}

.send-btn {
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  cursor: pointer;
  font-size: 16px;
}

.send-btn:hover {
  background-color: #369f6e;
}

.body-panel {
  overflow: hidden;
}

.body-panel textarea {
  width: 100%;
  height: 180px;
  margin-top: 10px;
  padding: 12px;
  font-family: monospace;
  font-size: 14px;
}

.body-panel-enter-active,
.body-panel-leave-active {
  transition: all 0.3s ease;
}

.body-panel-enter-from,
.body-panel-leave-to {
  opacity: 0;
  transform: translateY(-10px);
  max-height: 0;
}

.body-panel-enter-to,
.body-panel-leave-from {
  opacity: 1;
  transform: translateY(0);
  max-height: 300px;
}

.response-panel {
  margin-top: 30px;
  background: #1e1e1e;
  padding: 20px;
  border-radius: 8px;
  min-height: 300px;
  color: #eaeaea;
}

.response-panel h3 {
  margin-bottom: 15px;
  text-align: left;
  color: #9aa4b2;
}

pre {
  white-space: pre-wrap;
  word-break: break-word;
  font-size: 14px;
  line-height: 1.5;
  text-align: left;
}
</style>
