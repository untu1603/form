<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import {QuestionModel} from "@/models/FormModel.js";


export default {
  components: {Question, Navbar},
  setup() {
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    const listQuestion = ref(Array<QuestionModel>([]))
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
      listQuestion.value =storeForm.form.questions
    }
    async function saveForm() {
      await FormsRepository.createForm(storeForm.form)
    }
    return { storeForm,getForm,listQuestion,saveForm}
  },
  created() {
    if (this.storeForm.form.value == null ) {
      const id = this.$route.params.id;
      this.getForm(id)
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
      <input class="form-control fs-2" v-model="storeForm.form.header" >
      <textarea class="w-50 mt-1 rounded form-control fs-4"  v-model="storeForm.form.header"></textarea>
    </div>
  <div v-for="(question,index) in listQuestion" :key="question.content" class="cardquest">
    <Question :index="index" ></Question>
  </div>
    <b-button @click="saveForm" variant="danger">Save</b-button>
  </main>
  </div>
  </body>
</template>
<style scoped>
body {
  background-color: #e8e1dc;
}
</style>
