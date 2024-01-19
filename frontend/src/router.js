
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FrontOrderManager from "./components/listers/FrontOrderCards"
import FrontOrderDetail from "./components/listers/FrontOrderDetail"

import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"

import RiderFoodDeliveryManager from "./components/listers/RiderFoodDeliveryCards"
import RiderFoodDeliveryDetail from "./components/listers/RiderFoodDeliveryDetail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/fronts/orders',
                name: 'FrontOrderManager',
                component: FrontOrderManager
            },
            {
                path: '/fronts/orders/:id',
                name: 'FrontOrderDetail',
                component: FrontOrderDetail
            },

            {
                path: '/stores/orders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/stores/orders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },

            {
                path: '/riders/foodDeliveries',
                name: 'RiderFoodDeliveryManager',
                component: RiderFoodDeliveryManager
            },
            {
                path: '/riders/foodDeliveries/:id',
                name: 'RiderFoodDeliveryDetail',
                component: RiderFoodDeliveryDetail
            },

            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },



    ]
})
