import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import router from './router'

// //路由：类似后端handler的东西
// const router = createBrowserRouter([
//   {
//     path: '/login',
//     element: <div>我是登录页</div>,
//   },
//   {
//     path: '/',
//     element: <div>Hello world!</div>,
//   },
//   {
//     path: '/article',
//     element: <div>我是文章页</div>,
//   },
// ]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
