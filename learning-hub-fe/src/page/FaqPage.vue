<template>
  <div class="page-margin">
    <Breadcrumb title="FAQ" v-bind:breadcrumb="breadcrumb" />
    <!-- sign in -->
    <section>
      <div class="innerpage-decor">
        <div class="innerpage-circle1"><img :src='"../assets/images/Testimonial2.png"' alt=""></div>
        <div class="innerpage-circle2"><img :src='"../assets/images/Testimonial1.png"' alt=""></div>
      </div>
      <!--faq in -->
      <div class="faq">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div role="tablist" id="accordion">
                <div class="card border-theme mb-3 radius-0">
                  <div v-b-toggle.collapseOne  class="card-header" role="tab" >
                    <a class="">Collapsible Group Item #1 <i class="fa fa-angle-down float-right"></i></a>
                  </div>

                  <b-collapse id="collapseOne" role="tabpanel"  visible  accordion="my-accordion" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                  </b-collapse>
                </div>
                <div class="card border-theme mb-3 radius-0">
                  <div v-b-toggle.collapseTwo class="card-header" role="tab" >
                    <a class="" >Collapsible Group Item #2 <i class="fa fa-angle-down float-right"></i></a>
                  </div>
                  <b-collapse id="collapseTwo" class="collapse show" accordion="my-accordion" role="tabpanel" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                  </b-collapse>
                </div>
                <div class="card border-theme mb-3 radius-0">
                  <div  v-b-toggle.collapseThree class="card-header" >
                    <a class="" >Collapsible Group Item #3 <i class="fa fa-angle-down float-right"></i></a>
                  </div>
                  <b-collapse id="collapseThree" class="collapse show" accordion="my-accordion" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                  </b-collapse>
                </div>
                <div class="card border-theme radius-0">
                  <div  class="card-header" v-b-toggle.collapseFour >
                    <a class="" >Collapsible Group Item #4 <i class="fa fa-angle-down float-right"></i></a>
                  </div>
                  <b-collapse id="collapseFour" role="tablist" accordion="my-accordion" class="collapse show" aria-labelledby="headingFour" data-parent="#accordion">
                    <div class="card-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                  </b-collapse>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>

export default {
  name: 'FaqPage',
  data() {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: 'FAQ', to: '/faq'}
      ]
    }
  }
}
</script>
