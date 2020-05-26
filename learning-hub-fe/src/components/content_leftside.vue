<template>
    <div class="col-md-4 col-lg-3 order-md-first list-sidebar">
        <div class="sidebar">
        <div class="sidebar-space">
            <h4 class="blog-title">blog Category</h4>
            <div class="blog-divider"></div>
            <div class="blog-cat-detail">
            <ul>
                <li class="marg-15">
                <router-link :to="{ name: 'Blog_details' }">
                    <i class="fa fa-angle-right" aria-hidden="true"></i> Lorem Ipsum is simply
                </router-link>
                </li>
                <li class="marg-15">
                <router-link :to="{ name: 'Blog_details' }">
                    <i class="fa fa-angle-right" aria-hidden="true"></i> There Are Many Variations
                </router-link>
                </li>
                <li class="marg-15">
                <router-link :to="{ name: 'Blog_details' }">
                    <i class="fa fa-angle-right" aria-hidden="true"></i> it has survived not only five
                </router-link>
                </li>
                <li class="marg-15">
                <router-link :to="{ name: 'Blog_details' }">
                    <i class="fa fa-angle-right" aria-hidden="true"></i> Lorem Ipsum has been the.
                </router-link>
                </li>
                <li class="marg-15">
                <router-link :to="{ name: 'Blog_details' }">
                    <i class="fa fa-angle-right" aria-hidden="true"></i> Lorem Ipsum is random.
                </router-link>
                </li>
            </ul>
            </div>
        </div>
        <div class="sidebar-space">
            <h4 class="blog-title">Popular Tag</h4>
            <div class="blog-divider"></div>
            <div class="tags marg-20">
            <a href="#"><span class="badge badge-theme">Responsive design</span></a>
            <a href="#"><span class="badge badge-theme">Color options</span></a>
            <a href="#"><span class="badge badge-theme">Multiple demos</span></a>
            <a href="#"><span class="badge badge-theme">Dedicated support</span></a>
            <a href="#"><span class="badge badge-theme">Documentation</span></a>
            <a href="#"><span class="badge badge-theme">PSD is included</span></a>
            <a href="#"><span class="badge badge-theme">Text</span></a>
            <a href="#"><span class="badge badge-theme">Support</span></a>
            <a href="#"><span class="badge badge-theme">Responsive</span></a>
            <a href="#"><span class="badge badge-theme">Design</span></a>
            </div>
        </div>
        <h4 class="blog-title">Recent Post</h4>
        <div class="blog-divider"></div>
        <div class="recent-blog marg-20">
            <div class="media">
            <img class="mr-3" :src='"../assets/images/blog/1.jpg"' alt="blog">
            <div class="media-body">
                <router-link :to="{ name: 'Blog_details' }">
                <h5 class="mt-0">Lorem Ipsum Is Simply Dummy</h5>
                </router-link>
                <p class="m-0">05 March 2011</p>
            </div>
            </div>
            <div class="media">
            <img class="mr-3" :src='"../assets/images/blog/2.jpg"' alt="blog">
            <div class="media-body">
                <router-link :to="{ name: 'Blog_details' }">
                <h5 class="mt-0">Lorem Ipsum has been the</h5>
                </router-link>
                <p class="m-0">14 january 2015</p>
            </div>
            </div>
            <div class="media">
            <img class="mr-3" :src='"../assets/images/blog/3.jpg"' alt="blog">
            <div class="media-body">
                <router-link :to="{ name: 'Blog_details' }">
                <h5 class="mt-0">all the Lorem Ipsum Generator</h5>
                </router-link>
                <p class="m-0">30 November 2015</p>
            </div>
            </div>
        </div>
        </div>
    </div>
</template>
<script>
export default {
  name: 'contentLeftside'
}
</script>
