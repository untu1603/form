<script>
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import { ref} from "vue";
import {FormModel} from "@/models/FormModel.js";
import {formStore} from "@/stores/form.js";
export default {
  components: {Navbar},
  setup() {
    const FormsRepository = RepositoryFactory.get('forms')
    const listForm = ref(Array<FormModel>([]));
    const storeForm = formStore()
    async function getAll() {
      const response = await FormsRepository.getAll()
      listForm.value = response.data
    }
    const createUrlForm = (formId) =>{
        return `\edit/${formId}`
    }
    const showForm = (form) =>{
      return form.header.toLowerCase().includes(storeForm.search.toLowerCase())
    }
    return {listForm, getAll, storeForm, createUrlForm,showForm}
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
      <div class="card" v-for="form in listForm" v-show=showForm(form)>
        <router-link class="no-underline" :to=createUrlForm(form.formId) @click="storeForm.form=form">
        <a>
        <img v-bind:src="form.screenShot"/>
        {{ form.header }}
        </a>
        </router-link>
      </div>
    </div>
  </div>
</template>

<style scoped>
.no-underline {
  text-decoration: none;
}
</style>
