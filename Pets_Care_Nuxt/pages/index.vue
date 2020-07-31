<template>
  <div>
    <div class= "rows">
      <div class="row">
        <Header/>
      </div>
      <div class= "row">
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
    },
    methods:{

    }
  }
</script>

<style scoped>
</style>
