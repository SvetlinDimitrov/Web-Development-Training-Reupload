function solve(arr){
    let obj = {};
    for(let i = 0 ; i < arr.length ; i++){
        let objInput = JSON.parse(arr[i]);
        let objToArr = Object.keys(objInput);
        obj[objToArr[0]] = objInput[objToArr[0]];
    }
    Object.keys(obj).sort((f,s) => f.localeCompare(s))
    .forEach(e=> console.log(`Term: ${e} => Definition: ${obj[e]}`));
}
solve([
    '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]
    )