<template>
  <div class ="d-flex justify-content-center container">
    <form class = "mt-4">
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">Enter the registered collaborator's email</small>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
        <small id="passwordHelp" class="form-text text-muted">Enter the registered collaborator's password</small>
      </div>
      <div class="d-flex justify-content-center mt-5">
        <router-link class="badge badge-light" style = "color: #000" to="/registerColl">¿You do not have an account?</router-link>
      </div>
      <div class="d-flex justify-content-center mt-3 mb-3">
        <!-- <button type="submit" class="btn btn-primary"> Log in</button> -->
        <v-btn small rounded color="primary" >Log in</v-btn>
      </div>
    </form>
  </div> 
</template>

<script>
export default {

}
</script>

<style scoped>

</style>