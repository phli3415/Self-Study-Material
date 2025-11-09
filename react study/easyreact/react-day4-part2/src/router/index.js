
import Layout from '../page/Layout'
import Board from '../page/Board'
import About from '../page/About'
import NotFound from "../page/NotFound"

import { createBrowserRouter } from 'react-router-dom'


// 使用 children 属性配置路由嵌套关系
// 使用 <Outlet /> 组件配置二级路由渲染位置
// 在面板中渲染面板

const router = createBrowserRouter([
  {
    //一级路由

    
    path: '/',
    element: <Layout />,
    //二级路由
    // children: [
    //   {
    //     path: 'board',
    //     element: <Board />
    //   },
    //   {
    //     path: 'about',
    //     element: <About />
    //   }
    // ]

    //当访问的是一级路由时，默认的二级路由组件可以得到渲染，
    // 只需要在二级路由的位置去掉path，设置index属性为true
    children: [
      {
        index: true,
        element: <Board />,
      },
      {
        path: 'about',
        element: <About />,
      },
    ],
  },
  {
    path: '*',
    element: <NotFound/>
    // 为了用户体验，在目标文件找不到时跳到404
  }
  // ... rest of your routes
]);

export default router;