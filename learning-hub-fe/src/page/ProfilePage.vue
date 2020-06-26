<template>
  <div>
    <div class="page-margin">
      <Breadcrumb title="프로필" v-bind:breadcrumb="breadcrumb" />
      <section id="profile">
        <div class="team-item">
          <div class="team-block">
            <div class="team-box">
              <div class="team-avtar">
                <img :src="`/api/files/${userInfo.profileImageFileNo}`" alt="">
              </div>
              <div class="team-text">
                <h3>{{`${userInfo.name} (${userInfo.id})`}}</h3>
                <h6>{{ getCodeName('UserRoles', userInfo.roleType) }}</h6>                
              </div>
              <div class="overlay">
                <ul class="team-social">
                  <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                  <li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                  <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                  <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                  <li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </section>      
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import { Getters as CodeGetters } from '@/modules/store/types/code';

export default {
  name: 'ProfilePage',
  data() {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '프로필', to: '/profile'}
      ]
    }
  },
  computed: {
    ...mapState('user', ['userInfo']),
    ...mapState('code', ['codeMap']),    
    ...mapGetters('code', [CodeGetters.GET_CODE, CodeGetters.GET_CODE_NAME])
  }
}
</script>

<style>

</style>