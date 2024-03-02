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
        <div class="radio-align m-1" v-for="choice in question.choices"  :key="choice.id" >
          <input type="radio"  v-model="answer" :value="choice.content"  v-if="question.type == 1">
          <input type="checkbox" :value="choice.content"  v-else-if="question.type == 2">
          <label  v-if="question.type != 3" class="ms-1" >{{ choice.content }}</label>
        </div>
      <div>
        <textarea  class="form-control" v-model="text" v-if="question.type==3" @input="validateText"  />
        <span v-if="validateRegex" class="text-danger">{{errors.regex}}</span>
        <span v-if="validateSize" class="text-danger">{{ errors.size }}</span>
      </div>
    </b-form-group>
  </b-form>
</template>

<script>
import { ref} from 'vue';
import {formStore} from "@/stores/form.js";
import {toRegExp} from "eslint-plugin-vue/lib/utils/regexp.js";
export default {
  props: {
    index: Number
  },
  components: {},
  setup(props) {
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const content= ref('')
    const text = ref('');
    async function validateR ()
    {
      if (question.regexExpression == null) {
        validateRegex.value= true
      } else
        validateRegex.value=!toRegExp(question.regexExpression).test(text.value)
    }
    async function validateS ()
    {
      validateR()
      if (question.size == null) {
        validateSize.value = false
      }
      else {
        validateSize.value = (text.value.length > question.size)
      }
    }
    async function validateText ()
    {
      validateR()
      validateS()
    }
    const answer = ref(null)
    return {answer,content ,storeForm, question,validateText };
  },
};
</script>
<style>
.radio-align {
  display: flex;
  align-items: center;
}
</style>
