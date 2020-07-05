<template>
  <div>
    <!--blog Section start-->
    <div class="page-margin">
      
      <Breadcrumb 
        title="기부"
        v-bind:breadcrumb="breadcrumb"
      />
      <!--blog Section start-->
      <section>
        <div class="container">
          <div class="row">
            <h1>나이스!</h1>
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
    name: 'myDonation',
  }
</script>