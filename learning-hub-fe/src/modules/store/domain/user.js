import { userService } from '@/lib/axios/service'

import { 
  Getters as UserGetters, 
  Mutations as UserMutations,
  Actions as UserActions
} from '../types/user';

import router from '@/modules/router'

const state = {
  signedIn: false,
  token: '',
  userInfo: {}
}

const getters = {  
  [UserGetters.GET_USER_TOKEN]: (state) => {
    return state.token;
  },
  [UserGetters.GET_USER_INFO]: (state) => {
    return state.userInfo;
  }
}

const mutations = {
  // 사용자 정보
  [UserMutations.CHANGE_USER_SIGNED_IN]: (state, userData) => {
    state.userInfo = userData.user;
    state.token = userData.token;
    state.signedIn = true    
  },
  [UserMutations.CHANGE_USER_SIGNED_OUT]: (state) => {
    state.userInfo = {};
    state.token = '';
    state.signedIn = false    
  }
}

const actions = {
  [UserActions.SIGN_IN]: async ({commit}, userInfo) => {
    let response = await userService.signIn(userInfo);
    let status = response.data.status.code;

    if (status === "L001") {
      commit(UserMutations.CHANGE_USER_SIGNED_IN, response.data);
      router.push({name: 'home'});      
    } else if (status === "L101") {
      alert("ID를 찾을 수 없습니다.");
    } else if (status === "L102") {
      alert("비밀번호가 잘못되었습니다.");
    }
  },
  [UserActions.SIGN_OUT]({commit}) {
    commit(UserMutations.CHANGE_USER_SIGNED_OUT);
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