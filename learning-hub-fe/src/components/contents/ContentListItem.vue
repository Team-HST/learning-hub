<template>
  <div class="blog-item">
    <div class="blog-block">
      <div class="blog-box">
        <div class="overflow-hidden">
          <router-link :to="`/contents/${content.no}`" >
            <img :src="thumbnailFileNo" alt="blog" width="100%" height="240">
          </router-link>
          </div>
      </div>
    </div>
    <div class="blog-text">
      <h3>{{content.title}}</h3>
      <p>{{jobClassName}}</p>
      <h5>{{content.registrant.name}} - {{createAt}}</h5>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import { Getters as CodeGetters } from '@/modules/store/types/code';
import { DateUtils } from '@/utils/common';

import { CODE } from '@/modules/store/types/namespaces';

export default {
  props: {
    content: Object
  },
  computed: {
    ...mapGetters(CODE, [CodeGetters.GET_CODE_NAME]),
    jobClassName() {
      return this[CodeGetters.GET_CODE_NAME]('JobCategories', this.content.jobClassType);
    },    
    createAt() {
      return DateUtils.getDateFormatStr(this.content.createAt, 'YYYY년 MM월 DD일')
    },
    thumbnailFileNo() {
      let thumbnailFile = this.content.thumbnailFile;      
      if (thumbnailFile) {
        return `/api/files/${thumbnailFile.fileNo}`;
      } else {
        return '@/assets/images/blog/9.jpg'
      }
    }
  }
}
</script>