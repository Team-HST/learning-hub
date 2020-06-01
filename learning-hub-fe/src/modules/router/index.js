import Vue from 'vue'
import Router from 'vue-router'

import Navbar from '@/components/navbar'
import About from '@/components/about'
import Js from '@/components/js'
import Home from '@/page/home'
import SignIn from '@/page/sign_in'
import SignUp from '@/page/sign_up'
import Content from '@/page/content'
import ContentForm from '@/page/contentForm'
import Faq from '@/page/faq'
import ContentList from '@/components/contents/content_list'
import ContentListItem from '@/components/contents/content_list_item';
import ContentLeftside from '@/components/contents/content_leftside'
import Breadcrumb from '@/components/common/breadcrumb'

Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('About', About)
Vue.component('Js', Js)
Vue.component('Home', Home)
Vue.component('SignIn', SignIn)
Vue.component('SingUp', SignUp)
Vue.component('Faq', Faq)
Vue.component('ContentForm', ContentForm)
Vue.component('ContentLeftside', ContentLeftside)
Vue.component('ContentListItem', ContentListItem)
Vue.component('ContentList', ContentList)
Vue.component('Breadcrumb', Breadcrumb)
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
      path: '/signIn',
      name: 'signIn',
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
    },
    {
      path: '/contents',
      name: 'content',
      components: {
        default: Content,
        navbar: Navbar,
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