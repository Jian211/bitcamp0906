// ECMA6 script

//기존 문자열 출력 방식
// let data = 1234;
// let desc = 'data is ';
// console.log(desc + data);

//변경
let data = 1234;
let desc = `data is ${data}, ${data * 3}`;
console.log(desc);


// 반복문 for in,  for of
let arr = ['a','b','c'];

// index 출력
for( i in arr){
    console.log(i);
}

// 값을 출력
for( i of arr){
    console.log(i);
}

// 기본매개변수 
let a = 5;
let b = 6;
let c = 7;


function fun(a = 5 ,b = 5,c = 10){
    return a + b + c;    
}


console.log(fun());

let  i = 3;
i **= 4;
console.log(i);

