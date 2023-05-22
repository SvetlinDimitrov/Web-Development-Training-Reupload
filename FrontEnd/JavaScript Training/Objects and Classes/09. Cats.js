function solve(arr){
    class Cat{
        constructor(name , age){
            this.name = name;
            this.age = age;
        }
        meow(){
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    }
    arr.forEach(element => {
        let helper = element.split(" ");
        let cat = new Cat(helper[0] ,helper[1]);
        cat.meow();
    });
}
solve(['Mellow 2', 'Tom 5'])