function solve(arr){
    let array = [];
    arr.forEach(element => {
        let input = element.split(" | ");
        let town = input[0];
        let latitude = Number(input[1]).toFixed(2);
        let longitude = Number(input[2]).toFixed(2);
        array.push({town , latitude , longitude});
    });
    array.forEach(e => {
        console.log(e);
    });
}
solve(['Sofia | 42.696552 | 23.32601',
'Beijing | 39.913818 | 116.363625']) ;
