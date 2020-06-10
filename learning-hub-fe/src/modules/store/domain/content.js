import { contentService } from '@/lib/axios/service';

const state = {
  pageNum: 1,
  totalPage: null,
  searchTitle: '',
  jobClass: '',
  contents: []
}

const getters = {
  getPageNum: (state) => {
    return state.pageNum
  },
  getTotalPage: (state) => {
    return state.totalPage
  },
  getSearchTitle: (state) => {
    return state.searchTitle
  },
  getContents: (state) => {
    return state.contents
  }
}

const mutations = {
  initPageNum: (state) => {
    state.pageNum = 1
  },
  setPageNum: (state, pageNum) => {
    state.pageNum = pageNum
  },
  setTotalPage: (state, totalPage) => {
    state.totalPage = totalPage
  },
  setSearchTitle: (state, title) => {
    state.searchTitle = title
  },
  setContents: (state, contents) => {
    state.contents = contents
  }
}

const actions = {
  searchContentPageList: async function ({commit, state}) {
    const response = await contentService.searchContentPageList(
      state.pageNum, state.searchTitle, state.jobClass
    )
    // 전체 페이지 수
    const totalPage = response.data.totalPage
    commit('setTotalPage', totalPage > 0 ? totalPage : 1)
    commit('setContents', response.data.contents)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}