var packageJSON = require('./package.json');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var path = require('path');
var webpack = require('webpack');

const PATHS = {
  build: path.join(__dirname, 'target', 'classes', 'META-INF', 'resources', 'webjars', packageJSON.name, packageJSON.version)
};

module.exports = {
  entry: './app/index.js',

  output: {
    path: PATHS.build,
    publicPath: '/',
    filename: 'app-bundle.js'
  },
  
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8090',
        secure: false
      }
    }
  },

  plugins: [new HtmlWebpackPlugin()]
};
