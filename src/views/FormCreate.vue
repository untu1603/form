<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import {FormClass, QuestionClass, QuestionModel} from "@/models/FormModel.js";
import { PlusIcon} from "@heroicons/vue/24/outline/index.js";


export default {
  components: { Question, Navbar, PlusIcon},
  setup() {
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
    }
    async function saveForm() {
      const response= await FormsRepository.createForm(storeForm.form)
      storeForm.form=response.data
    }
    const createQuestion = () => {
      storeForm.form.questions.push(new QuestionClass(1))
    }
    const createUrlForm = (formId) =>{
      return `edit/${formId}`
    }
    return {createUrlForm, storeForm,getForm,saveForm,createQuestion}
  },

  created() {
      if (this.storeForm.form.formId == null) {
        this.storeForm.form = new FormClass("header")
      }
  },
}
</script>
<template>
<Navbar></Navbar>
  <body>
  <div id="home" >
  <main class="container ">
    <div  class="cardquest">
      <input class="form-control fs-2" v-model="this.storeForm.form.header" >
      <textarea class="w-50 mt-1 rounded form-control fs-4"  v-model="storeForm.form.description"></textarea>
    </div>
  <div v-for="(question,index) in storeForm.form.questions"  class="cardquest">
    <Question :index="index" ></Question>
  </div>
    <plus-icon @click="createQuestion" class="icon"/>
    <div class="d-flex flex-row-reverse">
      <router-link :to=createUrlForm(storeForm.form.formId)>
      <b-button @click="saveForm" variant="danger" class="">Save</b-button>
      </router-link>
    </div>
  </main>
  </div>
  </body>
</template>
<style scoped>
body {
  background-color: #e8e1dc;
}
</style>
