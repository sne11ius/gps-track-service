var express = require('express')
var proxy = require('express-http-proxy')
var webpack = require('webpack')
var config = require('./webpack.dev.conf')

var app = express()
var compiler = webpack(config)

// handle fallback for HTML5 history API
app.use(require('connect-history-api-fallback')())

// serve webpack bundle output
app.use(require('webpack-dev-middleware')(compiler, {
  publicPath: config.output.publicPath,
  stats: {
    colors: true,
    chunks: false
  }
}))

// enable hot-reload and state-preserving
// compilation error display
app.use(require('webpack-hot-middleware')(compiler))

var apiProxy = proxy('http://localhost:8090/', {
    forwardPath: function (req, res) {
        return require('url').parse(req.baseUrl).path;
    }
});
app.use("/api/*", apiProxy);

app.listen(8080, 'localhost', function (err) {
  if (err) {
    console.log(err)
    return
  }
  console.log('Listening at http://localhost:8080')
})
