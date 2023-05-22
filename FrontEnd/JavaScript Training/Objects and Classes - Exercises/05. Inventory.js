function solve(input){
    let obj ={};
    for (const something of input) {
        let arr = something.split(" / ");
        obj[arr[0]] = {level:Number(arr[1]) , items:arr[2]};
    }
    Object.entries(obj).sort((f,s) => f[1][`level`] - s[1][`level`])
        .forEach(e => {
            console.log(`Hero: ${e[0]}`);
            console.log(`level => ${e[1][`level`]}`);
            console.log(`items => ${e[1][`items`]}`)
        })
}
solve(
    [
        'Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'
        ]
)