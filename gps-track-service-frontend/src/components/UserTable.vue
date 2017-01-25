<template>
  <md-table>
    <md-table-header>
      <md-table-row>
        <md-table-head md-sort-by="firstname">Firstname</md-table-head>
        <md-table-head md-sort-by="email">Email</md-table-head>
      </md-table-row>
    </md-table-header>
    <md-table-body>
      <md-table-row v-for="(user, index) in data">
        <md-table-cell>{{user.firstname}}</md-table-cell>
        <md-table-cell>{{user.email}}</md-table-cell>
      </md-table-row>
    </md-table-body>
  </md-table>
</template>

<script>
</script>
