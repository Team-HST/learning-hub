<template>
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
        <h3>{{content.title}}</h3>
        <p>{{content.contents}}</p>
      </router-link>
      <h5>{{content.registrant.name}}</h5>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    content: Object
  }
}
</script>