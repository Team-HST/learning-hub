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
import { DateUtils } from '@/utils/common'
import { contentService } from '@/lib/axios/service';

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
      ],
      contentDetail: {
        no: 0,
        title: '',
        contents: '',
        jobClassTypeName: '',
        donationRatio: 0,
        mainContentFileNo: 0,
        createAt: '',
        registrant: {
          name: '',
          profileImageFileNo: 0
        }
      }
    }
  },
  computed: {
    contentNo() {
      return this.$route.params.contentNo;
    }
  },
  methods: {
    async initContentDetail() {
      let response = await contentService.searchContentDetail(this.contentNo);
      let content = response.data;
      this.contentDetail.no = content.no;
      this.contentDetail.title = content.title;
      this.contentDetail.contents = content.contents;
      this.contentDetail.jobClassTypeName = content.jobClassType;
      this.contentDetail.donationRatio = content.donationRatio;
      this.contentDetail.createAt = DateUtils.getDateFormatStr(content.no, 'YYYY년 MM월 DD일');
      this.contentDetail.mainContentFileNo = content.mainContentFile.fileNo;
      this.contentDetail.registrant.name = content.registrant.name;
      this.contentDetail.registrant.profileImageFileNo = content.registrant.profileImageFileNo;
    }
  },
  created() {
    this.initContentDetail();
  }
}
</script>

<style scoped>
</style>