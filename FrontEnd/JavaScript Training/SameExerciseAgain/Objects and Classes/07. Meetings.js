function solve(arr){
    let obj = {};
    arr.forEach(element => {
        let arr = element.split(" ");
        if(obj.hasOwnProperty(arr[0])){
            console.log(`Conflict on ${arr[0]}!`)
        }else{
            obj[arr[0]] = arr[1];
            console.log(`Scheduled for ${arr[0]}`)
        }
    });
    Object.entries(obj)
    .forEach((element) => console.log(element[0] + " -> "+ element[1]));
}
solve(['Monday Peter',
'Wednesday Bill',
'Monday Tim',
'Friday Tim'])