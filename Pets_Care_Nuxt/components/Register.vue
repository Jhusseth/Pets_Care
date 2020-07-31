<template>
    <div class= "rows">
        <div class= "row">
            <HeaderRegister/>
        </div>
        <div class= "d-flex justify-content-center mt-4">
            <form>
                <div class=" form-r row shadow rounded">
                    <div class="col mt-2 mb-3">
                        <label for="exampleInputEmail1">Cédula</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Apellidos</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Contraseña</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Ciudad</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Teléfono</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="col mb-3 mt-2">
                        <label for="exampleInputEmail1">Nombres</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Correo</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Departamento</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Dirección</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="exampleInputEmail1">Celular</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                </div>
                <div class= "row form-d d-flex justify-content-center mb-3">
                    <div class= "d-flex justify-content-center mt-3">
                    <label for="exampleInputEmail1">Descripción</label>
                    </div>
                    <textarea 
                        name = "Decription" 
                        class="form-control ml-3 mr-3 mb-3"
                        id="exampleInputEmail1" 
                        rows="2">
                    </textarea>
                </div>    
            </form>
        </div>
    </div>
</template>

<script>
import HeaderRegister from '../components/HeaderRegister'
export default {
    name: 'Register',
    components:{
        HeaderRegister
    }
}
</script>

<style scoped>

.form-r{
    background-color: rgba(255,255,255,0.20);
    color:black;
}
.form-d{
    background-color: rgba(255,255,255,0.15);
    color:black;
}

</style>