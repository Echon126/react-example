var path = require('path');
var fs = require('fs');

/**
 * 资源输出位置
 * @type {string}
 */
const bundlePath = '/static/dist/';
const sourceFolderName = './src/';

module.exports = {
    entry: (function () {
        var baseFolder = path.resolve(__dirname, sourceFolderName);
        var entryFiles = {};
        fs.readdirSync(baseFolder).map(function (fileName) {
            var filePath = path.resolve(baseFolder, fileName);
            var stat = fs.statSync(filePath);
            if (!stat.isFile())
                return;
            var tokens = /(.*?)(\.js)$/.exec(fileName);
            if (tokens.length < 1)
                return;
            var cleanName = tokens[1];
            entryFiles[cleanName] = sourceFolderName + cleanName;
        });
        console.log(entryFiles);

        return entryFiles;
    })(),
    output: {
        path: path.resolve(__dirname, '..' + bundlePath),
        filename: '[name]-bundle.js',
        publicPath: bundlePath.replace("/static", "")
    },
    module: {
        loaders: [
            {test: /\.css$/, loader: 'style-loader!css-loader'},
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                loader: "babel-loader",
                query: {
                    presets: ['react']
                }
            }
        ]
    }
};
