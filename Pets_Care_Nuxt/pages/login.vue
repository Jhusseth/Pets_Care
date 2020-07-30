<template>
    <div class= "rows">
        <div class= "row">
            <HeaderMenu/>
        </div>
        <div class= "rows">
            <div class= "row mt-3 ">
                <div class= "col-7 ml-5">
                    <div class="card ml-5 shadow rounded">
                        <img src="https://education.health.ufl.edu/files/2014/05/pet-sitting-pg.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                </div>
                <div class= "col-4 mt-5">
                    <div class= "d-flex justify-content-center">
                        <div class= "row d-flex justify-content-center">
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
  background: #21252924;
  background-color:rgba(33, 37, 41, 0.14);
}
.coll{
    background: #21252924;
    background-color:rgba(33, 37, 41, 0.14);
}
</style>