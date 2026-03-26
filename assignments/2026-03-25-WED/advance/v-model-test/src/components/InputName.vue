<script>
export default {
  props: ['name'],
};
</script>

<template>
  <input
    type="text"
    :value="name"
    @input="$emit('update:name', $event.target.value)"
  />
</template>
