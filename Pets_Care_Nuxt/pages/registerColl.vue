<template>
    <div>
        <Register/>
        <div class= "d-flex justify-content-center mt-3">
            <button type="submit" class="btn btn-primary">Registrar</button>
        </div>
    </div>
</template>

<script>
import Register from '../components/Register'
export default {
    name: 'RegisterColl',
     components:{
        Register
    }
}
</script>

<style scoped>

.row{
    background: #343a4036;
}
.form-group{
    background: #343a4036;
}

</style>