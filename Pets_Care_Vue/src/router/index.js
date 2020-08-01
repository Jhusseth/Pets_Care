import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/index.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/login.vue')
  },
  {
    path: '/registerUser',
    name: 'RegisterUser',
    component: () => import('../views/registerUser.vue')
  },
  {
    path: '/registerColl',
    name: 'RegisterColl',
    component: () => import('../views/registerColl.vue')
  },
  {
    path: '/contact',
    name: 'Contact',
    component: () => import('../views/contact.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/about.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
