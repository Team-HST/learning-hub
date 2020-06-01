<template>
  <div class="breadcrumb-bg">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-sm-6 col-text-center d-align-center">
          <h2 class="title"><span> {{title}} </span></h2>
        </div>
        <div class="col-md-6 col-sm-6 col-text-center">
          <nav aria-label="breadcrumb" class="blog-bradcrumb">
            <ol class="breadcrumb bg-transparent mb-0">
              <li v-for="item in breadcrumb" :key="item.name" class="breadcrumb-item">
                <router-link :to="item.to">{{item.name}}</router-link>
              </li>


              <!-- <li class="breadcrumb-item"><router-link :to='"/tovo"'>Home</router-link></li>
              <li class="breadcrumb-item"><router-link :to='"/tovo/blog-list"'>Blog</router-link></li>
              <li class="breadcrumb-item active"><a href="#">Left Sidebar</a></li>  -->
            </ol>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'breadcrumb',
  props: {
    title: String,
    breadcrumb: Array
  }
}
</script>