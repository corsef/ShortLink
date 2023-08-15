<template>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<div>
  <nav class="navbar navbar-expand-lg navbar-light p-lg-3" style="background-color: #76c7f5">
    <a class="navbar-brand ms-lg-2" href="#">LinkSH</a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <form class="ms-auto">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Login
            </a>
          </li>

        </ul>
<!--        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
      </form>
    </div>
  </nav>
</div>



  <router-link to="/login"></router-link>
  <router-link to="/registration"></router-link>
  <router-view></router-view>


</template>

<script>
//import LoginPage from "@/components/LoginPage.vue";
//import RegistrationPage from "@/components/RegistrationPage.vue";
import {RouterLink} from "vue-router";
export default {
  name: 'App',
  computed: {
  },
  components: {
    RouterLink,


  }
}
</script>

<style>

</style>
