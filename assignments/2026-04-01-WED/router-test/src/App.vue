<script setup>
import Header from './components/Header.vue';
</script>

<template>
  <div class="container">
    <Header />

    <router-view />
  </div>
</template>

<style>
.container {
  text-align: center;
  margin-top: 10px;
}

.card {
  margin-top: 10px;
}
</style>
