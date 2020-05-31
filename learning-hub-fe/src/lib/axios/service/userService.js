import http from '../http';
 
// http.get *()

export default {
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