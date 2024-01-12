function cityTaxes (name , population , treasury){
    population = Number(population);
    treasury = Number(treasury);
    let obj = {name, population , treasury};
    obj.taxRate = 10;
    obj.collectTaxes = () => this.treasury += this.population * this.taxRate;
    obj.applyGrowth = (percentage) => this.population += population * percentage/100;
    obj.applyRecession = (percentage) => this.treasury -= this.treasury * percentage/100;
    return obj;
} 
const city =
  cityTaxes('Tortuga',
  7000,
  15000);
city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);

//Отговора трябваше да е 8500 , 7350 
//Защо нищо не се променя , функците не се инзпълняват
//задача 3