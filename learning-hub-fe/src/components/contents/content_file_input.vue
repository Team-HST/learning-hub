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