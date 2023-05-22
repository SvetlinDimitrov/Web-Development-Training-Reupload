function solve(arr){
    let obj = {};
    arr.forEach(element => {
        let arr = element.split(":");
        obj[arr[0]] = arr[1];
    });

    Object.entries(obj)
    .sort((a,b) => a[0].localeCompare(b[0]))
    .forEach((element) => console.log(element[0] + " -> "+ element[1]));
}
solve(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd'])