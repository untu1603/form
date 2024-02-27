<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import {QuestionModel} from "@/models/FormModel.js";
import {ArrowPathIcon, PlusIcon} from "@heroicons/vue/24/outline/index.js";
import QuestionView from "@/components/QuestionView.vue";


export default {
  components: {QuestionView, ArrowPathIcon, Question, Navbar, PlusIcon},
  setup() {
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    const listQuestion = ref(Array<QuestionModel>([]))
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
      listQuestion.value =storeForm.form.questions
    }
    return { storeForm,getForm,listQuestion,}
  },
  created() {
    if (this.storeForm.form.value == null ) {
      const id = '44f54e46-a322-4550-bed7-7e273f8b3fae';
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
        <h1> {{ storeForm.form.header }}</h1>
        <p> {{storeForm.form.description}}</p>
      </div>
      <div v-for="(question,index) in listQuestion" :key="question.content" class="cardquest">
        <QuestionView :index="index" ></QuestionView>
      </div>
      <plus-icon class="icon"/>
    </main>
  </div>
  </body>
</template>
<style scoped>
body {
  background-color: #e8e1dc;
}
</style>
