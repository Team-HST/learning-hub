<template>
  <div class="col-lg-6 col-md-12">
    <div class="blog-item">
      <div class="blog-block">
        <div class="blog-box">
          <div class="overflow-hidden">
            <router-link :to="{ name: 'Blog_details' }">
              <img :src='"@/assets/images/blog/9.jpg"' alt="blog" class="img-fluid">
            </router-link>
            </div>
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
</template>

<script>
export default {
  
}
</script>