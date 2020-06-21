import Vue from 'vue'
import Router from 'vue-router'

// components
import Navbar from '@/components/layouts/Navbar'
import Js from '@/components/layouts/Js'
import Footer from '@/components/layouts/Footer'
import Breadcrumb from '@/components/common/Breadcrumb'
import Page from '@/components/common/Page';

// global components
Vue.use(Router)
Vue.component('Navbar', Navbar) // 상단 메뉴 컴포넌트
Vue.component('Js', Js)
Vue.component('Breadcrumb', Breadcrumb)
Vue.component('Footer', Footer)
Vue.component('Page', Page)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      components: {
        default: () => import('@/page/HomePage'),
        navbar: Navbar
      }
    },
    {
      path: '/about',
      name: 'about',
      components: {
        default: () => import('@/page/AboutPage'),
        navbar: Navbar
      }
    },
    {
      path: '/sign-in',
      name: 'sign-in',
      component: () => import('@/page/SignInPage')
    },
    {
      path: '/sign-up',
      name: 'sign-up',
      component: () => import('@/page/SignUpPage')
    },
    {
      path: '/contents',
      name: 'contents',
      components: {
        default: () => import('@/page/ContentPage'),
        navbar: Navbar
      }
    },
    {
      path: '/content-create',
      name: 'content-create',
      components: {
        default: () => import('@/page/ContentCreatePage'),
        navbar: Navbar
      }
    },
    {
      path: '/contents/:srno',
      name: 'content-detail',
      components: {
        default: () => import('@/page/ContentDetailPage'),
        navbar: Navbar
      }
    },
    {
      path: '/faq',
      name: 'faq',
      components: {
        default: () => import('@/page/FaqPage'),
        navbar: Navbar
      }
    },
    {
      path: '/profile',
      name: 'profile',
      components: {
        default: () => import('@/page/ProfilePage'),
        navbar: Navbar
      }      
    }
  ]
})