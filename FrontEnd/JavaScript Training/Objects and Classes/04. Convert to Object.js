function solve(json){
    let obj = JSON.parse(json);
    Object.entries(obj).forEach(element => {
        console.log(element[0] + ": " + element[1])
    });
}
solve('{"name": "George", "age": 40, "town": "Sofia"}')