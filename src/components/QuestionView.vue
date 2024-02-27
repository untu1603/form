<template>
  <b-form >
    <div class="row">
      <div class="col">
        <p>
          {{content}}
        </p>
      </div>
    </div>
    <b-form-group class="form-check" label="Question:" v-if="question.type == 1">
      <div v-for="(choice,index) in question.choices" >
          <input type="checkbox"
          >{{ question.choices[index] }}
      </div>
    </b-form-group>
    <textarea class="form-control" v-model="content" v-else></textarea>
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
    return {content ,storeForm, types,question, };
  },

};
</script>

