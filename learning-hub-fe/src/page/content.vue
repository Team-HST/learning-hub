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
              <Page
                totalCnt=100,
                pageCnt=5
              ></Page>
            </div>
            <div class="col-md-2 ml-auto">
              <button 
                type="button" class="btn btn-custom theme-color" 
                @click="clickToContentCreate"
              >등록하기</button>
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
  name: 'Content',
  data () {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'}
      ]
    }
  },
  methods: {
    clickToContentCreate : function () {
      this.$router.push('/contentCreate');
    }
  }
}
</script>
