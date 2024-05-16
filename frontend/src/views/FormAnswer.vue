<script>
import {formStore} from "@/stores/form.js";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import QuestionAnswer from "@/components/QuestionAnswer.vue";
import {answerStore} from "@/stores/answer.js";

export default {
  components: {QuestionAnswer,  },
  setup() {
    const storeForm = formStore()
    const storeAnswer = answerStore()
    const FormsRepository = RepositoryFactory.get('forms')
    const AnswerRepository = RepositoryFactory.get('answers')
    const listQuestion = ref()
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
      listQuestion.value =storeForm.form.questions
      storeAnswer.createAnswerNew(listQuestion.value.length)
    }
    async function createAnswer() {
      storeAnswer.answer.userId=storeForm.userIdMock
      storeAnswer.answer.formId=storeForm.form.formId
      console.log(storeAnswer.answer)

      const response = await AnswerRepository.create(storeAnswer.answer)
      console.log(storeAnswer.answer)
    }
    return { storeForm,getForm,listQuestion,createAnswer}
  },
  mounted() {
      const id = this.$route.params.id;
      this.getForm(id)
  },
}
</script>
<template>
  <body>
  <div id="home" >
    <main class="container ">
      <div  class="card-view">
        <h1> {{ storeForm.form.header }}</h1>
        <p> {{storeForm.form.description}}</p>
      </div>
      <div v-for="(question,index) in listQuestion" :key="question.content" class="card-view">
        <QuestionAnswer :index="index" ></QuestionAnswer>
      </div>
      <div class="d-flex flex-row-reverse">
        <b-button @click="createAnswer()" variant="danger" class="">Save</b-button>
      </div>
    </main>
    <br/>
  </div>
  </body>
</template>
<style scoped>
body {
  background-color: #e8e1dc;
}
.card-view {
  box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px;
  margin: 10px;
  background-color: #ffffff;
  border-radius: 10px;
  padding: 12px;
}
</style>
