<template>
    <div class= "rows">
        <div>
            <HeaderMenu/>
        </div>
        <div class= " lgapp rows" style="padding-top:5%">
            <div class= "row">
                <div class= " frame col-md-7 mt-5 container shadow rounded">
                    <v-card class= " mx-autorow d-flex justify-content-center">
                        <div class= "col-md-6 mt-3">
                            <div>
                                <img src="https://t1.ea.ltmcdn.com/es/images/5/7/7/img_guia_completa_de_cuidados_de_un_perro_anciano_7775_600_square.jpg" class="card-img-top rounded-circle">
                            </div>
                        </div>
                        <div class= "frame-title col-md-6" style="padding-top:17%">
                            <div class="card-body shadow ">
                                <h6 class="card-text text-justify">
                                    ¡Todas las mascotas tienen cuidados distintos, dependiendo del tipo de animal que sea y de su raza!
                                </h6>
                            </div>
                        </div>
                    </v-card>
                    <v-card class= "mx-auto row  mt-5">
                        <p class="card-text text-justify align-middle mr-4 ml-4">    
                            Ya sea un perro, gato, iguana, hamster o peces, cada uno necesita distintas atenciones, por eso es bueno siempre consultar con un veterinario.
                            Frecuentemente, los animales son mantenidos como compañeros domésticos.
                            La mejor manera de mantener a las mascotas saludables es satisfacer sus necesidades de bienestar de forma consistente.
                            Los grupos de bienestar animal usan la siguiente lista de control para juzgar si un animal está tan contento y saludable como sea posible. Su animal doméstico debe estar:
                        </p><br>
                        <ul class = " ml-5">
                            <li>Libre para expresar comportamiento normal</li>
                            <li>Libre de hambre y sed .................................. </li>
                            <li>Libre de incomodidad ...................................</li>
                            <li>Libre de dolor, lesiones y enfermedades ......</li>
                            <li>Libre de miedo y dolor ..................................</li>
                        </ul>
                    </v-card>
                </div>
                <div class= "col-md-4" style="padding-top:10%">
                    <div class= "d-flex justify-content-center">
                        <div>
                            <div class= "d-flex justify-content-center">
                                <div v-if="form" >
                                    <a class="badge badge-primary" style = "color: #FFF" v-on:click="chargeUser">login how user</a>
                                    <a class="badge bg-dark ml-1" style = "color: #FFF" v-on:click="chargeColl">login how coll </a> 
                                </div>
                                <div v-else >
                                    <a  class="badge bg-dark" style = "color: #FFF" v-on:click="chargeUser">login how user</a>
                                    <a  class="badge badge-primary ml-1" style = "color: #FFF" v-on:click="chargeColl">login how coll </a> 
                                </div>
                            </div>
                            <v-card v-if="form" class="user mt-5 shadow rounded">
                                <LoginUser/>
                            </v-card>
                            <v-card v-else class="coll mt-5 shadow rounded">
                                <LoginColl/>
                            </v-card>
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
</style>