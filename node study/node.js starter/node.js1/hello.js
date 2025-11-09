console.log('hello node.js');


// 1. alloc
let buf = Buffer.alloc(10);
// console.log(buf);

// 2. allocUnsafe
let buf_2 = Buffer.allocUnsafe(10000);
// console.log(buf_2);
//不清除旧数据

// 3. from
let buf_3 = Buffer.from('hello');
//ascii

let buf_4 = Buffer.from([105, 108, 111, 118, 101, 121, 111, 117]);
console.log(buf_4);


// []
// let buf = Buffer.from('hello');
// console.log(buf[0].toString(2));// 01101000
// console.log(buf);
// buf[0] = 95;
// console.log(buf.toString());

//溢出
// let buf = Buffer.from('hello');
// buf[0] = 361;//舍弃高位的数字 0001 0110 1001 => 0110 1001
// console.log(buf);