<script setup>
import Header from './components/Header.vue';
import DataList from './components/DataList.vue';

import { ref, onMounted } from 'vue';
import * as api from './services/api';

const dataList = ref([]);

const name = ref('');
const description = ref('');

const loadData = async () => {
  const res = await api.getData();
  dataList.value = res.data;
};

const addData = async () => {
  await api.postData({
    name: name.value,
    description: description.value,
  });

  name.value = '';
  description.value = '';

  loadData();
};

onMounted(loadData);
</script>

<template>
  <Header />

  <div class="container">
    <div class="controls">
      <div class="button-group">
        <button @click="addData">POST</button>
        <button @click="loadData">GET</button>
        <button>PUT</button>
        <button>PATCH</button>
        <button>DELETE</button>
      </div>

      <div class="form">
        <input v-model="name" placeholder="name 입력" />
        <input v-model="description" placeholder="description 입력" />
      </div>
    </div>

    <div class="list">
      <DataList :items="dataList" />
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 24px;
}

/* 상단 컨트롤 영역 */
.controls {
  display: flex;
  align-items: center;
  gap: 16px;
}

/* 버튼 그룹 */
.button-group {
  display: flex;
  gap: 12px;
}

button {
  padding: 16px 20px;
  min-width: 90px;
  height: 60px;

  border: none;
  border-radius: 12px;

  background: linear-gradient(135deg, #6366f1, #4f46e5);
  color: white;
  font-weight: 600;

  cursor: pointer;
  transition: all 0.2s ease;
}

button:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 14px rgba(79, 70, 229, 0.25);
}

button:active {
  transform: translateY(0);
}

/* 입력 영역 */
.form {
  display: flex;
  gap: 12px;
}

input {
  height: 60px;
  padding: 0 14px;

  border-radius: 12px;
  border: 1px solid #e5e7eb;

  font-size: 14px;
  outline: none;

  transition: border 0.2s ease;
}

input:focus {
  border-color: #6366f1;
}

/* 리스트 카드 */
.list {
  padding: 16px;
  border-radius: 12px;
  background: white;
  border: 1px solid #e5e7eb;
}

/* 리스트 아이템 */
.list li {
  padding: 8px 0;
  border-bottom: 1px solid #f3f4f6;
}

.list li:last-child {
  border-bottom: none;
}
</style>
