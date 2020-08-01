import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    rol:true
  },
  mutations: {
    changeRol(state,rol) {
      state.rol=rol
    }
  },
  actions: {
  },
  modules: {
  }
})
