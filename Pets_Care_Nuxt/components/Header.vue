<template>
  <div class = "container mt-3">
    <nav class="navbar navbar-expand-lg shadow rounded">
        <a class="navbar-brand" href="#">PETSCARE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact">Contact Us<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">About</a>
                </li>
            </ul>
        </div>
    </nav>
  </div> 
</template>

<script>
export default {
    name : 'Header'
}
</script>

<style scoped>

nav{
    background-color: rgba(255,256,255,0.50);
}
.navbar-brand{
    color:black
}
.nav-link{
    color:black
}

</style>