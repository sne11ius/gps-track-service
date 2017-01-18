/// <reference path='../../typings/tsd.d.ts' />

'use strict'

import VueComponent from 'vue-class-component'

@VueComponent({
  template: require('./Hello.html')
})
export default class {
  data(): {msg: string} {
    return {
      msg: 'not loaded yet...'
    }
  }
  ready() {
    var apiEndpoint = '/api/greetings'
    var url = apiEndpoint + '/webpack';
    (this as any).$http.get(url).then(function (response) {
       this.msg = response.data.time + ' - Server said: ' + response.data.content
     })
  }
}
