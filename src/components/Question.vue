<template>
  <b-form @submit="onSubmit" @reset="onReset" v-if="show">
    <div class="row">
      <div class="col">
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
      </div>
      <div class="col-3">
        <b-form-select
            v-model="form.food"
            :options="foods"
            required
        ></b-form-select>
      </div>
    </div>
    <b-form-group id="input-group-2" label="Your Name:" label-for="input-2">
      <b-form-input
          class="form-control form-control-sm"
          id="input-2"
          v-model="form.name"
          placeholder="Enter name"
          required
      ></b-form-input>
      <b-button type="create" variant="primary">+</b-button>
    </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
    <b-button  type="reset" variant="danger">Reset</b-button>
  </b-form>

</template>

<script>
import { ref } from 'vue';
export default {
  setup() {
    const form = ref({
      email: '',
      name: '',
      food: null,
    });

    const foods = ref([
      { text: 'Select One', value: null },
      'Carrots',
      'Beans',
      'Tomatoes',
      'Corn',
    ]);

    const show = ref(true);

    const onSubmit = () => {
      alert(JSON.stringify(form.value));
    };

    const onReset = () => {
      form.value.email = '';
      form.value.name = '';
      form.value.food = null;

      // Reset browser validation state
      show.value = false;
      setTimeout(() => {
        show.value = true;
      }, 0); // Use 0 for immediate update
    };

    return { form, foods, show, onSubmit, onReset };
  },
};
</script>

<style>
html, body {
  margin: 2% 2% 2% 2%;
}
</style>
