//使用craco的话需要创建一个config文件
//然后把package.json里的scripts 的前三个改成craco
const path = require('path');

module.exports = {
    webpack: {
        alias: {
        '@': path.resolve(__dirname, 'src'),
        },
    },
};