import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import vue3GoogleLogin from 'vue3-google-login'
import 'bootstrap/dist/css/bootstrap.css'
import "bootstrap"
import {BootstrapVue3} from 'bootstrap-vue-3'
import 'bootstrap-vue/dist/bootstrap-vue-icons.min.css'
const app = createApp(App)
const CLIENT_ID = "261703293557-0aa1tvmududgbosur0o3dleljfpsb90h.apps.googleusercontent.com"

app.use(createPinia())
app.use(router)
app.use(BootstrapVue3).use(vue3GoogleLogin,{ clientId: CLIENT_ID })
app.mount('#app')
