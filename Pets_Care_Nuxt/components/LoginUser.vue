<template>
  <div class ="d-flex justify-content-center container-fluid mt-5">
    <form>
      <div class="d-flex justify-content-center mb-5">
         <h4 for="rol">** Logging in as user **</h4>
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">Enter the registered user's email</small>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
        <small id="passwordHelp" class="form-text text-muted">Enter the registered user's password</small>
      </div>
      <div class="d-flex justify-content-center mt-5">
        <a href="/registerUser" class="badge badge-light">¿You do not have an account?</a>
      </div>
      <div class="d-flex justify-content-center mt-3">
        <button type="submit" class="btn btn-primary"> Log in</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
    name: 'LoginUser'
}
</script>

<style>

</style>