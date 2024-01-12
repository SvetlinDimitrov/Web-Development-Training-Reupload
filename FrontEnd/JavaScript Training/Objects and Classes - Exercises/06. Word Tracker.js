function solve(arr){
    let obj = {};
    let array = arr[0].split(" ");
    for(let i = 0; i < array.length ; i++){
        obj[array[i]] = 0;
    }
    for(let i =1 ; i< arr.length ; i++){
        let currentWord = arr[i];
        if(obj.hasOwnProperty([currentWord])){
            obj[currentWord] +=1;
        } 
    }
    Object.entries(obj).sort((f,s) => s[1] - f[1])
    .forEach(e=> console.log(`${e[0]} - ${e[1]}`))
}
solve([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ])