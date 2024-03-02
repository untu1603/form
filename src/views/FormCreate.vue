<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {FormClass, QuestionClass,} from "@/models/FormModel.js";
import { PlusIcon} from "@heroicons/vue/24/outline/index.js";
import {useRouter} from "vue-router";


export default {
  components: { Question, Navbar, PlusIcon},
  setup() {
    const storeForm = formStore()
    const router = useRouter();
    const FormsRepository = RepositoryFactory.get('forms')
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
    }
     const saveForm=()=> {
      FormsRepository.createForm(storeForm.form).then(
          response => {
            storeForm.form=response.data
            router.push(`edit/${storeForm.form.formId}`)
          }
      )

    }
    const createQuestion = () => {
      storeForm.form.questions.push(new QuestionClass(1))
    }

    return { storeForm,getForm,saveForm,createQuestion}
  },
  created() {
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
      <b-button @click="saveForm" variant="danger" class="">Save</b-button>
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
