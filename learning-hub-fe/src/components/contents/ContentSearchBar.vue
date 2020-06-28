<template>
  <div class="form-row">
    <div class="col-10">
      <input 
        type="text"
        class="form-control digits mb-1 search-text"
        :value="searchBar.title"
        @input="updateSearchTitle"
        placeholder="제목를 입력하여 주세요."
      />
    </div>
    <div class="col-2">
      <button 
        class="btn btn-custom theme-color" 
        @click="searchContentPageList(1)">검색</button>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex';

import { Mutations as ContentMutations, Actions as ContentActions } from '@/modules/store/types/content';

export default {
  name: 'ContentSearchBar',
  computed: {
    ...mapState('content', ['searchBar'])
  },
  methods: {
    ...mapMutations('content', [ContentMutations.SET_SEARCH_TITLE]),
    ...mapActions('content', [ContentActions.SEARCH_CONTENT_PAGE_LIST]),
    updateSearchTitle(e) {
      this.setSearchTitle(e.target.value);
    }
  }
}
</script>

<style>

</style>