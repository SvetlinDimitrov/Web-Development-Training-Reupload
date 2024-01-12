// function solve(arr1 , arr2){
//     let input = [...arr1 , ...arr2];
//     let obj = {};
//     for(let i = 0 ;  i < input.length ; i++){
//         if(i % 2 == 0){
//             if(!obj.hasOwnProperty(input[i]))
//             obj[input[i]] = 0;
//         }else{
//             obj[input[i-1]] += Number(input[i]);
//         }
//     }
//     Object.entries(obj).forEach((e) => 
//         console.log(`${e[0]} -> ${e[1]}`)
//     )
// }

let obj = {};
let name = "pesho";
obj[name] = name ;
name = "gosho";
obj[name] = name;
console.log(obj);
