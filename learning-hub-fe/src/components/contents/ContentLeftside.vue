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
                :class="`router-link-active ${jobClassActivation('')}`" 
                @click="clickJobClass('')"
              >
                <i class="fa fa-angle-right " aria-hidden="true"></i> 전체
              </div>
            </li>
            <li class="marg-15" v-for="category in codeMap['JobCategories']" :key="category.code">
              <div 
                :class="`router-link-active ${jobClassActivation(category.code)}`" 
                @click="clickJobClass(category.code)"
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
import { mapState, mapGetters, mapMutations, mapActions } from 'vuex'
import { 
  Getters as ContentGetters, 
  Mutations as ContentMutations, 
  Actions as ContentActions 
} from '@/modules/store/types/content';

export default {
  name: 'contentLeftside',
  computed: {
    ...mapState('code', ['codeMap']),
    ...mapGetters('content', [ContentGetters.GET_JOB_CLASS])
  },
  methods: {
    ...mapMutations('content', [ContentMutations.SET_JOB_CLASS, ContentMutations.SET_SEARCH_TITLE]),
    ...mapActions('content', [ContentActions.SEARCH_CONTENT_PAGE_LIST]),
    jobClassActivation(jobClass) {
      return this[ContentGetters.GET_JOB_CLASS] === jobClass ? 'job-active' : '';
    },
    clickJobClass(jobCode) {
      this[ContentMutations.SET_SEARCH_TITLE]('');
      this[ContentMutations.SET_JOB_CLASS](jobCode);
      this[ContentActions.SEARCH_CONTENT_PAGE_LIST](1);
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
