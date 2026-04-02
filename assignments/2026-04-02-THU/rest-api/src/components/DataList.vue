<script setup>
defineProps({
  items: Array,
});
</script>

<template>
  <ul>
    <li v-for="item in items" :key="item.id">
      {{ item.name }}
      {{ item.description }}
    </li>
  </ul>
</template>
