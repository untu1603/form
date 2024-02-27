import { createRouter, createWebHistory } from 'vue-router'
import ListForm from "@/views/ListForm.vue";
import FormEdit from "@/views/FormEdit.vue";
import FormView from "@/views/FormView.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'listForm',
      component: ListForm
    },
    {
      path: '/edit/:id',
      name: 'formEdit',
      component: FormEdit
    },
    {
      path: '/view',
      name: 'formView',
      component: FormView
    },
  ]
})

export default router
