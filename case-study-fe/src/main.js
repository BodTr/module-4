import './assets/tabler/css/tabler.min.css'
import './assets/tabler/css/tabler-flags.min.css'
import './assets/tabler/css/tabler-payments.min.css'
import './assets/tabler/css/tabler-vendors.min.css'
import './assets/tabler/css/demo.min.css'
import "vue-toastification/dist/index.css"

import { createApp } from 'vue'
import router from './router'
import axios from 'axios'
import Toast from "vue-toastification"
import App from './App.vue'

window.axios = axios
axios.defaults.baseURL = import.meta.env.VITE_BASE_URL



const app = createApp(App)

app.use(router)
app.use(Toast,{
    position: "top-center",
    timeout: 5000,
    closeOnClick: true,
    pauseOnFocusLoss: true,
    pauseOnHover: true,
    draggable: true,
    draggablePercent: 0.6,
    showCloseButtonOnHover: false,
    hideProgressBar: false,
    closeButton: "button",
    icon: true,
    rtl: false
})

app.mount('#app')

import 'bootstrap/dist/js/bootstrap.js'