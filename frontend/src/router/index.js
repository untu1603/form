import { createRouter, createWebHistory } from 'vue-router'
import ListForm from "@/views/ListForm.vue";
import FormEdit from "@/views/FormEdit.vue";
import FormView from "@/views/FormView.vue";
import test from "@/views/test.vue";
import FormCreate from "@/views/FormCreate.vue";
import FormAnswer from "@/views/FormAnswer.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'listForm',
      component: ListForm
    },
    {
      path: '/edit/:id/:tab',
      name: 'formEditTab',
      component: FormEdit
    },
    {
      path: '/edit/:id',
      name: 'formEdit',
      component: FormEdit
    },
    {
      path: '/view/:id',
      name: 'formView',
      component: FormView
    },
    {
      path: '/create',
      name: 'formCreate',
      component: FormCreate
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/answer/:id',
      name: 'formAnswer',
      component: FormAnswer
    },
  ]
})

export default router
