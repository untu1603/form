<script>
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import { ref} from "vue";
import {formStore} from "@/stores/form.js";
import {FormClass} from "@/models/FormModel.js";
import {TrashIcon} from "@heroicons/vue/24/outline";
export default {
  components: {Navbar,TrashIcon},
  setup() {
    const FormsRepository = RepositoryFactory.get('forms')
    const listForm = ref(null);
    const storeForm = formStore()
    async function getAll() {
      const response = await FormsRepository.getAll()
      listForm.value = response.data
    }
    const createUrlForm = (formId) =>{
        return `edit/${formId}`
    }
    const showForm = (form) =>{
      return form.header.toLowerCase().includes(storeForm.search.toLowerCase())
    }
    async function deleteForm(formId) {
      await FormsRepository.deleteForm(formId).then(response =>{
          getAll()
      })
    }
    return {listForm, getAll, storeForm, createUrlForm,showForm,deleteForm}
  },
  created() {
    this.getAll()
  },
}
</script>
<template>
  <Navbar></Navbar>
  <div id="home">
    <router-link to="create">
    <b-button variant="success" class="card-create" >
      <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"/>
      </svg>
    </b-button>
    </router-link>
    <div class="wrapper">
      <div class="card" v-for="form in listForm" v-show=showForm(form)>
        <router-link class="no-underline" :to=createUrlForm(form.formId) @click="storeForm.form=form">
        <a class="text-truncate no-underline">
        <img v-bind:src="form.screenShot"/>
        {{ form.header }}
        </a>
        </router-link>
          <trash-icon class="icon" @click="deleteForm(form.formId)"/>

      </div>
    </div>
  </div>
</template>

<style scoped>
.no-underline {
  text-decoration: none;
}
</style>
