<template>
  <b-form >
    <div class="row">
      <div class="col">
        <p>
          {{content}}
        </p>
      </div>
    </div>
    <b-form-group class="form-check" >
        <div class="radio-align m-1" v-for="choice in question.choices"  :key="choice.id" >
          <input type="radio"  v-model="answer" :value="choice.content"  v-if="question.type == 1">
          <input type="checkbox" :value="choice.content"  v-else-if="question.type == 2">
          <textarea class="form-control" v-model="content" v-else></textarea>
          <label  v-if="question.type != 3" class="ms-1" >{{ choice.content }}</label>
        </div>
    </b-form-group>

  </b-form>
</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
export default {
  props: {
    index: Number
  },
  components: {},
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const content= question.content
    const types = ref([
      { value: 1, text: 'Multiple choice' },
      { value: 2, text: 'Paragraph' },
    ]);
    const answer = ref(null)
    return {answer,content ,storeForm, types,question, };
  },
};
</script>
<style>
.radio-align {
  display: flex;
  align-items: center;
}
</style>
