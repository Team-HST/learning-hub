import { contentService } from '@/lib/axios/service';

const state = {
  searchBar: {
    title: ''  // 조회 검색 
  },
  pagination: {
    pageNum: 1,
    size: 6,
    totalPage: null    
  },
  pageNum: 1, // 현재 조회 페이지 
  totalPage: null, // 총 페이지
  jobClass: '', // 선택 카테고리
  contents: [], // 목록 컨텐츠
  contentDetail: {} // 상세 컨텐츠
}

const getters = {
  getPageNum: (state) => {
    return state.pagination.pageNum
  },
  getTotalPage: (state) => {
    return state.pagination.totalPage
  },
  getJobClass: (state) => {
    return state.jobClass
  },
  getContents: (state) => {
    return state.contents
  },
  getContentDetail: (state) => {
    return state.contentDetail
  }
}

const mutations = {
  initPageNum: (state) => {
    state.pageNum = 1
  },
  setPageNum: (state, pageNum) => {
    state.pagination.pageNum = pageNum
  },
  setTotalPage: (state, totalPage) => {
    state.pagination.totalPage = totalPage
  },
  setSearchTitle: (state, title) => {
    state.searchBar.title = title
  },
  setJobClass: (state, jobClass) => {
    state.jobClass = jobClass
  },
  setContents: (state, contents) => {
    state.contents = contents
  },
  setContentDetail: (state, content) => {
    state.contentDetail = content
  }
}

const actions = {
  // 조건 별 컨텐츠 목록 조회
  // 타이틀 검색, 카테고리 검색, 페이지 조회
  searchContentPageList: async function ({commit, state}, pageNum) {
    commit('setPageNum', pageNum);

    const response = await contentService.searchContentPageList(
      state.pagination, state.searchBar.title, state.jobClass
    );
    // 전체 페이지 수
    const totalPage = response.data.totalPage;
    commit('setTotalPage', totalPage > 0 ? totalPage : 1);
    commit('setContents', response.data.contents);
  },
  // 컨텐츠 상세조회
  searchContentDetail: async function ({commit}, srno) {
    const response = await contentService.searchContentDetail(srno)
    commit('setContentDetail', response.data)
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}