function solve(arr){
    let obj = {} ;
    arr.forEach(element => {
       let helper = element.split(" ");
       let [name , phone] = helper;
       obj[name] = phone;
    });
    Object.entries(obj)
    .forEach((element) =>console.log(element[0] +" -> " + element[1]));
}
solve(['Tim 0834212554',
'Peter 0877547887',
'Bill 0896543112',
'Tim 0876566344'])