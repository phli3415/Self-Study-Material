//导人 http 模块
const http = require('http');
//1.导入 url 模块
const url = require('url');

//创建服务对象
const server = http.createServer((request, response) => {
  //2.解析 request.url
  // console.log(request.url);
  let res = url.parse(request.url, true);
//   request.url is the URL that the client requested from the server.
//   url.parse() is a function from the url module that parses the URL string into a URL object.
  console.log(res);
  //路径
  let pathname = res.pathname;
  //查询字符串
});

server.listen(9000, () => {
    console.log('服务已经启动....')
});