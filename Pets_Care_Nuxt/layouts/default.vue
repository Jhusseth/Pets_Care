<template>
  <div class= "app">
    <Nuxt />  
    <footer>
      <Footer/>
    </footer>
  </div>
</template>


<script>
import Footer from '../components/Footer' 
export default {
  comments:{
    Footer
  }
}
</script>

<style scoped>
.app{
  background-image:url("../assets/background3.jpg");
  flex:0%;
}
</style>
