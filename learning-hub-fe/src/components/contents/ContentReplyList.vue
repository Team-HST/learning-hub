<template>
  <div>
    <div class="reply-comment">
      <div class="media">
        <img class="align-self-top mr-3" :src='"@/assets/images/blog/blog-comment.jpg"' alt="blog">
        <div class="media-body">
          <h5 class="mt-0">Lorem Ipsum Is Simply Dummy</h5>
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
</template>

<script>
export default {
  name: 'ContentReplyList'
}
</script>

<style>

</style>