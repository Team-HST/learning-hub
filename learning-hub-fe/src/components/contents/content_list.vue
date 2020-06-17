<template>
  <div class="row blog-list">
    <div 
      class="col-lg-6 col-md-12"
      v-for="(content ,index) in getContents" 
      :key="index"
    >
      <ContentListItem :content="content" />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ContentListItem from '@/components/contents/content_list_item'

export default {
  components: {
    ContentListItem
  },
  name: 'ContentList',
  computed: {
    ...mapGetters('content', ['getContents'])
  }
}
</script>