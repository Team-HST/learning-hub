<template>
  <b-navbar type="light" class="navbar-light theme-nav fixed-top" toggleable="lg" fixed="top"  v-b-scrollspy:nav-scroller>
    <div class="container">
    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
    <b-navbar-brand class="navbar-brand" :to="{name:'home'}">
      <img :src='"@/assets/images/logo.png"' alt="logo">
    </b-navbar-brand>
    <b-collapse class="default-nav"  is-nav id="nav_collapse">
      <b-navbar-nav class="navbar-nav navbar-nav ml-auto" id="mymenu">
        <b-nav-item :to="{name: 'home'}">홈</b-nav-item>
        <b-nav-item :to="{name: 'about'}">소개</b-nav-item>
        <b-nav-item :to="{name: 'contents'}">컨텐츠</b-nav-item>
        <b-nav-item :to="{name: 'faq'}">FAQ</b-nav-item>
        <b-nav-item-dropdown v-if="isUserSignedIn" right-alignment text="나의 정보" class="nav-link">
          <b-dropdown-item class="nav-link"  :to="{name: 'profile'}">프로필</b-dropdown-item>
          <b-dropdown-item class="nav-link"  :to="{name:'myDonation'}" >기부금 관리</b-dropdown-item>
          <b-dropdown-item class="nav-link" @click="clickSignOutBtn">로그아웃</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item v-if="!isUserSignedIn" class="nav-link" :to="{name: 'sign-in'}">로그인</b-nav-item>        
      </b-navbar-nav>
    </b-collapse>
    </div>
  </b-navbar>
</template>
<script>
import { mapState, mapActions } from 'vuex';

import { Actions as UserActions } from '@/modules/store/types/user';

export default {
  name:'Navbar',
  computed: {
    ...mapState('user', {
      isUserSignedIn: 'signedIn'
    })
  },
  methods: {
    ...mapActions('user', [UserActions.SIGN_OUT]),
    clickSignOutBtn() {
      this[UserActions.SIGN_OUT]();
    }
  }
}
</script>
