<script setup>
import { ref } from 'vue';

import DeclarativeRendering from './components/DeclarativeRendering.vue';
import ReactiveVariable from './components/ReactiveVariable.vue';
import EventListener from './components/EventListener.vue';
import Vif from './components/Vif.vue';
import Vfor from './components/Vfor.vue';
import ComputedValue from './components/ComputedValue.vue';

const current = ref('DeclarativeRendering');

const components = {
  DeclarativeRendering,
  ReactiveVariable,
  EventListener,
  Vif,
  Vfor,
  ComputedValue,
};
</script>

<template>
  <div class="wrapper">
    <div class="btn-group">
      <button
        :class="{ active: current === 'DeclarativeRendering' }"
        @click="current = 'DeclarativeRendering'"
      >
        1. declarative-rendering
      </button>

      <button
        :class="{ active: current === 'ReactiveVariable' }"
        @click="current = 'ReactiveVariable'"
      >
        2. reactive-variable
      </button>

      <button
        :class="{ active: current === 'EventListener' }"
        @click="current = 'EventListener'"
      >
        3. event-listener
      </button>

      <button :class="{ active: current === 'Vif' }" @click="current = 'Vif'">
        4. v-if
      </button>

      <button :class="{ active: current === 'Vfor' }" @click="current = 'Vfor'">
        5. v-for
      </button>

      <button
        :class="{ active: current === 'ComputedValue' }"
        @click="current = 'ComputedValue'"
      >
        6. computed_value
      </button>
    </div>

    <hr />

    <component :is="components[current]" />
  </div>
</template>

<style scoped>
.wrapper {
  padding: 20px;
}

.btn-group {
  display: flex;
  gap: 10px;
}

button {
  padding: 10px 16px;
  border: none;
  background-color: #393535;
  cursor: pointer;
  border-radius: 8px;
  transition: all 0.2s ease;
}

button:hover {
  background-color: #cfcfcf;
}

button.active {
  background-color: #42b883;
  color: white;
}
</style>
