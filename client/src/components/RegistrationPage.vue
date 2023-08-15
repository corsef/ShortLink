<template>

  <!------ Include the above in your HEAD tag ---------->

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

  <div class="container">
    <div class="row justify-content-center WholeCard">
      <div class="col-md-6">
        <div  class="card">
          <header  class="card-header">

            <h4 class="card-title mt-2">Sign up</h4>
          </header>
          <article class="card-body">
            <form>
              <div class="form-row">

                <div class="col form-group">
                  <label>First Name</label>
                  <input type="text" class="form-control" ref="input" placeholder="" v-model="userInfo.firstName">
                </div> <!-- form-group end.// -->

                <div class="col form-group">
                  <label>Last name</label>
                  <input type="text" class="form-control" ref="input" placeholder="" v-model="userInfo.lastName">
                  <p>{{lastName}}</p>
                </div> <!-- form-group end.// -->

              </div> <!-- form-row end.// -->

              <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control" placeholder="">
              </div> <!-- form-group end.// -->

              <div class="form-group">
                <label>Create password</label>
                <input class="form-control" type="password">
              </div> <!-- form-group end.// -->
              <div class="form-group">
                <button type="submit" @click="addUser" class="btn btn-primary btn-block">Register</button>
              </div> <!-- form-group// -->
              </form>
          </article> <!-- card-body end .// -->
          <div class="border-top card-body text-center">Have an account?
            <router-link to="/login" v-slot="{navigate}">
              <a @click="navigate">Login</a>
          </router-link></div>
        </div> <!-- card.// -->
      </div> <!-- col.//-->

    </div> <!-- row.//-->


  </div>
  <!--container end.//-->

  <br><br>

</template>

<script>
import UserService from "@/services/UserService";
//import {ref} from "vue";


export default {

  data(){
    return {
      userInfo:{
      firstName: "",
      lastName: ""
    }}
  },
  methods:{
    addUser(){
      UserService.addUser(this.userInfo)
    }
  },
  created() {

  }
}


</script>


<style scoped>
.WholeCard{
  margin-top: 10%;
}

</style>