//1. 导入 fs 模块
const fs = require('fs');

//2. 创建文件夹 mk make 制作 dir directory 文件夹
fs.mkdir('./html', err => {
  if (err) {
    console.log('创建失败~');
    return;
  }
  console.log('创建成功');
});

//2-2 递归创建
//把recursive设成true
fs.mkdir('./a/b/c', { recursive: true }, err => {
    if (err) {
      console.log('创建失败~');
      return;
    }
    console.log('创建成功');
  });

//2-3 读取文件夹  read 读取  dir  directory  文件夹
fs.readdir('../资料', (err, data) => {
    if (err) {
      console.log('读取失败');
      return;
    }
    console.log(data);
  });
//把所有文件名以字符串数组的形式返回

//2-4 删除文件夹  rm  remove  移除
//只在文件夹为空时有用
fs.rmdir('./html', err => {
    if (err) {
      console.log('删除失败');
      return;
    }
    console.log('删除成功');
  });


//递归删除 把文件夹里所有的东西全删了
fs.rm('./a', { recursive: true }, err => {
    if (err) {
      console.log(err);
      return;
    }
    console.log('删除成功');
  });