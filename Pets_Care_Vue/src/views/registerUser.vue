<template>
    <div>
        <div>
            <Register/>
        </div>
        <div class= "d-flex justify-content-center" style="padding-top:3%">
            <v-btn tile fill color="primary">Registrar</v-btn>
        </div>
    </div>
</template>
<script>
import Register from '../components/Register'
export default {
    name: 'RegisterUser',
    components:{
       Register
    }
}
</script>

<style scoped>

</style>