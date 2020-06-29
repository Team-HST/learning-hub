  <template>
    <div>
      <div class="page-margin">
        <breadcrumb title="컨텐츠 등록" :breadcrumb="breadcrumb" />
        <section id="content-create">
          <div class="innerpage-decor">
            <div class="innerpage-circle1"><img :src='"@/assets/images/Testimonial2.png"' alt=""></div>
            <div class="innerpage-circle2"><img :src='"@/assets/images/Testimonial1.png"' alt=""></div>
          </div>
          <div class="content_create">
            <div class="container">
              <div class="row">
                <div class="col-md-12">
                  <div class="theme-form">
                    <div class="form-group">
                        <input 
                          type="text" class="form-control"
                          v-model="title"
                          placeholder="제목을 입력하여 주세요." required="required"
                          maxlength=49
                        />
                    </div>
                    <div class="form-group">
                      <textarea 
                        class="form-control" 
                        id="message" name="message" 
                        v-model="contents"
                        rows="8" placeholder="내용을 입력하여 주세요." 
                        required="required"
                      ></textarea>
                    </div>
                    <div class="form-group">
                      <b-form-select
                        class="form-control"
                        v-model="jobSelected"
                      >
                        <template v-slot:first>
                          <b-form-select-option :value="null" disabled>
                            -- 직무분야를 선택하세요. --
                          </b-form-select-option>
                        </template>

                        <b-form-select-option
                          v-for="jobClass in jobClassTypes" :key="jobClass.code"
                          :value="jobClass.code">
                          {{jobClass.codeName}}
                        </b-form-select-option>
                      </b-form-select>
                    </div>
                    <div class="form-group">
                      <b-form-select
                        class="form-control"
                        v-model="donRangeSelected"
                      >
                        <template v-slot:first>
                          <b-form-select-option :value="null" disabled>
                            -- 기부율을 선택하세요. --
                          </b-form-select-option>
                        </template>

                        <b-form-select-option
                          v-for="donRange in 10" :key="donRange"
                          :value="donRange * 10">
                          {{donRange * 10}}%
                        </b-form-select-option>
                      </b-form-select>
                    </div>
                    <div class="form-group">
                      <create-file-input
                        id="banner_file"
                        :placeholder="this.bannerFile ? this.bannerFile.name : '배너이미지를 선택하여 주세요.'"
                        btnText="파일찾기"
                        accept="image/jpg, image/png"
                        :change="changeBannerFile"
                      />
                    </div>
                    <div class="form-group">
                      <create-file-input
                        id="video_file"
                        :placeholder="this.videoFile ? this.videoFile.name : '영상을 선택하여 주세요.'"
                        btnText="파일찾기"
                        accept="video/avi, video/mp4, video/mkv"
                        :change="changeVideoFile"
                      />
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
        </section>
    </div>
    <footer />
    <js />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import { contentService } from '@/lib/axios/service'
import { Getters as CodeGetters } from '@/modules/store/types/code';
import CreateFileInput from '@/components/common/CreateFileInput';


export default {
  name: 'ContentCreatePage',
  components: {
    CreateFileInput
  },
  data() {
    return {
      title: '',
      contents: '',
      jobSelected: null,
      donRangeSelected: null,
      bannerFile: null,
      videoFile: null,
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'},
        {name: '컨텐츠 등록', to: '/contentCreate'}
      ],
      jobClassTypes: []
    }
  },
  computed: {
    ...mapGetters('code', [CodeGetters.GET_CODE_GROUP])
  },
  created() {
    this.jobClassTypes = this.getCodeGroup('JobCategories', code => ({ codeName: code.codeName, code: code.code }))
  },
  methods: {
    clickContentCreate: async function() {
      const formData = new FormData()

      formData.append('title', this.title)
      formData.append('contents', this.contents)
      formData.append('registrantNo', 13)
      if (this.jobSelected) {
        formData.append('jobCategory', this.jobSelected)
      } else {
        alert('직무분야를 선택하여 주세요.')
      }
      if (this.donRangeSelected) {
        formData.append('donationRatio', this.donRangeSelected)
      } else {
        alert('기부율을 선택하여 주세요.')
      }
      if (this.bannerFile)
      formData.append('thumbnail', this.bannerFile)
      if (this.videoFile) {
        formData.append('mainContent', this.videoFile)
      } else {
        alert('영상은 필수입니다.')
        return;
      }
      await contentService.createContent(formData)
      this.$router.push('/contents')
    },
    changeBannerFile: function(event) {
      const file = event.target.files

      if (file.length > 0) {
        this.bannerFile = file[0]
      } else {
        this.bannerFile = null
      }
    },
    changeVideoFile: function(event) {
      const file = event.target.files
      
      if (file.length > 0) {
        this.videoFile = file[0]
      } else {
        this.videoFile = null
      }
    }
  }
}
</script>

<style scoped>
section {
  padding-top: 19px;
  padding-bottom: 19px;
}
</style>