export { default as Footer } from '../../components/Footer.vue'
export { default as Header } from '../../components/Header.vue'
export { default as HeaderMenu } from '../../components/HeaderMenu.vue'
export { default as LoginColl } from '../../components/LoginColl.vue'
export { default as LoginUser } from '../../components/LoginUser.vue'
export { default as Logo } from '../../components/Logo.vue'
export { default as Main } from '../../components/Main.vue'

export const LazyFooter = import('../../components/Footer.vue' /* webpackChunkName: "components/Footer'}" */).then(c => c.default || c)
export const LazyHeader = import('../../components/Header.vue' /* webpackChunkName: "components/Header'}" */).then(c => c.default || c)
export const LazyHeaderMenu = import('../../components/HeaderMenu.vue' /* webpackChunkName: "components/HeaderMenu'}" */).then(c => c.default || c)
export const LazyLoginColl = import('../../components/LoginColl.vue' /* webpackChunkName: "components/LoginColl'}" */).then(c => c.default || c)
export const LazyLoginUser = import('../../components/LoginUser.vue' /* webpackChunkName: "components/LoginUser'}" */).then(c => c.default || c)
export const LazyLogo = import('../../components/Logo.vue' /* webpackChunkName: "components/Logo'}" */).then(c => c.default || c)
export const LazyMain = import('../../components/Main.vue' /* webpackChunkName: "components/Main'}" */).then(c => c.default || c)
