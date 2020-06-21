<template>
  <div class="blog-item">
    <div class="blog-block">
      <div class="blog-box">
        <div class="overflow-hidden">
          <router-link :to="'/contents/'+content.no" >
            <img :src="thumbnailFileNo" alt="blog" width="100%" height="240">
          </router-link>
          </div>
      </div>
    </div>
    <div class="blog-text">
      <h3>{{content.title}}</h3>
      <p>{{content.jobClassType}}</p>
      <h5>{{content.registrant.name}} - {{getFormatDate}}</h5>
    </div>
  </div>
</template>

<script>
import { DateUtils } from '@/utils/common'

export default {
  props: {
    content: Object
  },
  data() {
    return {
      createAt: ''
    }
  },
  computed: {
    getFormatDate: function () {
      const createAt = DateUtils.getDateFormatStr(this.content.createAt, 'YYYY년 MM월 DD일')
      return createAt
    },
    thumbnailFileNo() {
      let thumbnailFile = this.content.contentFiles.filter(e => e.fileTypeCode == 'F001');      
      if (thumbnailFile.length == 1) {
        return `/api/files/${thumbnailFile[0].fileNo}`;
      } else {
        return '@/assets/images/blog/9.jpg'
      }
    }
  }
}
</script>