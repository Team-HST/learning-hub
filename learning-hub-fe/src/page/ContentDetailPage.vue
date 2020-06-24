<template>
  <div class="page-margin">
    <Breadcrumb title="컨텐츠 상세" :breadcrumb="breadcrumb" />
    <section id="content-detail">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="blog-item">
              <div>
                <div class="blog-box" v-if="contentDetail.mainContentFileNo != 0">
                  <video width="100%" height="640" :src="`/api/files/${contentDetail.mainContentFileNo}`" controls />
                </div>
              </div>
              <div class="blog-divider"></div>
              <div class="blog-text">
                <div class="row">
                  <div class="col-sm-1" v-if="contentDetail.registrant.profileImageFileNo != 0">
                    <img :src="`/api/files/${contentDetail.registrant.profileImageFileNo}`" width="64" height="64">
                    by {{contentDetail.registrant.name}}
                  </div>
                  <div class="col-sm-11">                                        
                    <h2 class="blog-head"><strong>{{contentDetail.title}}</strong></h2>
                    <h6>{{contentDetail.createAt}}</h6>
                  </div>
                </div>
                <div class="blog-description">
                  <p>{{contentDetail.contents}}</p>
                </div>
              </div>
            </div>
            <div class="blog-divider"></div>
            <content-reply-list />
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

import ContentReplyList from '@/components/contents/ContentReplyList'

export default {
  name: 'ContentDetailPage',
  components: { ContentReplyList },
  data() {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'},
        {name: '컨텐츠 상세', to: '/contentDetail'}
      ]
    }
  },
  computed: {
    ...mapState('content', ['contentDetail']),
    contentNo() {
      return this.$route.params.contentNo;
    }
  },
  methods: {
    ...mapActions('content', ['searchContentDetail'])
  },
  created() {
    this.searchContentDetail(this.contentNo)
  }
}
</script>

<style scoped>
</style>