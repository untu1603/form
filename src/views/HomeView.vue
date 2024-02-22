<script setup>

</script>
<template>
  <div>
    <b-navbar  type="dark" variant="light" fixed="top">
        <b-navbar-brand href="#">
          <img src="https://cdn-icons-png.flaticon.com/256/5968/5968528.png" width="30">
           Form
        </b-navbar-brand>
        <b-nav-form class="w-50">
          <b-form-input size="lg"  placeholder="Search"></b-form-input>
        </b-nav-form>
      <b-navbar-nav>
          <b-nav-item-dropdown right >
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-navbar>
  </div>

</template>
