//导入 http 模块
const http = require('http');

//创建服务对象
const server = http.createServer((request, response) => {
  //实例化 URL 的对象
  // let url = new URL('/search?a=100&b=200', 'http://127.0.0.1:9000');
  let url = new URL(request.url, 'http://127.0.0.1');

  //http://127.0.0.1:9000/search?keyword=56
  //输出路径
  console.log(url.pathname);
  //输出 keyword 查询字符串
  console.log(url.searchParams.get('keyword'));
  
  response.end('url new');
});

server.listen(9000, () => {
    console.log('服务已经启动....')
});



// let url = new URL(request.url, 'http://127.0.0.1');

// 这行代码创建了一个 URL 对象，它用于解析和操作 URL。
// request.url 是从客户端接收到的请求 URL，例如 /search?keyword=56。
// 'http://127.0.0.1' 是基础 URL，用于解析相对 URL。在这里，它指定了服务器的地址和协议。
// 这行代码的作用是将客户端请求的 URL（例如 /search?keyword=56）与基础 URL（http://127.0.0.1）组合起来，创建一个完整的 URL 对象。
// 2. console.log(url.pathname);

// 这行代码使用 console.log() 将 url.pathname 的值输出到控制台。
// url.pathname 属性包含 URL 的路径部分。
// 在这个例子中，如果客户端请求的 URL 是 http://127.0.0.1:9000/search?keyword=56，那么 url.pathname 的值将是 /search。
// 因此，这行代码的作用是将请求 URL 的路径部分输出到控制台。
// 3. console.log(url.searchParams.get('keyword'));

// 这行代码使用 console.log() 将 url.searchParams.get('keyword') 的值输出到控制台。
// url.searchParams 属性是一个 URLSearchParams 对象，它包含 URL 的查询字符串参数。
// url.searchParams.get('keyword') 方法用于获取名为 keyword 的查询字符串参数的值。
// 在这个例子中，如果客户端请求的 URL 是 http://127.0.0.1:9000/search?keyword=56，那么 url.searchParams.get('keyword') 的值将是 56。
// 因此，这行代码的作用是将请求 URL 中 keyword 查询字符串参数的值输出到控制台。