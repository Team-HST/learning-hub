<template>
  <div>
    <!--blog Section start-->
    <div class="page-margin">
      <!--breadcrumb start-->
      <Breadcrumb 
        title="컨텐츠 상세"
        v-bind:breadcrumb="breadcrumb"
      />
      <!--breadcrumb end -->

      <!-- blog Section starts -->
      <section>
        <div class="container">
          <div class="row">
            <div class="col-sm-12">
              <div class="blog-item">
                <div>
                  <div class="blog-box">
                    <div class="overflow-hidden">
                      <videoPlayer
                        :options="playerOptions"
                      />
                    </div>
                  </div>
                </div>
                <div class="blog-text">
                  <h6>{{getFormatDate}}</h6>
                  <a href="#">
                    <h3 class="blog-head">{{getContentDetail.title}}</h3>
                  </a>
                  <div class="blog-divider"></div>
                  <div class="blog-description">
                    <!-- <img :src='"@/assets/images/blog/blog-details.jpg"' alt="blog" class="img-fluid img-banner"> -->
                    <p>{{getContentDetail.contents}}</p>
                  </div>
                </div>
              </div>
              <div class="blog-divider"></div>
              <div class="reply-comment">
                <div class="media">
                  <img class="align-self-top mr-3" :src='"@/assets/images/blog/blog-comment.jpg"' alt="blog">
                  <div class="media-body">
                    <router-link  :to="{name:'Blog_details'}">
                      <h5 class="mt-0">Lorem Ipsum Is Simply Dummy</h5>
                    </router-link>
                    <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.Donec sed odio dui.</p>
                  </div>
                </div>
                <div class="media">
                  <img class="align-self-top mr-3" :src='"@/assets/images/blog/blog-comment-two.jpg"' alt="blog">
                  <div class="media-body">
                    <router-link  :to="{name:'Blog_details'}">
                      <h5 class="mt-0">Lorem Ipsum has been the</h5>
                    </router-link>
                    <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.Donec sed odio dui.</p>
                  </div>
                </div>
                <div class="media">
                  <img class="align-self-top mr-3" :src='"@/assets/images/blog/blog-comment-three.jpg"' alt="blog">
                  <div class="media-body">
                    <router-link  :to="{name:'Blog_details'}">
                      <h5 class="mt-0">all the Lorem Ipsum Generator</h5>
                    </router-link>
                    <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
                  </div>
                </div>
              </div>
              <div class="blog-divider"></div>
              <div class="row">
                <div class="col-md-10 offset-md-1 leave-coment">
                  <h3 class="text-center">Leave Your Comment</h3>
                  <form class="theme-form footer-form p-0 mt-3">
                    <div class="form-group">
                      <div class="row">
                        <div class="col-lg-6 col-md-12 md-fgrup-margin">
                          <input type="text" class="form-control" placeholder="your name">
                        </div>
                        <div class="col-lg-6 col-md-12">
                          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="email address">
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" placeholder="message"></textarea>
                    </div>
                    <div class="form-button">
                      <button type="submit" class="btn btn-custom theme-color">send</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!--blog Section End-->

      <!--Footer Section start-->
      <Footer/>
      <js/>
      <!--Footer Section End-->

    </div>
    <!--blog Section end -->
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import { DateUtils } from '@/utils/common'
import { videoPlayer } from 'vue-video-player'
import 'video.js/dist/video-js.css'

export default {
  name: 'ContentDetail',
  components: {
    videoPlayer
  },
  data() {
    return {
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'},
        {name: '컨텐츠 상세', to: '/contentDetail'}
      ],
      playerOptions: {
        language: 'en',
        playbackRates: [0.7, 1.0, 1.5, 2.0],
        sources: [{
          type: "video/mp4",
          src: '/api/files/'+this.getVideoSource
        }],
        poster: "/static/images/author.jpg",
      }
    }
  },
  computed: {
    ...mapGetters('content', ['getContentDetail']),
    getFormatDate: function () {
      const createAt = DateUtils.getDateFormatStr(
        this.getContentDetail.createAt, 'YYYY년 MM월 DD일'
      )
      return createAt
    },
    getVideoSource: function () {
      return this.getContentDetail.contentFiles.filter(file => 
        file.fileTypeCode === 'F002'
      )[0].fileNo
    }
  },
  methods: {
    ...mapActions('content', ['searchContentDetail'])
  },
  created() {
    this.searchContentDetail(this.$route.params.srno)
  }
}
</script>

<style scoped>
</style>