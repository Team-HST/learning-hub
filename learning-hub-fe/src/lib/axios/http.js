import axios from 'axios';
// import store from '@/modules/store'
// import { StringUtils } from '@/utils/common'

// token 검사 목록
// const authAPI = [''];

/**
 * @description axios inteceptor reqeust 처리
 */
axios.interceptors.request.use((config) => {
  // 로그인 유저 token 조회
  // const token = store.getters['user/getUserToken'];
  config.headers.Authorization = `Bearer hst_13`
  
  // if (StringUtils.isNotEmpty(token)) {
  //   config.headers.Authorization = `Bearer ${token}`
  // }
  
  return config;
}, (error) => {
  return Promise.reject(error);
});

/**
 * @description axios interceptor response 처리
 */
axios.interceptors.response.use((response) => {
    return response;
  }, (error) => {
    // 공통 에러 처리
    console.log(error);
  }
);

export default {
  get: axios.get,
  post: axios.post,
  put: axios.put,
  delete: axios.delete
};