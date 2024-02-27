<template>
  <b-form >
    <div class="row">
      <div class="col">
        <textarea class="form-control" v-model="content"></textarea>
      </div>
      <div class="col-3">
        <b-form-select
            v-model="question.type"
            :options="types"
        ></b-form-select>
      </div>
    </div>
    <b-form-group  label="Question:" v-if="question.type == 1">
      <div v-for="(choice,index) in question.choices" >
      <b-form-input
          class="form-control form-control-sm"
          placeholder="Option"
          v-model="question.choices[index]"
          required
      ></b-form-input>
      </div>
      <b-button @click="createChoice" variant="primary">+</b-button>
    </b-form-group>
    <b-button @click="onDelete" variant="primary">Delete</b-button>
    <b-button @click="onReset" variant="danger">Reset</b-button>
  </b-form>

</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
export default {
  props: {
    index: Number
  },
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const content= question.content
    const types = ref([
      { value: 1, text: 'Multiple choice' },
      { value: 2, text: 'Paragraph' },
    ]);
    const createChoice = () => {
      question.choices.push('')
    };
    const onDelete = () => {
      storeForm.form.questions.splice(props.index,1)
    };
    const onReset = () => {
    };
    return {content ,storeForm, types, onDelete, onReset, question,createChoice };
  },

};
</script>

