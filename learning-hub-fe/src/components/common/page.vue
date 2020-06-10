<template>
  <div aria-label="Page navigation" class="blog-pagination">
    <b-pagination-nav 
      v-model="currentPage" 
      :number-of-pages="totalPage" 
      @input="clickPageNum(currentPage)" 
      align="center"
      base-url="javascript:void(0);"
    ></b-pagination-nav>
  </div>
</template>

<script>
export default {
  name: 'Page',
  props: {
    totalPage: Number,
    clickPageNum: Function,
    pageNum: Number
  },
  data() {
    return {
      currentPage: this.pageNum
    }
  }
}
</script>