import { userService } from '@/lib/axios/service'

const state = {
  token: '',
  userInfo: {}
}

const getters = {  
  getUserToken: (state) => {
    return state.token;
  },
  getUserInfo: (state) => {
    return state.userInfo;
  }
}

const mutations = {
  // 사용자 정보
  setUserInfo: (state, userInfo) => {
    state.userInfo = userInfo;
  },
  setToken: (state, token) => {
    state.token = token;
  }
}

const actions = {
  async signIn({commit}, userInfo) {
    let response = await userService.signIn(userInfo);
    let status = response.data.status;
    
    // 로그인 성공 처리
    if (status === "L001") {
      commit('setUserInfo', response.user);
      commit('setToken', response.token);

    // 로그인 실패 처리 (사용자 조회 실패)
    } else if (status === "L101") {
      alert("조회 실패");

    // 로그인 실패 처리 (패스워드 틀림)
    } else if (status === "L102") {
      alert("비밀번호 틀림");
    }
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}