<template>
  <div class="blog-item">
    <div class="blog-block">
      <div class="blog-box">
        <div class="overflow-hidden">
          <router-link :to="{path: '/contents/'+content.no}" >
            <img :src='"@/assets/images/blog/9.jpg"' alt="blog" class="img-fluid">
          </router-link>
          </div>
      </div>
    </div>
    <div class="blog-text">
      <router-link>
        <h3>{{content.title}}</h3>
        <p>{{content.jobClassType}}</p>
      </router-link>
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
    }
  }
}
</script>