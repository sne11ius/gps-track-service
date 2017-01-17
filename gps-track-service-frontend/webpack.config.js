/* eslint-disable no-var, strict, prefer-arrow-callback */
'use strict';

var packageJSON = require('./package.json');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var path = require('path');
var webpack = require('webpack');

const PATHS = {
  build: path.join(__dirname, 'target', 'classes', 'META-INF', 'resources', 'webjars', packageJSON.name, packageJSON.version)
};

module.exports = {
  entry: {
    main: './app/index.ts',
    vendor: [
      'babel-polyfill',
      'events'
    ]
  },
  output: {
    path: PATHS.build,
    publicPath: '/',
    filename: 'app-bundle.js'
  },
  resolve: {
    extensions: ['', '.ts', '.js']
  },
  module: {
     loaders: [{
      test: /\.ts(x?)$/,
      exclude: /node_modules/,
      loader: 'babel-loader?presets[]=es2016&presets[]=es2015!ts-loader'
    }, {
      test: /\.js$/,
      exclude: /node_modules/,
      loader: 'babel',
      query: {
        presets: ['es2016', 'es2015']
      }
    }]
  },

  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8090',
        secure: false
      }
    }
  },

  plugins: [
    new HtmlWebpackPlugin(),
    require('webpack-fail-plugin')
  ]
};
