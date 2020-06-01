<template>
  <div>
    <!--blog Section start-->
    <div class="page-margin">
      
      <Breadcrumb 
        title="컨텐츠"
        v-bind:breadcrumb="breadcrumb"
      />
      <!--blog Section start-->
      <section>
        <div class="container">
          <div class="row">
            <div class="col-md-8 col-lg-9 blog-sec">
              <ContentList />
            </div>
            <!-- sidebar section -->
            <ContentLeftside />
            <!-- sidebar section -->
            <!-- paginations -->
            <div class="col-md-12">
              <nav aria-label="Page navigation" class="blog-pagination">
                <ul class="pagination justify-content-center blog-pagin">
                  <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                      <i class="fa fa-angle-left" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li class="page-item active"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                      <i class="fa fa-angle-right" aria-hidden="true"></i>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
            <div class="col-md-2 ml-auto">
              <button type="button" class="btn btn-custom theme-color" @click="moveContentForm">등록하기</button>
            </div>
            <!-- paginations end-->
          </div>
        </div>
      </section>
      <!--blog Section End-->

      <!--Footer Section start-->
      <Footer/>
      <js/>
      <!--Footer Section End-->

    </div>
    <!-- blog Section end -->
  </div>
</template>
<script>
export default {
  name: 'content',
  data () {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'}
      ]
    }
  },
  methods: {
    moveContentForm : function () {
      this.$router.push('contentForm');
    }
  }
}
</script>
