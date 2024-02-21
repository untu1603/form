import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.css'
import BootstrapVue3 from 'bootstrap-vue-3'
const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(BootstrapVue3)
app.mount('#app')
