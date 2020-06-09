import { contentService } from '@/lib/axios/service';

const state = {
  pageNum: 1,
  totalCnt: null
}

const getters = {
  getPageNum: (state) => {
    return state.pageNum
  }
}

const mutations = {
  setPageNum: (state, pageNum) => {
    state.pageNum = pageNum
  },
  setTotalCnt: (state, totalCnt) => {
    state.totalCnt = totalCnt
  }
}

const actions = {
  searchContentPageList: async (pageNum, title, jobClass) => {
   const response = await contentService.searchContentPageList(pageNum, title, jobClass);
   console.log(response);
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}