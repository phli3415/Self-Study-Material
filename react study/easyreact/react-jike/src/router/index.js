//路由配置

//因为设置了craco，@在这里替代src目录
import { createBrowserRouter } from 'react-router-dom'
import Layout from '@/pages/Layout' //'src/pages/Layout'
import Login from '@/pages/Login'

//配置路由设置

const router = createBrowserRouter([
    {
        path: "/",
        element:<Layout/>
    },
    {
        path: "/Login",
        element:<Login/>
    },
])

export default router