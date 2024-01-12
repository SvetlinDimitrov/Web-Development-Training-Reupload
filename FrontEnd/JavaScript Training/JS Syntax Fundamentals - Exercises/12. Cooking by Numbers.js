function solve(...word){
    let num = parseInt(word.shift());
    word.map(word=>{
        if(word === "chop"){
            num/=2;
        }else if(word === "dice"){
            num = Math.sqrt(num);
        }else if(word === "spice"){
            num +=1;
        }else if(word ==="bake"){
            num*=3;
        }else if(word === "fillet"){
            num -= num*0.2;
        }
        console.log(num);
    })
}
solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');