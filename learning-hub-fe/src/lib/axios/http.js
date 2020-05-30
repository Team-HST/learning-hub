import axios from 'axios';

/**
 * @description axios inteceptor reqeust 처리
 */
axios.interceptors.request.use((config) => {
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