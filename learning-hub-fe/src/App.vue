<template>
  <div id="app">
    <router-view name="navbar"></router-view>
    <router-view />
    <Footer />
    <Js />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
</style>
