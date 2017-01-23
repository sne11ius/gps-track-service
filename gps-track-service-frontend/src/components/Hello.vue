<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <md-dialog md-open-from="#custom" md-close-to="#custom" ref="dialog1">
      <md-dialog-title>Some dialog title</md-dialog-title>

      <md-dialog-content>&hellip; and some dialog content</md-dialog-content>

      <md-dialog-actions>
        <md-button class="md-primary" @click="closeDialog('dialog1')">Cancel</md-button>
        <md-button class="md-primary" @click="closeDialog('dialog1')">Ok</md-button>
      </md-dialog-actions>
    </md-dialog>
    <md-button class="md-raised" @click="openDialog('dialog1')">Open Dialog</md-button>
    <md-button class="md-raised" @click="refreshMessage">Refresh Message</md-button>
  </div>
</template>

<script>
import { GreeterController } from 'generated'

export default {
  msg: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    openDialog (ref) {
      this.$refs[ref].open()
    },
    closeDialog (ref) {
      this.$refs[ref].close()
    },
    refreshMessage () {
      new GreeterController()
        .greetNameGet('my custom name')
        .then(greeting => {
          this.msg = greeting.time + ' - Server said: ' + greeting.content
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  mounted () {
    this.refreshMessage()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
