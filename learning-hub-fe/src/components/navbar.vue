<template>
  <b-navbar type="light" class="navbar-light theme-nav fixed-top" toggleable="lg" fixed="top"  v-b-scrollspy:nav-scroller>
    <div class="container">
    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
    <b-navbar-brand class="navbar-brand" :to="{name:'Main_page'}"><img :src='"../assets/images/logo.png"' alt="logo"></b-navbar-brand>
    <b-collapse class="default-nav"  is-nav id="nav_collapse">
      <b-navbar-nav class="navbar-nav navbar-nav ml-auto" id="mymenu">
        <b-nav-item href="/">홈</b-nav-item>
        <b-nav-item href="#about">소개</b-nav-item>
        <b-nav-item href="contents">컨텐츠</b-nav-item>
        <b-nav-item href="faq">FAQ</b-nav-item>
        <b-nav-item-dropdown right-alignment text="나의 정보" class="nav-link">
          <b-dropdown-item class="nav-link"  :href='"profile"'>프로필</b-dropdown-item>
          <b-dropdown-item class="nav-link"  :to="{name:'myDonation'}" >기부금 관리</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item class="nav-link" :href='"/signIn"'>로그인</b-nav-item>
      </b-navbar-nav>
    </b-collapse>
    </div>
  </b-navbar>
</template>
<script>
  export default {
   name:'Navbar'
  }
</script>
