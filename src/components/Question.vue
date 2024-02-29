<template>
  <b-form >
    <div class="row">
      <div class="col">
        <textarea class="form-control" v-model="question.content"></textarea>
      </div>
      <div class="col-3">
        <b-form-select
            v-model="question.type"
            :options="types"
        ></b-form-select>
      </div>
    </div>
    <b-form-group  label="Question:" v-if="question.type != 3">
      <div v-for="(choice,index) in question.choices" >
        <div class="d-inline-flex w-50 mt-2">
          <stop-icon class="icon"/>
        <b-form-input
          class="form-control-sm"
          placeholder="Option"
          v-model="question.choices[index]"
          required
        ></b-form-input>
        <x-mark-icon  class="icon" @click="onDeleteChoice(index)"/>
        </div>
      </div>
      <plus-icon @click="createChoice" class="icon"/>
    </b-form-group>
    <trash-icon @click="onDelete" class="icon"/>
    <arrow-path-icon @click="onReset" class="icon"/>
  </b-form>
</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
import { TrashIcon, ArrowPathIcon, XMarkIcon, StopIcon,PlusIcon} from '@heroicons/vue/24/outline';

export default {
  props: {
    index: Number
  },
  components: { TrashIcon, ArrowPathIcon ,XMarkIcon, StopIcon, PlusIcon},
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]

    const types = ref([
      { value: 1, text: 'Multiple choice' },
      { value: 2, text: 'Checkboxes' },
      { value: 3, text: 'Paragraph' },
    ]);
    const createChoice = () => {
      question.choices.push('')
    };
    const onDelete = () => {
      storeForm.form.questions.splice(props.index,1)
    };
    const onDeleteChoice = (id) => {
      question.choices.splice(id,1)
    };
    const onReset = () => {
    };
    return {storeForm, types, onDelete, onReset, question,createChoice,onDeleteChoice };
  },

};
</script>

