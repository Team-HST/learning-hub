<template>
  <!-- sign in start -->
  <section class="authentication-form">
    <div class="innerpage-decor">
      <div class="innerpage-circle1"><img :src='"../assets/images/Testimonial2.png"' alt=""></div>
      <div class="innerpage-circle2"><img :src='"../assets/images/Testimonial1.png"' alt=""></div>
    </div>
    <div>
      <h2 class="title text-center"><span> Login</span></h2>
      <p class="text-center">Welcome to tovo, Please Login with your personal account information.</p>
      <div class="card">
        <form class="theme-form">
          <div class="form-group">
            <input v-model="userInfo.id" class="form-control" placeholder="ID" required="required">
          </div>
          <div class="form-group">
            <input v-model="userInfo.password" :type="showpassword ? 'password' : 'text'" required="" name="login[password]" class="form-control" placeholder="Password">
            <div  v-on:click="showpassword = !showpassword" class="show-hide">
              <span :class="{show:showpassword}"></span>
            </div>
          </div>
          <div class="form-group row">
            <div class="custom-control custom-checkbox col-6">
              <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
              <label class="custom-control-label" for="customControlAutosizing">Remember me</label>
            </div>
            <a :href='"/tovo/forget-Password"' class="text-right col-6 theme-link">lost your password</a>
          </div>
          <div class="form-button text-center">
            <button type="button" @click="clickLoginBtn" class="btn btn-custom btn-lg theme-color">로그인</button>
          </div>
          <div class="or-saparator"><span>or</span></div>
          <div class="form-button text-center">
            <button type="button" @click="clickToJoinBtn" class="btn btn-custom btn-lg theme-color">회원가입</button>
          </div>
        </form>
      </div>
    </div>
  </section>
  <!-- sign in end-->
</template>

<script>
  import 'bootstrap/dist/css/bootstrap.css'
  import 'bootstrap-vue/dist/bootstrap-vue.css'
  import { mapMutations, mapActions } from 'vuex'

  export default {
    name: 'login',
    data () {
      return {
        userInfo: {
          id: '',
          password: ''
        },
        showpassword: true
      }
    },
    methods: {
      ...mapMutations(['setUserInfo']),
      ...mapActions('user', ['signIn']),
      clickLoginBtn: function() {
        this.signIn(this.userInfo)
      },
      clickToJoinBtn: function() {
        this.$router.push('/join')
      }
    }
  }
</script>
