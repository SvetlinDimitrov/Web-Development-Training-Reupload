function solve(array , num){
    let arr = [];
    for (let index = 0; index < array.length; index++) {
        if(index % num=== 0){
            arr.push(array[index]);
        }
    }
    console.log(arr.join())
}
solve(['5', 
'20', 
'31', 
'4', 
'20'], 
2);