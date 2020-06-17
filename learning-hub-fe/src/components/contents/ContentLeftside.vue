<template>
  <div class="col-md-4 col-lg-3 order-md-first list-sidebar">
    <div class="sidebar">
      <div class="sidebar-space">
        <h4 class="blog-title">직종 카테고리</h4>
        <div class="blog-divider"></div>
        <div class="blog-cat-detail">
          <ul>
            <li class="marg-15">
              <div 
                class="router-link-active" 
                :class="getJobClass === '' ? 'job-active' : ''"
                @click="clickCategoryJobClass('')"
              >
                <i class="fa fa-angle-right " aria-hidden="true"></i> 전체
              </div>
            </li>
            <li class="marg-15" v-for="category in getCodeMap['job-classes']" :key="category.code">
              <div 
                class="router-link-active" 
                :class="getJobClass === category.code ? 'job-active' : ''"
                @click="clickCategoryJobClass(category.code)"
              >
                <i class="fa fa-angle-right" aria-hidden="true"></i> {{category.codeName}}
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'

export default {
  name: 'contentLeftside',
  computed: {
    ...mapGetters('code', ['getCodeMap']),
    ...mapGetters('content', ['getJobClass'])
  },
  methods: {
    ...mapMutations('content', ['setJobClass', 'setSearchTitle']),
    ...mapActions('content', ['searchContentPageList']),
    clickCategoryJobClass: function (jobCode) {
      this.setSearchTitle('')
      this.setJobClass(jobCode)
      this.searchContentPageList(1)
    }
  }
}
</script>

<style scoped>
.blog-cat-detail ul li div {
    color: #777777;
    text-transform: capitalize;
    font-size: 14px;
    text-decoration: none;
    transition: 0.3s ease;
    font-weight: 500;
    cursor: pointer;
}

.job-active {
  font-weight: 900 !important;
}
</style>
