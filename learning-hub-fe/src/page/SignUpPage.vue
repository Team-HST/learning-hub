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
              <input 
                type="text" class="form-control" 
                placeholder="아이디를 입력하여 주세요." required="required"
                maxlength=29
                v-model="join.id"
              />
            </div>
          </div>
          <div class="form-group">
            <input 
              type="txet" class="form-control" 
              placeholder="이름을 입력하여 주세요." required="required"
              maxlength=49
              v-model="join.name"
            />
          </div>
          <div class="form-group">
            <input 
              type="txet" class="form-control" required="required"
              placeholder="생년월일을 입력하여 주세요. 예) 1964-01-10"
              v-model="join.birthDate"
            />
          </div>
          <div class="form-group">
            <input 
              :type="showPassword ? 'password' : 'text'" required="" 
              class="form-control" placeholder="비밀번호를 입력하세요."
              v-model="join.password"
            />
            <div v-on:click="showPassword = !showPassword" class="show-hide">
              <span :class="{show:showPassword}"></span>
            </div>
          </div>
          <div class="form-group">
            <input 
              :type="showConfirmPassword ? 'password' : 'text'" 
              name="login[conform_password]" class="form-control" 
              placeholder="비밀번호를 한번 더 입력하세요." required="required" 
              v-model="join.confirmPassword"
            />
            <div v-on:click="showConfirmPassword = !showConfirmPassword" class="show-hide">
              <span :class="{show:showConfirmPassword}"></span>
            </div>
          </div>
          <div class="form-group text-center">
            <b-form-radio-group
              id="btn-radios-1"
              v-model="join.roleType"
              :options="roleRadioOptions"
              buttons
              name="radios-btn-default"
            ></b-form-radio-group>
            <!-- <b-form-radio-group
              v-model="join.roleType"
              :options="roleRadioOptions"
              plain
              name="radios-btn-default"
            ></b-form-radio-group> -->
          </div>
          <div class="form-button text-center">
            <button 
              type="button" class="btn btn-custom theme-color" 
              @click="clickJoinBtn">회원가입
            </button>
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
import { userService } from '@/lib/axios/service'
import * as HttpConstants from '@/constants/HttpConstants'

export default {
  name: 'SignUpPage',
  data () {
    return {
      showPassword: true,
      showConfirmPassword: true,
      join: {
        id: '',
        name: '',
        birthDate: '',
        password: '',
        confirmPassword: '',
        roleType: 'U001'
      },
      roleRadioOptions: [
        { text: '오팔회원', value: 'U001' },
        { text: '일반회원', value: 'U002' }
      ]
    }
  },
  methods: {
    clickJoinBtn: async function() {
      if (!this.validUserJoinInfo()) return
      
      const response = await userService.userJoin(this.join)

      if (response.status === HttpConstants.HTTP_SUCCESS_CDOE)
      alert('회원가입이 정상적으로 처리되었습니다.')
      this.$router.push('/signIn')
    },
    validUserJoinInfo: function() {
      const { id, name, birthDate, password, confirmPassword } = this.join
      const birthDateRegex = /^\d{4}-\d{2}-\d{2}$/

      if (id.length === 0) {
        alert("아이디를 입력하세요.")
        return false
      } else if (name.length === 0) {
        alert("이름을 입력하세요.")
        return false
      } else if (!birthDateRegex.test(birthDate)) {
        alert("생년월일을 정확하게 입력하여 주세요.")
        return false
      } else if (password.length === 0) {
        alert("비밀번호를 입력하여 주세.");
        return false
      } else if (password !== confirmPassword) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
        return false
      } 

      return true
    }
  }
}
</script>

<style>
  .btn {
    background-color: #FCCC5B !important
  }

  .btn.active {
    background-color: #18e7d3 !important
  }
</style>
