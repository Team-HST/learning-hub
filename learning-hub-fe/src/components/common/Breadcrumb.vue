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
            </ol>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Breadcrumb',
  props: {
    title: String,
    breadcrumb: Array
  }
}
</script>