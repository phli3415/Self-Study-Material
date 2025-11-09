import {Link, useNavigate} from 'react-router-dom'

const Login = () => {
    const navigate = useNavigate();
    return (
    <div>
        我是登录页
        {/* 声明是式link跳转 */}
        {/* <Link to='/article'> 跳转 </Link>     */}

        {/* 命令式的写法 */}
        <button onClick={() => navigate('/article')}>跳转</button>
        
        {/* 传参 */}
        <button onClick={() => navigate('/article?id=1001&name=jack')}>跳转（传参）</button>
        
        {/* param传参 */}
        <button onClick={() => navigate('/article/1001')}>跳转（传参）</button>
    
    </div>)
}

export default Login