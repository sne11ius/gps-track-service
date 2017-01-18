/// <reference path='../typings/tsd.d.ts' />

import Vue = require('vue')
var VueResource = require('vue-resource');
Vue.use(VueResource);
import App from './App'

new Vue({
  el: 'body',
  components: { App }
})
