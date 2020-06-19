<template>
  <div class="form-row">
    <div class="col-4">
      <label :for="id" class="btn btn-custom theme-color">{{btnText}}</label>
      <input type="file" :id="id" :accept="accept" @change="change">
    </div>
    <div class="col-8">
      <input type="text" :value="placeholder" class="form-control digits mb-1">
    </div>
  </div>
</template>

<script>
export default {
  name: 'CreateFileInput',
  props: {
    id: String,
    placeholder: String,
    btnText: String,
    accept: String,
    change: Function
  }
}
</script>

<style scoped>
label {
  font-size: 13px;
}

input[type='file'] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>