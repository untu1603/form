<script setup>
import {formStore} from "@/stores/form.js";
import {EyeIcon, LinkIcon} from "@heroicons/vue/24/solid/index.js";
import {useRoute} from 'vue-router'
import Popper from "vue3-popper";

const view = (name) => useRoute().name == name ? true : false;
const linkShare = () => {
  return window.location.hostname+":5173/answer/"+ useRoute().params.id
};
</script>
<template>
    <b-navbar  type="dark" variant="light" fixed="top">
      <b-navbar-brand>
        <router-link to="/" style="text-decoration: none; color: inherit;">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWV8pj9llpgZmU_bWXulL8vHp6Idr5voSx4dAExjDoWg&s" width="30">
           Form
        </router-link>
        </b-navbar-brand>
        <b-nav-form class="w-50">
          <b-form-input v-if="view('listForm')" size="lg"  placeholder="Search" v-model=formStore().search class="ms-5"></b-form-input>
        </b-nav-form>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav v-if="view('formEdit') || view('formEditTab')">
          <router-link :to="{name: 'formEdit'}" style="text-decoration: none; color: inherit;">
          <b-nav-item :disabled="view('formEdit')">Question</b-nav-item>
          </router-link>
          <router-link  :to="{name: 'formEditTab',params: {tab: 'statistic'}}" style="text-decoration: none; color: inherit;">
          <b-nav-item :disabled="view('formEditTab')">Answer</b-nav-item>
          </router-link>
        </b-navbar-nav>
      </b-collapse>
      <router-link v-if="view('formEdit')" :to="{name: 'formView',params: {id: formStore().form.formId}}" target="_blank" class="text-secondary" >
        <eye-icon class="icon " ></eye-icon>
        </router-link>
      <Popper v-if="view('formEdit')" :content= linkShare() >
        <link-icon class="icon mx-5" ></link-icon>
      </Popper>
      <b-navbar-nav>
          <b-nav-item-dropdown right >
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-navbar>

</template>
<style>
:root {
  --popper-theme-background-color: #333333;
  --popper-theme-background-color-hover: #333333;
  --popper-theme-text-color: #ffffff;
  --popper-theme-border-width: 0px;
  --popper-theme-border-style: solid;
  --popper-theme-border-radius: 6px;
  --popper-theme-padding: 32px;
  --popper-theme-box-shadow: 0 6px 30px -6px rgba(0, 0, 0, 0.25);
}
</style>
