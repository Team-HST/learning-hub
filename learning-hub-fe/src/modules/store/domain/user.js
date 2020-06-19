import { userService } from '@/lib/axios/service'

import router from '@/modules/router'

const state = {
  signedIn: false,
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
  changeUserSignedIn: (state, userData) => {
    state.userInfo = userData.user;
    state.token = userData.token;
    state.signedIn = true    
  },
  changeUserSignedOut: (state) => {
    state.userInfo = {};
    state.token = '';
    state.signedIn = false    
  }
}

const actions = {
  async signIn({commit}, userInfo) {
    let response = await userService.signIn(userInfo);
    let status = response.data.status.code;

    if (status === "L001") {
      commit('changeUserSignedIn', response.data);
      router.push({name: 'home'});      
    } else if (status === "L101") {
      alert("ID를 찾을 수 없습니다.");
    } else if (status === "L102") {
      alert("비밀번호가 잘못되었습니다.");
    }
  },
  signOut({commit}) {
    commit('changeUserSignedOut');
    alert('로그아웃 되었습니다.');
    if (router.currentRoute.name != 'home') {
      router.push({name: 'home'});
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