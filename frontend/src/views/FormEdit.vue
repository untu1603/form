<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import { QuestionClass, } from "@/models/FormModel.js";
import { PlusIcon} from "@heroicons/vue/24/outline/index.js";
import {useRoute} from "vue-router";
import exportExcel from "@/components/function/exportExcel.js";
import {ref, watch} from "vue";
import html2canvas from "html2canvas";


export default {
  components: { Question, Navbar, PlusIcon},
  setup() {
    const  route  = useRoute();
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    const AnswerRepository = RepositoryFactory.get('answers')

    const openStatistic = () => route.params.tab != 'statistic' ? true : false;

    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.form=response.data
    }
    watch(() => route.params.tab, (newTab) => {
      if (newTab == 'statistic') {
        getStatistic(route.params.id)
      }
    })
    const framework =ref()
    async function getStatistic(id) {
      const response = await AnswerRepository.statistic(id)
       framework.value = response.data.formAnswers
        console.log(framework.value)

    }
    async function updateForm() {
      const home = document.querySelector('#home')
      const canvas = await html2canvas(home)
      storeForm.form.screenShot = canvas.toDataURL()
      await FormsRepository.updateForm(storeForm.form.formId,storeForm.form)
    }
    const createQuestion = () => {
      storeForm.form.questions.push(new QuestionClass(1))
    };

    function buildExcel (){
      exportExcel(framework.value)
    }
    return {getStatistic, storeForm,getForm,updateForm,createQuestion,openStatistic,buildExcel}
  },
  created() {
    const id = this.$route.params.id;
      if (this.storeForm.form.formId == null) {
        this.getForm(id)
      }
    if (this.$route.params.tab == 'statistic') {
      this.getStatistic(id)
    }
  },

}
</script>
<template>
<Navbar></Navbar>
  <body>
  <div id="home" >
  <main class="container " v-if="openStatistic()">
    <div  class="cardquest">
      <input class="form-control fs-2" v-model="this.storeForm.form.header" >
      <textarea class="w-50 mt-1 rounded form-control fs-4"  v-model="storeForm.form.description"></textarea>
    </div>
  <div v-for="(question,index) in storeForm.form.questions"  class="cardquest">
    <Question :index="index" ></Question>
  </div>
    <plus-icon @click="createQuestion" class="icon"/>
    <div class="d-flex flex-row-reverse">
      <b-button @click="updateForm" variant="danger" class="">Save</b-button>
    </div>
  </main>
    <main class="container " v-else>
      <div  class="cardquest">
      <img src="https://cdn2.iconfinder.com/data/icons/flat-file-types-1-1/300/icon_file-CSV_plano-512.png" @click="buildExcel" variant="danger" class="iconc"/>
        <a> Export excel</a>
      </div>
    </main>
  </div>
  </body>
</template>
<style scoped>
body {
  background-color: #e8e1dc;
}
.iconc
{
  width: 25px;
  height: 25px;
}
</style>
