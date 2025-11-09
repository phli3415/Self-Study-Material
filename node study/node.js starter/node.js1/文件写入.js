// 1-1. writeFile 异步写入

// 语法: fs.writeFile(file, data[, options], callback)

// 参数说明:

// file 文件名
// data 待写入的数据
// options 选项设置 (可选)
// callback 写入回调
// 返回值: undefined

//import是同步的

/**
 * 需求:
 * 新建一个文件,座右铭.txt, 写入内容,三人行,则必有我师焉
 */

//1. 导入 fs 模块
const fs = require('fs');

//2. 写入文件
fs.writeFile('./座右铭.txt', '三人行,则必有我师焉', err => {
  // err 写入失败: 错误对象 写入成功: null
  if (err) {
    console.log('写入失败');
    return;
  }
  console.log('写入成功');
});

//异步的，会先打出二再打写入成功
console.log("2");