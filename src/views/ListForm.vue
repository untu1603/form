<script>
import HomeView from "@/views/HomeView.vue";
import {RepositoryFactory} from "@/api/RepositoryFactory.js";
import {ref} from "vue";


export default {
  components: {HomeView},
  setup() {
const FormsRepository = RepositoryFactory.get('forms')
    const abc = ref();

    async function login(){

        const response= await FormsRepository.getAll()
            abc.value= response.data
        console.log(abc.value)

    }
  return {abc,login}
  },
  created()
  {
    this.login()
  },

}

</script>

<template>
<HomeView/>

</template>

<style scoped>

</style>
