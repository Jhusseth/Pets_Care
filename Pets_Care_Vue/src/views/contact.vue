<template>
  <div class= "rows">
        <div>
            <HeaderMenu/>
        </div>
      <div class= "container d-flex justify-content-center">
          <h2> Developing</h2>
      </div>
  </div>
</template>

<script>
    import HeaderMenu from '../components/HeaderMenu'
    export default {
        components:{
            HeaderMenu
        }
    }
</script>

<style scoped>
@media (max-width: 700px) {
.container{
    padding-top:15%;
}
}
@media (max-width: 1366px) {
.container{
    padding-top:15%;
}
}
</style>