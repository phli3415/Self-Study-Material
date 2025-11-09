//useState不能在：
// 1. 组件(app)外使用
// 2. if for 组件内部函数


import {createContext, useContext, useState, useEffect} from "react"
//兄弟之间互相传递：
//1.传到父
//2.父传子

function A({onGetAName}){
  //把name传到B
  const name ="this is A name";
  return (
    <div>
      this is A component,
      <button onClick ={()=>onGetAName(name)} >send</button>
    </div>
  )
}

function B({name}){
  return (
    <div>
      this is B component, {name}
    </div>
  )
}

//用context跨层级通信
//app->C->D
//1.createContext方法创造一个上下文对象
const MsgContext = createContext()
//2.在顶层组件通过provider组件提供数据

//3。在底层组件 通过useContext钩子使用数据
function C(){
  return (
    <div>
      this is C component
      <D></D>
    </div>
  )
}

function D(){
  const msg = useContext(MsgContext);//返回提供的value
  return (
    <div>
      this is D component, {msg}
    </div>
  )
}


//useEffect 清除副作用。
//useeffect里return的函数会在Son被清除时调用
function Son() {
  // 1. 渲染时开启一个定时器
  useEffect(() => {
    const timer = setInterval(() => {
      console.log("定时器执行中...");
    }, 1000);

    return () => {
      // 清除副作用 (组件卸载时)
      clearInterval(timer);
    };
  }, []);

  return <div>this is son</div>;
}

//封装钩子函数，实现重复利用。（就是造了一个closure）
function useToggle(initialValue = true) {
  // 可复用的逻辑代码
  const [value, setValue] = useState(initialValue);

  const toggle = () => {
    setValue(!value);
  };

  // 哪些状态和回调函数需要在其他组件中使用，return
  return {
    value,
    toggle,
  };
}

// 封装自定义hook通用思路
// 1. 声明一个以use打头的函数
// 2. 在函数体内封装可复用的逻辑 (只要是可复用的逻辑)
// 3. 将需要暴露给组件使用的状态和方法通过对象返回




//useEffect
const URL = "http://geek.itheima.net/v1_0/channels"

  function App() {
    //子传子
    const [name, setName] = useState("");
    const getAName = (name)=>{
      console.log(name);
      setName(name);//在父组件中接受name
    }
    const msg = "this is app msg";

    //useEffect
    const [list, setList] = useState([]);
    useEffect(()=>{
      //额外的操作 获取列表
      async function getList(){
        const res = await fetch(URL);
        const list = await res.json();
        console.log(list);
        setList(list.data.channels)
      }
      getList();
    }, []
    //没有依赖：组件初始渲染和组件更新时执行
    //空数组： 只在初始渲染执行一次, 因为strickMode（网上说的，我都不知道这在哪？）渲染了两次， 所以发送了两条请求
    //添加特定依赖项：组件初始渲染+特性依赖项变化时执行（[count]): count变化时触发


    // 通过条件渲染模拟组件卸载
    
  );
  const [show, setShow] = useState(true);
  return (
    <div>
      this is app
      <A onGetAName = {getAName}></A>
      <B name={name}></B>
      <br></br>


      {/* 跨级传输 */}
      {/* value里是要传递的值，把C包进去 */}
      <MsgContext.Provider value={msg}>
        <C></C>
        {/* <D></D> */}
      </MsgContext.Provider>
      <br></br>
      <br></br>

      <ul>
        {list.map(items => <li>{items.name}</li>)}
      </ul>
      <br></br>
      {show && <Son />}
      <button onClick={() => setShow(false)}>卸载Son组件</button>
    </div>
  );
}

export default App;
