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
  import {store} from '../store/store'
  export default {
    name: 'Home',
    components:{
      Header,
      Main,
      Footer
    },
    methods:{
      upload:function () {
        store.commit('uploadUsers')
      }
    }
  }
</script>

<style>
.container {
  margin: 0 auto;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family:
    'Quicksand',
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}
</style>
