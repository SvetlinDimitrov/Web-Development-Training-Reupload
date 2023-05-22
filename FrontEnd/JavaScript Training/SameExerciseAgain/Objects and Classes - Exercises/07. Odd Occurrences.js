function solve(input){
    let arr = input.split(" ");
    let obj = {};
    for(let i = 0 ; i < arr.length ; i++){
        let word = arr[i].toLowerCase();
        if(!obj.hasOwnProperty(word)){
            obj[word] = 1;
        }else{
            obj[word] += 1;
        }
    }
   let answer = Object.keys(obj).filter(e=> obj[e] % 2 != 0);
   console.log(answer.join(" "));
}
solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
