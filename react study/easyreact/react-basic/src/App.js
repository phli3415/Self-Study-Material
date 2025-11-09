import {useState} from "react"
import './index.css'


//项目的根组件
const count1 = 100;

const isLogin = true;

const articleType = 0;//可能是0, 1, 3
// 定义核心函数
function getArticleType(){
  if(articleType == 0){
    return <div>type 0</div>
  }
  else if(articleType == 1){
    return <div>type 1</div>
  }
  else{
    return <div>type 3</div>
  }
}

const lst = [
  {id:1001 , name : "VUE"},
  {id:1002 , name : "React"},
  {id:1003 , name : "Angular"}

]

// 自定义组件：写一个function，首字母大写
function Button(){
  return <button>chick newly created me</button>
}


// useState:创造一个状态变量，当状态变量变化时，视图UIUI也一起变化
// count = 0 -> 0
// count = 1 -> 1

//const[count, setCount] = useState();//count:初始值， setCount: setter




function getName(){
  return "aaa";
}

function App() {

  //用useState制作一个counter
  const[count, setCount] = useState(0);
  // 点击事件回调
  const handleClisk =() =>{
    setCount(count+1);//必须重新赋值， 
  }
  //object的useState
  const[form, setForm] = useState({
    name: "jack",
  });
  // 点击事件回调
  const handleCliskChangeObject =() =>{
    setForm({name: "bob"});//必须使用方法重新赋值， 
  }


  const handlerClisk = ()=>{
    console.log("button clicked");
  }

  //把事件参数传进来，会返回一系列当前状态的参数
  const handlerClickWithParam = (e)=>{
    console.log("button clicked", e);
  }

  const handlerClickWithBothParam = (name, e)=>{
    console.log("button clicked "+ name, e);
  }

  //自定义参数和事件参数都要
  const handlerClickWithOwnOwnParam = (e)=>{
    console.log("button clicked"+ e);
  }


  return (
    <div className="App">
      this is app
      {/* {使用引号传递字符串} */}
      {"this is message"}
      {/* {识别js变量} */}
      {count}
      {/* {"函数调用"} */}
      {getName()}
      {/* {方法调用} */}
      {new Date().getDate()}
      <br></br>

      {/* {列表} */}
      <ul>
        {/* 每一个列表项都需要绑一个unique key */}
        {/* key 是react内部的东西 */}
        {lst.map(item=> <li key={item.id}>{item.name}</li>)}
      </ul>
      <br></br>
      <br></br>

      {/* 逻辑与&& */}
      {/* 为true显示span，不然不显示 */}
      {isLogin && <span>this is span</span>}

      <br></br>
      {/* 三元运算 */}
      {/* true显示前面的，false显示后面的 */}
      {isLogin ?<span>true span</span>: <span>false span</span>}
      <br></br>

      {/*多条件:  用method吧*/}
      {getArticleType()}
      <br></br>
      <br></br>

      {/* 事件绑定 */}
      {/* 好像只能传无参函数 或传事件参数 */}
      <button onClick= {handlerClisk}>click me</button>
      <button onClick= {handlerClickWithParam}>click me</button>
      <button onClick= {()=>handlerClickWithOwnOwnParam("abc")}>click me</button>
      <button onClick= {(e)=>handlerClickWithBothParam("abc", e)}>click me</button>

      <br></br>
      {/* 自闭和，成对闭合都行 */}
      <Button/>
      <Button></Button>


      <br></br>
      <button onClick = {handleClisk}>{count}</button>
      <br></br>

      {/* 用类名设置样式 */}
      <span className = "foo"> this is a span</span>
    </div>

    
  );
}

export default App;
