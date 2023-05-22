function solve(...arr){
    let start = arr[0];
    let end = arr[1];
    let asnwer =0;
    let array =[];
    for (let index = start; index <= end ; index++) {
        asnwer+=index;
        array.push(index);
    }
    console.log(array.join(" "));
    console.log(`Sum: ${asnwer}`);
}
solve(5,10);