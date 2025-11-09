/**
 * 针对 /admin /setting 的请求，要求 URL 携带 code=521 参数，如未携带提示「暗号错误」
 */

//导入 express
const express = require('express');

//创建应用对象
const app = express();

//声明中间件
let checkCodeMiddleware = (req, res, next) => {
    //判断 URL 中是否 code 参数等于 521
    if (req.query.code === '521') {
      next();//放过，执行回调函数
    } else {
      res.send('暗号错误');
    }
};

//创建路由
app.get('/home',checkCodeMiddleware, (req, res) => {
  res.send('前台首页');
});

app.get('/admin', checkCodeMiddleware, (req, res) => {
  res.send('后台首页');
});

app.get('/setting', (req, res) => {
    res.send('后台设置');
});

app.all('*', (req, res) => {
  res.send('<h1>404 Not Found</h1>');
});