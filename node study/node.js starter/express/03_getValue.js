//导入 express
const express = require('express');

//创建应用对象
const app = express();

//创建路由
app.get('/request', (req, res) => {
  //原生操作
  console.log(req.method);
  console.log(req.url);
  console.log(req.httpVersion);
  console.log(req.headers);


  //express 操作
    console.log(req.path);
    console.log(req.query);

    //创建路由
    //无论id是什么都可以成功跳转
    app.get('/:id.html', (req, res) => {
        console.log(req.params.id);//get id
        res.setHeader('content-type', 'text/html;charset=utf-8');
        res.end('商品详情');
    });

  res.end('hello express');
});

//监听端口,启动服务
app.listen(3000, () => {
  console.log('服务已经启动, 端口 3000 正在监听中....');
});