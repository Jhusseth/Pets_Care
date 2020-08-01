<template>
  <v-app app>
    <v-content app>
      <router-view/>
    </v-content>
    <v-footer app>
      <Footer/>
    </v-footer>
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
