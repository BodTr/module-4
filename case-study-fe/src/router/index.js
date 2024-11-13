import { createRouter, createWebHistory } from "vue-router";
import ClBookList from '../views/ClBookList.vue'
import AdBooksManager from "@/views/AdBooksManager.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_FE_URL),
    base: '/#/',
    routes: [
        {
            path: '/',
            name: 'home-page',
            component: ClBookList
        },
        {
            path: '/books-manager',
            name: 'books-manager',
            component: AdBooksManager
        }
    ]
})

export default router