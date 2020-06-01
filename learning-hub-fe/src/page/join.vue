<template>
  <!-- sign up start-->
  <section class="authentication-form">
    <div class="innerpage-decor">
      <div class="innerpage-circle1"><img :src='"@/assets/images/Testimonial2.png"' alt=""></div>
      <div class="innerpage-circle2"><img :src='"@/assets/images/Testimonial1.png"' alt=""></div>
    </div>
    <div>
      <h2 class="title text-center">It's Free<span> Join US</span></h2>
      <p class="text-center">Welcome to tovo, Please join us with your personal account information.</p>
      <div class="card">
        <div class="theme-form">
          <div class="form-group">
            <div class="md-fgrup-margin">
              <input type="text" class="form-control" placeholder="아이디를 입력하세요." required="required">
            </div>
          </div>
          <div class="form-group">
            <input 
              type="txet" class="form-control" 
              placeholder="생년월일을 입력하여 주세요. 예) 1964-10-30"
              required="required">
          </div>
          <div class="form-group">
            <input 
              :type="showPassword ? 'password' : 'text'" required="" 
              class="form-control" placeholder="비밀번호를 입력하세요.">
            <div v-on:click="showPassword = !showPassword" class="show-hide">
              <span :class="{show:showPassword}"></span>
            </div>
          </div>
          <div class="form-group">
            <input 
              :type="showConfirmPassword ? 'password' : 'text'" required="required" 
              name="login[conform_password]" class="form-control" placeholder="비밀번호를 한번 더 입력하세요.">
            <div v-on:click="showConfirmPassword = !showConfirmPassword" class="show-hide">
              <span :class="{show:showConfirmPassword}"></span>
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
            <button type="submit" class="btn btn-custom theme-color">회원가입</button>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- sign up end-->
</template>
<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  name: 'join',
  data () {
    return {
      showPassword: true,
      showConfirmPassword: true
    }
  },
  methods: {
    // pattern="/^\d{4}-\d{1,2}-\d{1,2}$/" 생년월일 정규식
  }
}
</script>
