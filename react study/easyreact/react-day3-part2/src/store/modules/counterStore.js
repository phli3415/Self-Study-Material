import { createSlice } from "@reduxjs/toolkit";

const counterStore = createSlice({
    name: 'counter',
    //初始项目数据
    initialState: {
        count: 0
    },
    //修改数据的方法
    reducers: {
        increment(state) {
            state.count++;
        },
        decrement(state) {
            state.count--;
        }
    }
});
//调用createSlice后会直接在object里创建一个actions，对应reducers里的两个method
//解构出action对象的函数
//state记录了当前事件的相关信息，类似事件函数

const { increment, decrement } = counterStore.actions;
const counterReducer = counterStore.reducer;

export { increment, decrement };
export default counterReducer;