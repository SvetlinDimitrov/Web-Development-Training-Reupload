function solve(arr){
    let array = [];
    arr.forEach(element => {
        let length = element.length;
        let obj ={};
        obj.name = element;
        obj.length = length;
        array.push(obj);
    });
    array.forEach(e => {
        console.log(`Name: ${e.name} -- Personal Number: ${e.length}`)
    })
}
solve([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]);