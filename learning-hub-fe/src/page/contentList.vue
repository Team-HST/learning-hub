<template>
  <div>

    <!--blog Section start-->
    <div class="page-margin">
      <!--breadcrumb start-->
      <div class="breadcrumb-bg">
        <div class="container">
          <div class="row">
            <div class="col-md-6 col-sm-6 col-text-center d-align-center">
              <h2 class="title"><span> CONTENTS </span></h2>
            </div>
            <div class="col-md-6 col-sm-6 col-text-center">
              <nav aria-label="breadcrumb" class="blog-bradcrumb ">
                <ol class="breadcrumb bg-transparent mb-0">
                  <li class="breadcrumb-item"><router-link :to='"/tovo"'>Home</router-link></li>
                  <li class="breadcrumb-item"><router-link :to='"/tovo/blog-list"'>Blog</router-link></li>
                  <li class="breadcrumb-item active"><a href="#">Left Sidebar</a></li>
                </ol>
              </nav>
            </div>
          </div>
        </div>
      </div>
      <!--breadcrumb end -->

      <!--blog Section start-->
      <section>
        <div class="container">
          <div class="row">
            <div class="col-md-8 col-lg-9 blog-sec">
              <div class="row blog-list">
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/blog3.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/6.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/7.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/8.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/9.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
                <div class="col-lg-6 col-md-12">
                  <div class="blog-item">
                    <div class="blog-block">
                      <div class="blog-box">
                        <div class="overflow-hidden"><router-link :to="{ name: 'Blog_details' }"><img :src='"../assets/images/blog/9.jpg"' alt="blog" class="img-fluid"></router-link></div>
                      </div>
                    </div>
                    <div class="blog-text">
                     <router-link :to="{ name: 'Blog_details' }">
                        <h3>There are many variations of passages.</h3>
                        <p>Lorem Ipsum Is Simply Dummy Text Of The Printing And Typesetting Industry Lorem .</p>
                     </router-link>
                      <h5>Mark jkcno</h5>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- sidebar section -->
            <contentLeftside></contentLeftside>
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
  name: 'contentList',
  methods: {
      moveContentForm : function () {
          this.$router.push('contentForm');
      }
  }
}
</script>
