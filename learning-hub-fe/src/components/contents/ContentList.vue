<template>
  <div class="row blog-list">
    <div 
      class="col-lg-6 col-md-12"
      v-for="(content ,index) in contents" 
      :key="index"
    >
      <content-list-item :content="content" />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

import { Getters as ContentGetters } from '@/modules/store/types/content';

import ContentListItem from './ContentListItem'

export default {
  name: 'ContentList',
  components: {
    ContentListItem
  },
  computed: {
    ...mapGetters('content', { contents: ContentGetters.GET_CONTENTS })
  }
}
</script>