import Vue from 'vue'
import Router from 'vue-router'

import HolloWorld from '@/components/HelloWorld'
import Navbar from '@/components/navbar'

Vue.component('Navbar', Navbar)
Vue.component('HolloWorld', HolloWorld)
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home_one',
      components: {
        default: HolloWorld,
        navbar: Navbar,
      }
    },
  ]
})