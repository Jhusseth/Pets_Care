import Vue from 'vue'
import Router from 'vue-router'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _42aefaf7 = () => interopDefault(import('../pages/about.vue' /* webpackChunkName: "pages/about" */))
const _5558ed8a = () => interopDefault(import('../pages/contact.vue' /* webpackChunkName: "pages/contact" */))
const _2c0e78d3 = () => interopDefault(import('../pages/login.vue' /* webpackChunkName: "pages/login" */))
const _f782d096 = () => interopDefault(import('../pages/registerColl.vue' /* webpackChunkName: "pages/registerColl" */))
const _cbe165d8 = () => interopDefault(import('../pages/registerUser.vue' /* webpackChunkName: "pages/registerUser" */))
const _6266d5bc = () => interopDefault(import('../pages/index.vue' /* webpackChunkName: "pages/index" */))

// TODO: remove in Nuxt 3
const emptyFn = () => {}
const originalPush = Router.prototype.push
Router.prototype.push = function push (location, onComplete = emptyFn, onAbort) {
  return originalPush.call(this, location, onComplete, onAbort)
}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: decodeURI('/'),
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/about",
    component: _42aefaf7,
    name: "about"
  }, {
    path: "/contact",
    component: _5558ed8a,
    name: "contact"
  }, {
    path: "/login",
    component: _2c0e78d3,
    name: "login"
  }, {
    path: "/registerColl",
    component: _f782d096,
    name: "registerColl"
  }, {
    path: "/registerUser",
    component: _cbe165d8,
    name: "registerUser"
  }, {
    path: "/",
    component: _6266d5bc,
    name: "index"
  }],

  fallback: false
}

export function createRouter () {
  return new Router(routerOptions)
}
