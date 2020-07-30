<template>
  <div>
    <div class= "rows">
      <div class="row">
        <Header/>
      </div>
      <div class= "mt-3">
        <Main/>
      </div>
      <div class="row"> 
        <Footer/>
      </div>  
    </div>
  </div>
</template>

<script>
  import Main from '../components/Main'
  import Header from '../components/Header'
  import Footer from '../components/Footer'

  export default {
    name: 'Home',
    components:{
      Header,
      Main,
      Footer
    },
    methods:{

    }
  }
</script>

<style scoped>
</style>
