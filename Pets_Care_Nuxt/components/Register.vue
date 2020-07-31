<template>
    <div class= "rows">
        <div class= "row">
            <HeaderRegister/>
        </div>
        <div class= "d-flex justify-content-center mt-4">
            <form>
                <div class=" form-r row shadow rounded">
                    <div class="col mt-2 mb-3">
                        <label for="identification">Cédula</label>
                        <input type="number" class="form-control" id="identification" aria-describedby="idHelp">

                        <label for="lastName">Apellidos</label>
                        <input type="text" class="form-control" id="lastName" aria-describedby="lastNameHelp">

                        <label for="password">Contraseña</label>
                        <input type="password" class="form-control" id="password" aria-describedby="passwordHelp">

                        <label for="City">Ciudad</label>
                        <input type="text" class="form-control" id="city" aria-describedby="cityHelp">

                        <label for="phone">Teléfono</label>
                        <input type="number" class="form-control" id="phone" aria-describedby="phoneHelp">
                    </div>
                    <div class="col mb-3 mt-2">
                        <label for="name">Nombres</label>
                        <input type="text" class="form-control" id="name" aria-describedby="nameHelp">

                        <label for="email">Correo</label>
                        <input type="email" class="form-control" id="email" aria-describedby="emailHelp">

                        <label for="department">Departamento</label>
                        <input type="text" class="form-control" id="department" aria-describedby="departmentHelp">

                        <label for="address">Dirección</label>
                        <input type="text" class="form-control" id="address" aria-describedby="addressHelp">

                        <label for="celphone">Celular</label>
                        <input type="number" class="form-control" id="celphone" aria-describedby="celphoneHelp">
                    </div>
                </div>
                <div class= "row form-d d-flex justify-content-center mb-3">
                    <div class= "d-flex justify-content-center mt-3">
                    <label for="description">Descripción</label>
                    </div>
                    <textarea 
                        name = "Decription" 
                        class="form-control ml-3 mr-3 mb-3"
                        id="description" 
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