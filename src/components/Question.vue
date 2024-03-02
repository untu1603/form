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
    <b-form-group  label="Answer:" v-if="question.type != 3">
      <div v-for="(choice,index) in question.choices" >
        <div class="d-inline-flex w-50 mt-2">
          <stop-icon class="icon"/>
        <b-form-input
          class="form-control-sm"
          placeholder="Option"
          v-model="question.choices[index].content"
          required
        ></b-form-input>
        <x-mark-icon  class="icon" @click="onDeleteChoice(index)"/>
        </div>
      </div>
      <plus-icon @click="createChoice" class="icon"/>
    </b-form-group>
    <b-form-group v-else >
      <div>
        <div class="d-inline-flex w-50 mt-2">
          <input type="checkbox" v-model="isRegE">
          <b-form-input :disabled = !isRegE
              class="form-control-sm "
              placeholder="Regex Expression"
              v-model="question.regexExpression"
              required
          ></b-form-input>
      </div>
      </div>
      <div>
        <div class="d-inline-flex w-50 mt-2">
          <input type="checkbox" v-model="isSize">
          <label class="mx-2">Size</label>
          <b-form-input :disabled = !isSize
                        class="form-control-sm"
                        type="number"
                        v-model="question.size"
                        required
          ></b-form-input>
        </div>
      </div>
    </b-form-group>
    <trash-icon @click="onDelete" class="icon"/>
  </b-form>
</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
import { TrashIcon, ArrowPathIcon, XMarkIcon, StopIcon,PlusIcon} from '@heroicons/vue/24/outline';
import {isRegExp} from "eslint-plugin-vue/lib/utils/regexp.js";

export default {
  methods: {isRegExp},
  props: {
    index: Number
  },
  components: { TrashIcon, ArrowPathIcon ,XMarkIcon, StopIcon, PlusIcon},
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const isRegE =ref(false)
    const isSize =ref(false)
    const types = ref([
      { value: 1, text: 'Multiple choice' },
      { value: 2, text: 'Checkboxes' },
      { value: 3, text: 'Paragraph' },
    ]);
    const createChoice = () => {
      question.choices.push({id: question.choices.length,content: ''})
    };
    const onDelete = () => {
      storeForm.form.questions.splice(props.index,1)
    };
    const onDeleteChoice = (id) => {
      question.choices.splice(id,1)
    };
    const onReset = () => {
    };
    return {storeForm, types, onDelete, onReset, question,createChoice,onDeleteChoice ,isRegE,isSize};
  },

};
</script>

