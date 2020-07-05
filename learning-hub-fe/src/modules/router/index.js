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
import MyDonation from '@/page/myDonation'

// components
import Navbar from '@/components/navbar'
import About from '@/components/about'
import Js from '@/components/js'
import ContentList from '@/components/contents/content_list'
import ContentListItem from '@/components/contents/content_list_item'
import ContentLeftside from '@/components/contents/content_leftside'
import Breadcrumb from '@/components/common/breadcrumb'
import CreateFileInput from '@/components/contents/content_file_input'
import Footer from '@/components/footer'
import Page from '@/components/common/page'
import MyDonationStatus from '@/components/user/myDonationStatus'
import MyRevenueStatus from '@/components/user/myRevenueStatus';


// pages
Vue.component('Home', Home)
Vue.component('SignIn', SignIn)
Vue.component('SignUp', SignUp)
Vue.component('Faq', Faq)
Vue.component('ContentList', ContentList)
Vue.component('ContentCreate', ContentCreate)
Vue.component('ContentDetail', ContentDetail)
Vue.component('MyDonation', MyDonation)

// components
Vue.use(Router)
Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('About', About)
Vue.component('Js', Js)
Vue.component('ContentLeftside', ContentLeftside)
Vue.component('ContentListItem', ContentListItem)
Vue.component('Breadcrumb', Breadcrumb)
Vue.component('CreateFileInput', CreateFileInput)
Vue.component('Footer', Footer)
Vue.component('Page', Page)
Vue.component('MyDonationStatus', MyDonationStatus)
Vue.component('MyRevenueStatus', MyRevenueStatus)

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
      path: '/contents/:srno',
      name: 'content_detail',
      components: {
        default: ContentDetail,
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
    },
    {
      path: '/myDonation',
      name: 'myDonation',
      components: {
        default: MyDonation,
        // default: MyDonationStatus,
        navbar: Navbar
      }
    }
  ]
})