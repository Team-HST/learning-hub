<template>
 <div id="main_div">
   <!-- Home Section start-->
   <section id="home" class="home">
     <div class="home-decor">
       <div class="home-circle1"><img :src='"@/assets/images/main-banner3.png"' alt=""></div>
       <div class="home-circle2"><img :src='"@/assets/images/main-banner12.png"' alt=""></div>
       <div class="home-circle3"><img :src='"@/assets/images/main-banner1.png"' alt=""></div>
     </div>
     <div class="container">
       <div class="row">
         <div class="col-md-5">
           <div class="home-contain">
             <div>
               <img :src='"@/assets/images/logoimage.png"' alt="caption-img" class="caption-img">
               <h4>For connecting generations</h4>
               <h1>L<span class="f-bold">e</span>a<span class="f-bold">n</span>i<span class="f-bold">n</span>g
                 <span class="f-bold f-color">hub</span>
               </h1>
               <p>경험을 공유하고, 도움이 얻은 컨텐츠에 후원하세요.</p>
             </div>
           </div>
         </div>
       </div>
     </div>
   </section>
   <!--Home Section End -->
  </div>  
</template>
  
<script>
import { mapState, mapActions } from 'vuex' 
import { Actions as CodeActions } from '@/modules/store/types/code';
import { CODE, USER } from '@/modules/store/types/namespaces';

export default {
  name: 'HomePage',
    computed: {
    ...mapState(CODE, ['codeMap', 'isCodeSetting']),
    ...mapState(USER, ['userInfo', 'signedIn'])
  },
  methods: {
    ...mapActions(CODE, [CodeActions.INIT_CODE_MAP]),
  },
  created () {
    if (!this.is) {
      this[CodeActions.INIT_CODE_MAP]();
    }    
  }
}
</script>
