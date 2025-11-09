
//1.声明一个useState

import{useState, useRef} from "react"
//2.核心绑定流程
//1.通过一个value绑定react状态
//2.绑定onchange事件通过事件参数框e拿到值，反向修改useState



//react中获取dom：
//useRef生产ref对象, 绑定到dom标签上
//2.dom可用时通过 ref.current获取


//父传子
//1.父组件传递数据 子组件标签上绑定属性
//2.子组件接受数据 props的函数
function Son(props) {
  //叫啥都行，一般就叫props
  //props是一个object， 里边有父组件传来的所有参数, 什么都可以传哦
  //props是个const。 不可修改
  console.log(props);
  return <div> this is son {props.name}; jsx: {props.child} children: {props.children}</div>
}

//子传父
//在子组件中调用父组件的函数，并传递param
function Son2({onGetSonMsg}) {
  //从props里提取onGetSonMsg
  const sonMSG = "son to father";

  return (
  <div> 
    this is son 2
    <button onClick={()=>onGetSonMsg(sonMSG)}>click me!</button>
  </div>
  )
}

function App() {
  const[value, setValue] =useState('');

  //dom
  const inputRef = useRef(null);
  const showDom = ()=>{
    console.log(inputRef.current);
  }
  //子传父
  const[msg,setMsg] = useState('');
  const getMessage = (a)=>{

    console.log(a);
    setMsg(a);
  }


  const name="123";
  return (
    <div>
      <input
        value = {value}
        onChange={(e)=>setValue(e.target.value)}
        type = "text" 
        ref = {inputRef}
      ></input>
      <button onClick = {showDom}>get dom</button>
      <br></br>
      <Son 
        name = {name}
        age = {18}
        isTrue = {false}
        list = {[1,2,3]}
        obj = {{name:"Malice"}}
        cb = {() => console.log(123)}
        child = {<span>this is grandson</span>}
      >
        <span>
          this is grandson 2
          {/* 在son里吗再写一个span，算son的子组件，可以用children取得 */}
        </span>
      </Son>
      {/* 随便加个属性 */}

      <br></br>
      <span>{msg}</span>
      <Son2 onGetSonMsg = {getMessage}></Son2>
      {/* 把函数传进props */}
    </div>
  );
}

export default App;
