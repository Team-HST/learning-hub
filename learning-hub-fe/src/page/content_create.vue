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
                    <div class="form-group">
                      <b-form-select
                        class="form-control"
                        v-model="jobSelected"
                      >
                        <template v-slot:first>
                          <b-form-select-option :value="null" disabled
                            >-- 직무분야를 선택하세요. --
                          </b-form-select-option>
                        </template>

                        <b-form-select-option
                          v-for="classes in getCodeMap['job-classes']" :key="classes.code"
                          :value="classes.code">
                          {{classes.codeName}}
                        </b-form-select-option>
                      </b-form-select>
                    </div>
                    <div class="form-group">
                      <b-form-select
                        class="form-control"
                        v-model="donRangeSelected"
                      >
                        <template v-slot:first>
                          <b-form-select-option :value="null" disabled
                            >-- 기부율을 선택하세요. --
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
                      <div class="form-row">
                        <div class="col-4">
                          <label for="file" class="btn btn-custom theme-color">파일찾기</label>
                          <input type="file" id="file">
                        </div>
                        <div class="col-8">
                          <input type="tel" value="파일을 선택하여 주세요." class="form-control digits mb-1">
                        </div>
                      </div>
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
import { mapGetters } from 'vuex';

export default {
  name: 'ContentCreate',
  data() {
    return {
      jobSelected: null,
      donRangeSelected: null,
      breadcrumb: [
        {name: '홈', to: '/'},
        {name: '컨텐츠', to: '/contents'},
        {name: '컨텐츠 등록', to: '/contentCreate'}
      ]
    }
  },
  computed: {
    ...mapGetters('code', ['getCodeMap'])
  },
  methods: {
    clickContentCreate: function() {
      console.log(this.getCodeMap['job-classes'][0])
      alert('등록')
    }
  }
}
</script>

<style scoped>
section {
  padding-top: 50px;
  padding-bottom: 50px;
}

.form-group label {
  display: inline-block;
  width: 100%;
}

.form-group input[type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>