import http from '../http';
 
const userService = {
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
    return http.post('/api/user/sign-up', joinInfo)
  }
}

export default userService;