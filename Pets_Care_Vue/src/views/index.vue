<template>
  <div>
    <div class= " index rows">
      <div>
        <Header/>
      </div>
      <div class= "container">
        <Main/>
      </div> 
    </div>
  </div>
</template>

<script>
  import Main from '../components/Main'
  import Header from '../components/Header'

  export default {
    name: 'Home',
    components:{
      Header,
      Main
    }
  }
</script>

<style scoped>
</style>
