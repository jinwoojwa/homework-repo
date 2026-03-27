<!--
  [TodoInput.vue 처리 단계 설명]

  1단계. 입력창 데이터 inputMsg를 ref로 만든다.
  2단계. input 태그와 v-model로 양방향 바인딩한다.
  3단계. Enter 키 또는 등록 버튼 클릭 시 addTodo()를 실행한다.
  4단계. addTodo()는 현재 입력값을 부모(App.vue)로 emit 한다.
  5단계. 전송이 끝나면 입력창을 빈 문자열로 초기화한다.
-->

<script setup>
import { ref } from 'vue';

const emit = defineEmits(['add-todo']);

const inputMessage = ref('');

// addTodo는 현재 입력값을 부모에게 전달하고 입력창을 초기화한다.
const addTodo = () => {
  const trimmedMessage = inputMessage.value.trim();
  if (!trimmedMessage) return;

  emit('add-todo', trimmedMessage);
  inputMessage.value = '';
};
</script>

<template>
  <div class="todo-input-wrap">
    <input
      type="text"
      class="todo-input"
      placeholder="할 일을 입력하세요."
      v-model="inputMessage"
      @keydown.enter="addTodo"
    />

    <button class="todo-add-btn" @click="addTodo">등록</button>
  </div>
</template>
