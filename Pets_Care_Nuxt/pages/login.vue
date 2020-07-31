<template>
    <div class= "rows">
        <div class= "row">
            <HeaderMenu/>
        </div>
        <div class= "rows ml-5">
            <div class= "row mt-3">
                <div class= " frame col-md-7 mt-5 ml-5 shadow rounded">
                    <div class= "row">
                        <div class= "col-md-5 mt-3">
                            <div class="ml-5">
                                <img src="https://t1.ea.ltmcdn.com/es/images/5/7/7/img_guia_completa_de_cuidados_de_un_perro_anciano_7775_600_square.jpg" class="card-img-top rounded-circle" alt="...">
                            </div>
                        </div>
                        <div class= "frame-title col-md-6 ml-3 mt-5 shadow rounded">
                            <div class="card-body mt-4">
                                <p class="card-text text-justify align-middle">
                                    ¡Todas las mascotas tienen cuidados distintos, dependiendo del tipo de animal que sea y de su raza!
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class= "row  mt-4">
                        <p class="card-text text-justify align-middle mr-4 ml-4">    
                            Ya sea un perro, gato, iguana, hamster o peces, cada uno necesita distintas atenciones, por eso es bueno siempre consultar con un veterinario.
                            Frecuentemente, los animales son mantenidos como compañeros domésticos.
                            La mejor manera de mantener a las mascotas saludables es satisfacer sus necesidades de bienestar de forma consistente.
                            Los grupos de bienestar animal usan la siguiente lista de control para juzgar si un animal está tan contento y saludable como sea posible. Su animal doméstico debe estar:
                        </p>
                        <p class="mr-4 ml-4">
                                – Libre de hambre y sed
                            <br>– Libre de incomodidad
                            <br>– Libre de dolor, lesiones y enfermedades
                            <br>– Libre de miedo y dolor
                            <br>– Libre para expresar comportamiento normal.</p>
                    </div>
                </div>
                <div class= "col-md-4 mt-5">
                    <div class= "d-flex justify-content-center">
                        <div>
                            <div class= "d-flex justify-content-center">
                                <div v-if="form" >
                                    <a href="#" class="badge badge-primary" v-on:click="chargeUser">login how user</a>
                                    <a href="#" class="badge badge-secondary" v-on:click="chargeColl">login how coll </a> 
                                </div>
                                <div v-else >
                                    <a href="#" class="badge badge-secondary" v-on:click="chargeUser">login how user</a>
                                    <a href="#" class="badge badge-primary" v-on:click="chargeColl">login how coll </a> 
                                </div>
                            </div>
                            <div v-if="form" class="user mt-5 shadow rounded">
                                <LoginUser/>
                            </div>
                            <div v-else class="coll mt-5 shadow rounded">
                                <LoginColl/>
                            </div>
                        </div>   
                    </div>    
                </div>
            </div>
        </div>
  </div>
</template>

<script>
    import LoginUser from '../components/LoginUser'
    import LoginColl from '../components/LoginColl'
    import HeaderMenu from '../components/HeaderMenu'

    export default {
        computed: {
            form(){
               return this.$store.state.rol
            }
        },
        components:{
            LoginUser,
            LoginColl,
            HeaderMenu
        },
        methods:{
            chargeUser: function (){
                this.$store.commit('changeRol',true)
            },
            chargeColl: function (){
                this.$store.commit('changeRol',false)
            }
        }

    }
</script>

<style scoped>

.user{
  background-color: rgba(255,255,255,0.30);
}
.coll{
    background-color: rgba(255,255,255,0.30);
}
.frame{
    background-color: rgba(255,255,255,0.40);
    color:black;

}
.frame-title{
    background-color: rgba(255,255,255,0.10);
    color:black;

}
</style>