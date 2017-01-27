<template>
  <md-table>
    <md-table-header>
      <md-table-row>
        <md-table-head md-sort-by="firstname">Firstname</md-table-head>
        <md-table-head md-sort-by="email">Email</md-table-head>
      </md-table-row>
    </md-table-header>
    <md-table-body>
      <md-table-row v-for="user in users">
        <md-table-cell>{{ user.firstname }}</md-table-cell>
        <md-table-cell>{{ user.email }}</md-table-cell>
        <md-table-cell>
          <md-button class="md-icon-button" @click="deleteUser(user)">
            <md-icon>delete</md-icon>
          </md-button>
        </md-table-cell>
      </md-table-row>
    </md-table-body>
  </md-table>
</template>

<script>
import { User } from 'generated'
export default {
  name: 'UserTable',
  props: {
    users: {
      type: Array,
      default () {
        return []
      }
    }
  },
  methods: {
    deleteUser (user: User) {
      this.$emit('delete', user)
    }
  }
}
</script>
