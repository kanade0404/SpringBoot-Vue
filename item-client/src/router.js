import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home'
import firebase from 'firebase'

Vue.use(Router)

let router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            meta: { requiresAuth: true }
        },
        {
            path: '/category',
            name: 'category',
            component: () => import('./views/Category'),
            meta: { requiresAuth: true }
        },
        {
            path: '/signin',
            name: 'signin',
            component: () => import('./views/Signin')
        },
        {
            path: '/signup',
            name: 'signup',
            component: () => import('./views/Signup')
        }
    ]
})

router.beforeEach((to, from, next) => {
    const requiresAuth = to.matched.some(record => record.meta.requiresAuth)
    if(requiresAuth){
        firebase.auth().onAuthStateChanged(function(user){
            if(user){
                next()
            }else{
                next({
                    path: '/signin',
                    query: {redirect: to.fullPath}
                })
            }
        })
    }else{
        next()
    }
})
export default router
