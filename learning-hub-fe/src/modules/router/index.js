import Vue from 'vue'
import Router from 'vue-router'

import Navbar from '@/components/navbar'
import About from '@/components/about'
import Home from '@/page/home'
import SignIn from '@/page/sign_in'
import SignUp from '@/page/sign_up'

Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('About', About)

Vue.component('Home', Home)
Vue.component('SignIn', SignIn)
Vue.component('SingUp', SignUp)
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      components: {
        default: Home,
        navbar: Navbar,
      }
    },
    {
      path: '/login',
      name: 'login',
      components: {
        default: SignIn
      }
    },
    {
      path: '/join',
      name: 'register',
      components: {
        default: SignUp
      }
    }
  ]
})