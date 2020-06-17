<template>
  <div class="row blog-list">
    <div 
      class="col-lg-6 col-md-12"
      v-for="(content ,index) in getContents" 
      :key="index"
    >
      <content-list-item :content="content" />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ContentListItem from '@/components/contents/content_list_item'

import ContentListItem from './ContentListItem'

export default {
  components: {
    ContentListItem
  },
  name: 'ContentList',
  components: {
    ContentListItem
  },
  computed: {
    ...mapGetters('content', ['getContents'])
  }
}
</script>