<template>
 <div id="main_div">

   <!-- Home Section start-->
   <section id="home" class="home">
     <div class="home-decor">
       <div class="home-circle1"><img :src='"../assets/images/main-banner3.png"' alt=""></div>
       <div class="home-circle2"><img :src='"../assets/images/main-banner12.png"' alt=""></div>
       <div class="home-circle3"><img :src='"../assets/images/main-banner1.png"' alt=""></div>
     </div>
     <div class="container">
       <div class="row">
         <div class="col-md-5">
           <div class="home-contain">
             <div>
               <img :src='"../assets/images/logoimage.png"' alt="caption-img" class="caption-img">
               <h4>For connecting generations</h4>
               <h1>L<span class="f-bold">e</span>a<span class="f-bold">n</span>i<span class="f-bold">n</span>g
                 <span class="f-bold f-color">hub</span>
               </h1>
               <p>Enhance your business ideas with Powerful, Responsive, Elegant TOVO Theme.</p>
               <a href="#"><img :src='"../assets/images/appstore.png"' alt="appstore" class="store"></a>
               <a href="#"><img class="ml-10 store" :src='"../assets/images/play-store.png"' alt="play-store"></a>
             </div>
           </div>
         </div>
         <div class="col-sm-6 offset-md-1">
           <div class="home-right">
             <!-- Tile js start -->
             <!-- <tilt :image = '"mobile.png"'/> -->
             <!-- Tile js end -->
           </div>
         </div>
       </div>
     </div>
   </section>
   <!--Home Section End -->

   <About />

  </div>  
</template>
  
<script>
import { mapState, mapActions } from 'vuex'

export default {
  computed: {
    ...mapState('code', ['codeMap'])
  },
  created() {
    this.initCodeMap();
    console.log(this.codeMap['user-roles'])
  },
  methods: {
    ...mapActions('code', ['initCodeMap'])
  }
}
</script>
