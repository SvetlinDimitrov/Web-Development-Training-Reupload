let solve = (arr) => arr.forEach(element => {
    console.log(element === Number(element.toString().split("").reverse().join("")));
});
solve([123,323,421,121]);