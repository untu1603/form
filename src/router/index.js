import { createRouter, createWebHistory } from 'vue-router'
import ListForm from "@/views/ListForm.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
      path: '/',
      name: 'homes',
      component: ListForm
    },
  ]
})

export default router
