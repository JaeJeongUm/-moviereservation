
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReserveReserveManager from "./components/listers/ReserveReserveCards"
import ReserveReserveDetail from "./components/listers/ReserveReserveDetail"

import TicketInventoryManager from "./components/listers/TicketInventoryCards"
import TicketInventoryDetail from "./components/listers/TicketInventoryDetail"


import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reserves/reserves',
                name: 'ReserveReserveManager',
                component: ReserveReserveManager
            },
            {
                path: '/reserves/reserves/:id',
                name: 'ReserveReserveDetail',
                component: ReserveReserveDetail
            },

            {
                path: '/tickets/inventories',
                name: 'TicketInventoryManager',
                component: TicketInventoryManager
            },
            {
                path: '/tickets/inventories/:id',
                name: 'TicketInventoryDetail',
                component: TicketInventoryDetail
            },


            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },



    ]
})
