// webpack.config.js
// see http://webpack.github.io/docs/configuration.html
var path = require('path');

module.exports = {
    mode: 'development',
    entry: './src/main/resources/client.js',
    output: {
        path: path.resolve(__dirname, 'build/resources/main/'),
        filename: 'index.js'
    }
    // module: {
    //     rules: [
    //         {
    //             test: /\.js$/,
    //             exclude: /node_modules/,
    //             use: {
    //                 loader: 'babel-loader',
    //                 options: {
    //                     presets: ['env']
    //                 }
    //             }
    //         }
    //     ]
    // }
};