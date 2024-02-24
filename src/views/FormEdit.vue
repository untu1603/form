<script>
import {formStore} from "@/stores/form.js";
import Question from "@/components/Question.vue";
import Navbar from "@/components/Navbar.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";
import {FormModel} from "@/models/FormModel.js";


export default {
  components: {Navbar},
  setup() {
    const storeForm = formStore()
    const FormsRepository = RepositoryFactory.get('forms')
    // const form = ref(FormModel);
    async function getForm(id) {
      const response = await FormsRepository.getForm(id)
      storeForm.setForm(response.data)
    }
    return { storeForm,getForm}
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
  <div id="home">
  <div v-for="abc in storeForm.form.questions">
    <h1>{{ abc }}</h1>
  </div>
  </div>
</template>

<style scoped>

</style>
