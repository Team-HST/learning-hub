import Vue from 'vue'
import Router from 'vue-router'

// pages
import Home from '@/page/home'
import SignIn from '@/page/sign_in'
import SignUp from '@/page/sign_up'
import Content from '@/page/content'
import ContentCreate from '@/page/content_create'
import ContentDetail from '@/page/content_detail'
import Faq from '@/page/faq'

// global components
import Navbar from '@/components/navbar'
import Js from '@/components/js'
import ContentList from '@/components/contents/content_list'
import Breadcrumb from '@/components/common/breadcrumb'
import Footer from '@/components/footer'

// pages
Vue.component('Home', Home)
Vue.component('SignIn', SignIn)
Vue.component('SignUp', SignUp)
Vue.component('Faq', Faq)
Vue.component('ContentList', ContentList)
Vue.component('ContentCreate', ContentCreate)
Vue.component('ContentDetail', ContentDetail)

// global components
Vue.use(Router)
Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('Js', Js)
Vue.component('Breadcrumb', Breadcrumb)
Vue.component('Footer', Footer)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      components: {
        default: Home,
        navbar: Navbar
      }
    },
    {
      path: '/signIn',
      name: 'SignIn',
      component: SignIn
    },
    {
      path: '/signUp',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/contents',
      name: 'Content',
      components: {
        default: Content,
        navbar: Navbar
      }
    },
    {
      path: '/contentCreate',
      name: 'ContentCreate',
      components: {
        default: ContentCreate,
        navbar: Navbar
      }
    },
    {
      path: '/contents/:srno',
      name: 'ContentDetail',
      components: {
        default: ContentDetail,
        navbar: Navbar
      }
    },
    {
      path: '/faq',
      name: 'Faq',
      components: {
        default: Faq,
        navbar: Navbar
      }
    }
  ]
})