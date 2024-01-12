function solve(arr){
    let time = arr.shift();
    let pieces = {};
    for (let i = 0; i < time ; i++) {
        let array = arr.shift().split("|");
        pieces[array[0]] = {composer:array[1] , key : array[2]};
    }
    for (let i = 0; i < arr.length-1; i++) {
        let input = arr[i].split("|");
        if(input[0] === "Add"){
            if(pieces.hasOwnProperty(input[1])){
                console.log(`${input[1]} is already in the collection!`)
            }else{
                pieces[input[1]] = {composer:input[2] , key : input[3]};
                console.log(`${input[1]} by ${input[2]} in ${input[3]} added to the collection!`)
            } 
        }else if(input[0] === "Remove"){
            if(pieces.hasOwnProperty(input[1])){
                console.log(`Successfully removed ${input[1]}!`)
                delete pieces[input[1]];
            }else{
                console.log(`Invalid operation! ${input[1]} does not exist in the collection.`)
            } 
        }else if(input[0] === "ChangeKey"){
            if(pieces.hasOwnProperty(input[1])){
                pieces[input[1]].key = input[2];
                console.log(`Changed the key of ${input[1]} to ${input[2]}!`) 
            }else{
                console.log(`Invalid operation! ${input[1]} does not exist in the collection.`)
            } 
        }
    }
    for (const key in pieces) {
        console.log(`${key} -> Composer: ${pieces[key].composer}, Key: ${pieces[key].key}`);
    }
}

