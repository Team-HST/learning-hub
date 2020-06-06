import Vue from 'vue'
import Router from 'vue-router'

// pages
import Home from '@/page/home'
import SignIn from '@/page/sign_in'
import SignUp from '@/page/sign_up'
import Content from '@/page/content'
import ContentCreate from '@/page/content_create'
import ContentForm from '@/page/contentForm'
import Faq from '@/page/faq'

// components
import Navbar from '@/components/navbar'
import About from '@/components/about'
import Js from '@/components/js'
import ContentList from '@/components/contents/content_list'
import ContentListItem from '@/components/contents/content_list_item'
import ContentLeftside from '@/components/contents/content_leftside'
import Breadcrumb from '@/components/common/breadcrumb'
import Footer from '@/components/footer'

// pages
Vue.component('Home', Home)
Vue.component('SignIn', SignIn)
Vue.component('SignUp', SignUp)
Vue.component('Faq', Faq)
Vue.component('ContentList', ContentList)
Vue.component('ContentCreate', ContentCreate)
Vue.component('ContentForm', ContentForm)

// components
Vue.use(Router)
Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('About', About)
Vue.component('Js', Js)
Vue.component('ContentLeftside', ContentLeftside)
Vue.component('ContentListItem', ContentListItem)
Vue.component('Breadcrumb', Breadcrumb)
Vue.component('Footer', Footer)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      components: {
        default: Home,
        navbar: Navbar
      }
    },
    {
      path: '/signIn',
      name: 'sign_in',
      component: SignIn
    },
    {
      path: '/signUp',
      name: 'sign_up',
      component: SignUp
    },
    {
      path: '/contents',
      name: 'content',
      components: {
        default: Content,
        navbar: Navbar
      }
    },
    {
      path: '/contentCreate',
      name: 'content_create',
      components: {
        default: ContentCreate,
        navbar: Navbar
      }
    },
    {
      path: '/contentForm',
      name: 'contentForm',
      components: {
        default: ContentForm,
        navbar: Navbar
      }
    },
    {
      path: '/faq',
      name: 'faq',
      components: {
        default: Faq,
        navbar: Navbar
      }
    }
  ]
})