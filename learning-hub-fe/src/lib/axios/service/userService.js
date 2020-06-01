import http from '../http';
 
const userService = {
  searchUserInfo: () => {
    return http.get('')
      .then(response => {
          return response.data;
      })
  }, 
  signIn: (userInfo) => {
      return http.post('/api/users/sign-in', userInfo)            
  }
}

export default userService;