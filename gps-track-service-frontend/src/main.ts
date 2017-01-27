declare var require: any

var css = require('vue-material/dist/vue-material.css')

var Vue = require('vue')

import * as VueMaterial from 'vue-material'
Vue.use(VueMaterial)

import * as VueRouter from 'vue-router'
Vue.use(VueRouter)

import * as VeeValidate from 'vee-validate';
Vue.use(VeeValidate);

var App = require('./App.vue').default

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App)
})
