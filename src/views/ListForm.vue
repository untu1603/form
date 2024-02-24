<script>
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import {FormModel} from "@/models/FormModel.js";
import Question from "@/components/Question.vue";
import {formStore} from "@/stores/form.js";
export default {
  components: {Navbar,Question},
  setup() {
    const FormsRepository = RepositoryFactory.get('forms')
    const abc = ref(Array < FormModel > ([]));
    const storeForm = formStore()
    async function getAll() {
      const response = await FormsRepository.getAll()
      abc.value = response.data
      console.log(abc.value)

    }
    const createUrlForm = (formId) =>{
        return `\edit/${formId}`
    }
    return {abc, getAll, storeForm, createUrlForm}
  },
  created() {
    this.getAll()
  },
}
</script>
<template>
  <Navbar></Navbar>
  <div id="home">
    <b-button variant="success" class="card-create" >
      <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"/>
      </svg>
    </b-button>
    <div class="wrapper">
      <li class="card" v-for="form in abc" >
        <router-link class="no-underline" :to=createUrlForm(form.formId) @click="storeForm.setForm(form)">
        <a>
        <img v-bind:src="form.screenShot"/>
        {{ form.header }}
        </a>
        </router-link>
      </li>
    </div>
  </div>

</template>

<style scoped>
.no-underline {
  text-decoration: none;
}
</style>
