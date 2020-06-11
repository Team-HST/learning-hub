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
              <div class="form-row">
                <div class="col-10">
                  <input 
                    type="text" class="form-control digits mb-1 search-text"
                    :value="getSearchInput"
                    @input="changeSearchInput"
                    placeholder="제목를 입력하여 주세요."
                  />
                </div>
                <div class="col-2">
                  <button 
                    class="btn btn-custom theme-color"
                    @click="clickSearchBtn"
                  >검색</button>
                </div>
              </div>
              <ContentList />
            </div>
            <!-- sidebar section -->
            <ContentLeftside />
            <!-- sidebar section -->
            <!-- paginations -->
            <div class="col-md-12">
              <Page
                :clickPageNum="clickPageNum"
                :totalPage="getTotalPage"
                :pageNum="getPageNum"
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
import { mapMutations, mapGetters, mapActions } from 'vuex';

export default {
  name: 'Content',
  data () {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'}
      ],
    }
  },
  computed: {
    ...mapGetters('content', ['getPageNum', 'getTotalPage', 'getSearchInput'])
  },
  created() {
    this.searchContentPageList()
  },
  methods: {
    ...mapActions('content', ['searchContentPageList']),
    ...mapMutations('content', ['initPageNum', 'setPageNum', 'setSearchInput', 'setSearchTitle']),
    clickToContentCreate: function () {
      this.$router.push('/contentCreate');
    },
    clickPageNum: function (pageNum) {
      // 선택 페이지 변경
      this.setPageNum(pageNum);
      // 컨텐츠 조회
      this.searchContentPageList();
    },
    clickSearchBtn: function () {
      this.setSearchTitle(this.getSearchInput)
      // 현재 페이지 초기화
      this.initPageNum()
      // 컨텐츠 조회
      this.searchContentPageList();
    },
    changeSearchInput: function (e) {
      this.setSearchInput(e.target.value)
    }
  }
}
</script>

<style scoped>
.search-text {
  min-height: 42px;
  font-size: 12px;
  border: none;
  border-radius: 20px;
  padding: 12px 30px;
  box-shadow: 0 0 5px 0 rgba(170, 170, 170, 0.15);
}

.form-row {
  margin-bottom: 15px;
}
</style>
