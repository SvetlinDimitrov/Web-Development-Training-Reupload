function solve(arr){
    let obj = {};
    for(let i = 0; i < arr.length ; i++){
        let word = arr[i].split(", ");
        if(word[0] === 'IN'){
            obj[word[1]] = word[1];
        }else{
            delete obj[word[1]];
        }
    }
    let answer = Object.keys(obj).sort((f,s) => f.localeCompare(s))
    .forEach(e=> console.log(e));
    
    
}
solve(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'IN, CA9999TT',
'IN, CA2866HI',
'OUT, CA1234TA',
'IN, CA2844AA',
'OUT, CA2866HI',
'IN, CA9876HH',
'IN, CA2822UU'])