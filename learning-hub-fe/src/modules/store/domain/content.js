import { contentService } from '@/lib/axios/service';
import { 
  Getters as ContentGetters, 
  Mutations as ContentMutations,
  Actions as ContentActions
} from '../types/content';

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
  contents: []
}

const getters = {
  [ContentGetters.GET_PAGE_NUM]: (state) => {
    return state.pagination.pageNum
  },
  [ContentGetters.GET_TOTAL_PAGE]: (state) => {
    return state.pagination.totalPage
  },
  [ContentGetters.GET_JOB_CLASS]: (state) => {
    return state.jobClass
  },
  [ContentGetters.GET_CONTENTS]: (state) => {
    return state.contents
  }
}

const mutations = {
  [ContentMutations.INIT_PARAM_NUM]: (state) => {
    state.pageNum = 1
  },
  [ContentMutations.SET_PAGE_NUM]: (state, pageNum) => {
    state.pagination.pageNum = pageNum
  },
  [ContentMutations.SET_TOTAL_PAGE]: (state, totalPage) => {
    state.pagination.totalPage = totalPage
  },
  [ContentMutations.SET_SEARCH_TITLE]: (state, title) => {
    state.searchBar.title = title
  },
  [ContentMutations.SET_JOB_CLASS]: (state, jobClass) => {
    state.jobClass = jobClass
  },
  [ContentMutations.SET_CONTENTS]: (state, contents) => {
    state.contents = contents
  }
}

const actions = {
  // 조건 별 컨텐츠 목록 조회
  // 타이틀 검색, 카테고리 검색, 페이지 조회
  [ContentActions.SEARCH_CONTENT_PAGE_LIST]: async function ({commit, state}, pageNum) {
    commit('setPageNum', pageNum);

    const response = await contentService.searchContentPageList(
      state.pagination, state.searchBar.title, state.jobClass
    );
    // 전체 페이지 수
    const totalPage = response.data.totalPage;
    commit('setTotalPage', totalPage > 0 ? totalPage : 1);
    commit('setContents', response.data.contents);
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}