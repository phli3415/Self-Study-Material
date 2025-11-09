//1. 导入 fs 模块
const fs = require('fs');

//2. stat 方法 status 缩写 状态
fs.stat('../资料/笑看风云.mp4', (err, data) => {
    //data： 返回文件相关信息
  if (err) {
    console.log('操作失败');
    return;
  }
  // console.log(data);
  // isFile 返回是否是一个文件
  console.log(data.isFile());

  // isDirectory 返回是否是一个文件夹
  console.log(data.isDirectory());
});