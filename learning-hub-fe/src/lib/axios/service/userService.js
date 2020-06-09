import http from '../http';
 
/**
 * 유저 관련 API 서비스
 */
export default {
  searchUserInfo: () => {
    return http.get('')
      .then(response => {
          return response.data;
      })
  }, 
  userLogin: (userInfo) => {
    return http.post('/api/users/sign-in', userInfo)            
  },
  userJoin: (joinInfo) => {
    return http.post('/api/users/sign-up', joinInfo)
  }
}