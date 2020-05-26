// import http form '../http';

// http.get *()

const userService = {
    searchUserInof: () => {
        return http.get('')
            .then(response => {
                return response.data;
            })
    }
}