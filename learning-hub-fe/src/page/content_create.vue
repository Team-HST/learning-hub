  <template>
    <div>
      <!--blog Section start-->
      <div class="page-margin">

        <!--breadcrumb start-->
        <Breadcrumb 
          title="컨텐츠 등록"
          v-bind:breadcrumb="breadcrumb"
        />
        <!--breadcrumb end -->

        <!-- sign in -->
        <section>
          <div class="innerpage-decor">
            <div class="innerpage-circle1"><img :src='"@/assets/images/Testimonial2.png"' alt=""></div>
            <div class="innerpage-circle2"><img :src='"@/assets/images/Testimonial1.png"' alt=""></div>
          </div>
          <!--content_create in -->
          <div class="content_create">
            <div class="container">
              <div class="row">
                <div class="col-md-12">
                  <div class="theme-form">
                    <div class="form-group">
                        <input 
                          type="text" class="form-control" 
                          placeholder="제목을 입력하여 주세요." required="required"
                          maxlength=49
                        />
                    </div>
                    <div class="form-group">
                      <textarea 
                        class="form-control" 
                        id="message" name="message" 
                        rows="8" placeholder="내용을 입력하여 주세요." 
                        required="required"
                      ></textarea>
                    </div>
                    <div class="form-button text-center">
                      <button 
                        type="button" class="btn btn-custom theme-color" 
                        @click="clickContentCreate">등록하기
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content_create up -->
        </section>
        <!-- sign up -->
      <!--blog Section end-->
    </div>
    <!--Footer Section start-->
    <Footer/>
    <js/>
    <!--Footer Section End-->
  </div>
</template>

<script>
export default {
  name: 'content_create',
  data() {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'},
        {name: '컨텐츠 등록', to: '/contentCreate'}
      ]
    }
  },
  methods: {
    clickContentCreate: function() {
      alert('등록')
    }
  }
}
</script>

<style scoped>
section {
  padding-top: 50px;
}
</style>