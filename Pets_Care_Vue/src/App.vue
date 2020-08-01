<template>
  <v-app app>
    <v-content app>
      <router-view/>
    </v-content>
    <div app style="padding-top:10%">
      <Footer/>
    </div>
  </v-app>
</template>

<script>

import Footer from './components/Footer'
export default {
  name: 'App',
  components:{
    Footer,
  }
}

</script>

<style scoped>
</style>
