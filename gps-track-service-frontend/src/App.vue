<template>
  <div id="app">
    <img src="./assets/logo.png">
    <hello></hello>
    <md-button class="md-raised" @click="openDialog('userDialog')">Create User</md-button>
    <EditUserDialog ref="userDialog" v-on:okclicked="createUser"></EditUserDialog>
    <UserTable ref="userTable" :users="users" v-on:delete="deleteUser"></UserTable>
  </div>
</template>

<script>
import Hello from './components/Hello'
import UserTable from './components/UserTable'
import EditUserDialog from './components/EditUserDialog'

import { User, UserRestService } from 'generated'

var userService = new UserRestService()

export default {
  name: 'app',
  components: {
    Hello,
    UserTable,
    EditUserDialog
  },
  data () {
    return {
      type: Array,
      users: []
    }
  },
  methods: {
    openDialog (ref) {
      this.$refs[ref].open()
    },
    closeDialog (ref) {
      this.$refs[ref].close()
    },
    refreshUsers () {
      console.log('refreshing')
      userService
        .loadUsers()
        .then(users => {
          console.log(JSON.stringify(users))
          this.users = users
        })
        .catch(error => {
          console.log(error)
        })
    },
    createUser (user: User) {
      userService
        .createOrUpdateUser(user)
        .then(user => {
          this.refreshUsers()
        })
        .catch(error => {
          console.log(error)
        })
    },
    deleteUser (user: User) {
      userService.deleteUser(user.id)
      this.refreshUsers()
    }
  },
  mounted () {
    this.refreshUsers()
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
