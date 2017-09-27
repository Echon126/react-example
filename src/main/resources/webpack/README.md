## webpack 配置说明

### 1. 环境准备
+ 安装nodejs并加入环境变量，确保npm可用
+ 进入IDEA，打开Terminalcd 
+ 进入``src/main/resources/webpack``文件夹
+ 执行``npm install``，等待下载所依赖的包
+ 执行``node node_modules/webpack/bin/webpack.js --version``检查所安装的webpack版本

### 2. 启动自动打包
+ 进入IDEA，打开 Terminal
+ 进入``src/main/resources/webpack``文件夹
+ 执行``node node_modules/webpack/bin/webpack.js -w --progress``启动资源监控和自动打包程序，保持运行即可
+ 修改资源文件如js脚本，刷新页面即可载入更新后的资源

### 3. 注意
+ 仅在启动webpack时扫描 ``src/main/resources/webpack/src`` 中的顶层 js 文件作为入口文件，打包输出到 ``src/main/resources/static/dist/<entry file name>-bundle.js``
+ ``src/main/resources/webpack/src`` 里可以建立子文件夹，用于存放依赖的组件js和样式文件，但只有被入口文件``require(...)``后才生效
+ 通常一个页面对应一个入口文件，入口文件依赖的组件和样式都会被打包入``<entry file name>-bundle.js``文件
+ ``src/main/resources/webpack/webpack.config.js``中定义了webpack打包策略
+ 页面仅需引用``/static/dist/<entry file name>-bundle.js``即可
+ 当修改了入口文件或入口文件所引用的资源文件时，webpack会自动重新编译打包，此时需要刷新页面才可使修改生效


