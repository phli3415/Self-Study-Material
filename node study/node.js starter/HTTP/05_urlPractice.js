const http = require('http');

const server = http.createServer((request, response) => {
    let url = new URL(request.url, 'http://127.0.0.1');

    // 获取请求的方法
    let { method } = request;

    // 获取请求的 url 路径
    let { pathname } = new URL(request.url, 'http://127.0.0.1');

    response.setHeader('content-type', 'text/html; charset=utf-8');

    // 判断
    if (method === 'GET' && pathname === '/login') {
        // 登录的情形
        //http://127.0.0.1:9000/login
        response.end('登录页面');
    } else if (method === 'GET' && pathname === '/reg') { // register 注册
        //http://127.0.0.1:9000/reg
        response.end('注册页面');
    } else {
        response.end('404 Not Found');
    }   

    
});


server.listen(9000, () => {
    console.log('服务已经启动....')
});