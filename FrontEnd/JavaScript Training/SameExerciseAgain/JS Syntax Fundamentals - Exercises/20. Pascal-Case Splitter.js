function solve(word1){
    let arr = [];
    let index =-1;
    for(let i = 0; i<= word1.length ; i++){
        let currentChar = word1.charAt(i);
        if(index !== -1 && currentChar === currentChar.toUpperCase()){
            arr.push(word1.substring(index , i));
            index = i;
        }
        if(index === -1 && currentChar === currentChar.toUpperCase()){
            index = i;
        }
    }
    console.log(arr.join(", "));
}
solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
