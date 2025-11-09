//导入 fs
const fs = require('fs');
const path = require('path');
//写入文件
// fs.writeFileSync(__dirname + '/index.html', 'love');
// console.log(__dirname + '/index.html');

//resolve 解决
//路径拼接： 比+规范
// console.log(path.resolve(__dirname, './index.html'));
// console.log(path.resolve(__dirname, 'index.html'));
//两种写法一样，都是拼相对路径