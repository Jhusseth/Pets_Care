<template>
  <footer>
    <div class="card text-center shadow-sm rounded">
      <div class="card-body shadow-sm rounded">
      </div>
      <div class=" footer shadow rounded">
         ©Titancorp
      </div>
    </div>
  </footer>
</template>

<script>
export default {
    name: 'Footer'
}
</script>

<style scoped>
.card{
  background-color: rgba(255,255,255,0.50);
  color:black;
}
.footer{
  background-color: rgba(255,255,255,0.70);
  color:black;
}

footer{
  width: 100%;
  position:static;
}
</style>