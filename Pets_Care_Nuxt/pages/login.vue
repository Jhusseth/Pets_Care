<template>
  <div class= "container-fluid">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">PETSCARE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active ">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
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
    import {store} from '../store/store'
    export default {
        computed: {
            form(){
               return store.state.rol
            }
        },
        components:{
            LoginUser,
            LoginColl
        },
        methods:{
            chargeUser: function (){
                store.commit('changeRol',true)
            },
            chargeColl: function (){
                store.commit('changeRol',false)
            }
        }

    }
</script>

<style>

</style>