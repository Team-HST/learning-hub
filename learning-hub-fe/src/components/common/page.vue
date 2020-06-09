<template>
  <div aria-label="Page navigation" class="blog-pagination">
    <b-pagination-nav 
      v-model="currentPage" 
      :number-of-pages="10" 
      @input="clickPageBtn(currentPage)" 
      align="center"
      base-url="javascript:void(0);"
    ></b-pagination-nav>
  </div>
</template>

<script>
export default {
  name: 'Page',
  data() {
    return {
      currentPage: 1,
      pageMoveCnt: 0,
      selectPage: 1,
      noPageDetect: true
    }
  },
  methods: {
    clickPageBtn(page) {
      console.log(page);
    }
  }
  
}
</script>