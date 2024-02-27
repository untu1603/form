<script setup>
import {formStore} from "@/stores/form.js";
import {EyeIcon} from "@heroicons/vue/24/solid/index.js";
</script>
<template>
    <b-navbar  type="dark" variant="light" fixed="top">
      <b-navbar-brand>
        <router-link to="/" style="text-decoration: none; color: inherit;">
          <img src="https://cdn-icons-png.flaticon.com/256/5968/5968528.png" width="30">
           Form
        </router-link>
        </b-navbar-brand>
        <b-nav-form class="w-50">
          <b-form-input size="lg"  placeholder="Search" v-model=formStore().search></b-form-input>
        </b-nav-form>
      <router-link to="/view" class="text-secondary" >
        <eye-icon class="icon "></eye-icon>
        </router-link>
      <b-navbar-nav>
          <b-nav-item-dropdown right >
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-navbar>
</template>
<style>

</style>
