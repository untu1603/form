<template>
  <b-form >
    <div class="row">
      <div class="col">
        <p>
          {{question.content}}
        </p>
      </div>
    </div>
    <b-form-group class="form-check" >
        <div class="radio-align m-1" v-for="choice in question.choices"  :key="choice" >
          <input type="radio"  v-model="content.multipleChoice" :value="choice"  v-if="question.type == 1">
          <input type="checkbox" v-model="content.checkBox" :value="choice"  v-else-if="question.type == 2">
          <textarea class="form-control" v-model="content.paragraph" v-else></textarea>
          <label  v-if="question.type != 3" class="ms-1" >{{ choice }}</label>
        </div>
    </b-form-group>

  </b-form>
</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
import {answerStore} from "@/stores/answer.js";
export default {
  props: {
    index: Number
  },
  components: {},
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const content = answerStore().answer.contents[props.index]
    const types = ref([
      { value: 1, text: 'Multiple choice' },
      { value: 2, text: 'Paragraph' },
    ]);
    const answer = ref(null)
    return {answer ,storeForm, types,question, content};
  },

};
</script>
<style>
.radio-align {
  display: flex;
  align-items: center;
}
</style>
