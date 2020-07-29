<template>
  <div>
    <HeaderMenu/>
    <div class= "row mt-5">
        <div class= "col-8">
            <div class="card">
                <img src="https://education.health.ufl.edu/files/2014/05/pet-sitting-pg.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
        </div>
        <div class= "col-4">
            <div class= "d-flex justify-content-center">
                <div class= "row">
                    <div class = "ml-5 container-fluid">
                        <div v-if="form" >
                            <a href="#" class=" ml-5 badge badge-primary" v-on:click="chargeUser">login how user</a>
                            <a href="#" class="badge badge-secondary" v-on:click="chargeColl">login how coll </a> 
                        </div>
                        <div v-else>
                            <a href="#" class=" ml-5 badge badge-secondary" v-on:click="chargeUser">login how user</a>
                            <a href="#" class="badge badge-primary" v-on:click="chargeColl">login how coll </a> 
                        </div>
                    </div>
                    <div class= "container-fluid" v-if="form">
                        <LoginUser/>
                    </div>
                    <div class= "container-fluid" v-else>
                        <LoginColl/>
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

<style>

</style>