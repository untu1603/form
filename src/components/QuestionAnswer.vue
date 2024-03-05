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
          <input type="radio"  v-model="content.multipleChoice" :value="choice.content"  v-if="question.type == 1">
          <input type="checkbox" v-model="content.checkBox" :value="choice.content"  v-else-if="question.type == 2">
          <label  v-if="question.type != 3" class="ms-1" >{{ choice.content }}</label>
        </div>
      <div>
            <textarea  class="form-control" v-model="text" v-if="question.type==3" @input="validateText"  />
            <p v-if="validateRegex" class="text-danger">{{errors.regex}}</p>
            <p v-if="validateSize" class="text-danger">{{ errors.size }}</p>
      </div>


    </b-form-group>

  </b-form>
</template>

<script>
import { ref,} from 'vue';
import {formStore} from "@/stores/form.js";
import {answerStore} from "@/stores/answer.js";
import {toRegExp} from "eslint-plugin-vue/lib/utils/regexp.js";
import question from "@/components/Question.vue";
export default {
  props: {
    index: Number
  },
  components: {},
  setup(props) {
    const errors=
        {
        regex: "Not in the correct format",
        size: "Reached the size limit"
        }
    const storeForm = formStore()
    const question = storeForm.form.questions[props.index]
    const content = answerStore().answer.contents[props.index]
    const answer = ref(null)
    const validateRegex = ref(false)
    const validateSize = ref(false)
    const text= ref('')
    async function validateR ()
    {
      if (question.regexExpression == null) {
         validateRegex.value= false
      } else
        validateRegex.value=!toRegExp(question.regexExpression).test(text.value)
    }
    async function validateS ()
    {
      validateR()
      if (question.size == null|| question.size == 0) {
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
      console.log(toRegExp(question.regexExpression))
      if (!validateRegex.value && !validateSize.value) content.paragraph= text.value
    }

    return {answer ,storeForm,question, content,validateSize,validateRegex,errors,text,validateText};
  },
    created() {
  }
};
</script>
<style>
.radio-align {
  display: flex;
  align-items: center;
}
</style>
