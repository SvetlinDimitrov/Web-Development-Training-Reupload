let matrix = (num) => new Array(num).fill(num)
.map(index => new Array(index).fill(num))
.forEach(e => console.log(e.join(" ")));
console.log(matrix(5));