import Vue from 'vue'
import Vuex from 'vuex'
import Env from  '../static/env'
import Axios from 'axios'

Vue.use(Vuex)

export const store = new Vuex.Store( {
    state:{
        rol :true,
        users: [
            {
            id: 1,
            name: 'Juan'
            }
        ]
    },
    mutations:{
        uploadUsers(state){
            Axios.get(Env.endpoint + "/users").then(response=>{
                state.users = response.data
            })
        },
        changeRol(state,rol){
            state.rol = rol
        }

    }
})

