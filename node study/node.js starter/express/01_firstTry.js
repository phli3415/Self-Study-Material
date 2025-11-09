//1. 导入 express
const express = require('express');

//2. 创建应用对象
const app = express();

//3. 创建路由
// When a client makes a GET request to /home, this route will be triggered.
//必须以get方式请求 /home才触发回调函数
app.get('/home', (req, res) => {
    
  res.end('hello express');
});

app.get('/', (req, res) => {
    res.end('home');
  });
  
  app.post('/login', (req, res) => {
    res.end('login login');
  });

//4. 监听端口,启动服务
app.listen(3000, () => {
  console.log('服务已经启动, 端口 3000 正在监听中....');
});