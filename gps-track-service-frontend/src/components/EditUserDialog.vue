<template>
  <md-dialog ref="dialog">
    <md-dialog-title>Create User</md-dialog-title>
    <md-dialog-content>
      <md-input-container>
        <label>Firstname</label>
        <md-input data-vv-name="firstname" required v-validate="'required'" v-model="user.firstname"></md-input>
      </md-input-container>
      <span v-show="errors.has('firstname')">{{ errors.first('firstname') }}</span>
      <md-input-container>
        <label>Email</label>
        <md-input data-vv-name="email" required v-validate="'required|email'" v-model="user.email"></md-input>
      </md-input-container>
      <span v-show="errors.has('email')">{{ errors.first('email') }}</span>
    </md-dialog-content>
    <md-dialog-actions>
      <md-button class="md-primary" @click="cancelClicked">Cancel</md-button>
      <md-button class="md-primary" @click="okClicked" :disabled="errors.any()">Ok</md-button>
    </md-dialog-actions>
  </md-dialog>
</template>

<script>
export default {
  data () {
    return {
      user: {
        firstname: '',
        email: ''
      }
    }
  },
  methods: {
    open () {
      this.$refs['dialog'].open()
    },
    okClicked () {
      this.$emit('okclicked', this.user)
      this.$refs['dialog'].close()
    },
    cancelClicked () {
      this.$refs['dialog'].close()
    }
  }
}
</script>
