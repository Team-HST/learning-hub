<template>
  <div>
    <div class="page-margin">      
      <breadcrumb title="컨텐츠" :breadcrumb="breadcrumb" />
      <section>
        <div class="container">
          <div class="row">
            <!-- 컨텐츠 직종 카테고리 -->
            <content-leftside />
            <!-- 컨텐츠 메인 -->
            <div class="col-md-8 col-lg-9 blog-sec">
              <!-- 컨텐츠 검색 UI -->
              <content-search-bar />
              <!-- 컨텐츠 목록 -->
              <content-list />
            </div>
            <!-- 페이지네이션 -->
            <div class="col-md-12">
              <Page :clickPageNum="clickPageNum" :totalPage="pagination.totalPage" :pageNum="pagination.pageNum" />
            </div>
            <!-- 등록버튼 -->
            <div class="col-md-2 ml-auto">
              <button type="button" class="btn btn-custom theme-color" @click="clickToContentCreate">등록하기</button>
            </div>
          </div>
        </div>
      </section>    
    </div>
    <footer />
    <js />
  </div>  
</template>

<script>
import { mapState, mapActions } from 'vuex';
import { Actions as ContentActions } from '@/modules/store/types/content';

import ContentList from '@/components/contents/ContentList';
import ContentLeftside from '@/components/contents/ContentLeftside';
import ContentSearchBar from '@/components/contents/ContentSearchBar'

export default {
  name: 'ContentPage',
  components: {
    ContentList,
    ContentLeftside,
    ContentSearchBar
  },
  data () {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'}
      ],
    }
  },
  computed: {
    ...mapState('content', ['pagination'])
  },
  created() {
    this[ContentActions.SEARCH_CONTENT_PAGE_LIST]()
  },
  methods: {
    ...mapActions('content', [ContentActions.SEARCH_CONTENT_PAGE_LIST]),
    clickToContentCreate: function () {
      this.$router.push('/content-create');
    },
    clickPageNum: function (pageNum) {
      this[ContentActions.SEARCH_CONTENT_PAGE_LIST](pageNum);
    }
  }
}
</script>

<style scoped>
.search-text {
  min-height: 42px;
  font-size: 12px;
  border: none;
  border-radius: 20px;
  padding: 12px 30px;
  box-shadow: 0 0 5px 0 rgba(170, 170, 170, 0.15);
}

.form-row {
  margin-bottom: 15px;
}
</style>
