<script>
import {formStore} from "@/stores/form.js";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import QuestionView from "@/components/QuestionView.vue";


export default {
  components: {QuestionView,  },
  setup() {
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    const listQuestion = ref()
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
      listQuestion.value =storeForm.form.questions
    }
    return { storeForm,getForm,listQuestion,}
  },
  created() {
    if (this.storeForm.form.formId == null ) {
      const id = this.$route.params.id;
      this.getForm(id)
    }
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
        <QuestionView :index="index" ></QuestionView>
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
