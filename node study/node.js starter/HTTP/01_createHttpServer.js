//1. 导入 http 模块
const http = require('http');


//2. 创建服务对象
//两个param分别是请求体和响应体的封装
const server = http.createServer((request, response) => {
  response.end('Hello HTTP Server'); //设置响应体 end：结束响应体
});

//3. 监听端口,启动服务
//端口号和回调函数。 启动成功后执行
server.listen(9000, () => {
  console.log('服务已经启动....')
});

// url: 127.0.0.1:9000
//127.0.0.1 是主机的端口号
//在terminal里按control+C可以停止服务 