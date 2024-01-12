function solve(count , type ,day){
    let price;
    if(type === "Students"){
        if(day === "Friday"){
            price = 8.45;
        }else if(day === "Saturday"){
            price = 9.80;
        }else if(day === "Sunday"){
            price = 10.46;
        }
        console.log(`Total price: ${(count >= 30 ? price*count - price*count * 0.15 : price*count).toFixed(2)}`);
    }else if(type === "Business"){
        if(day === "Friday"){
            price = 10.90;
        }else if(day === "Saturday"){
            price = 15.60;
        }else if(day === "Sunday"){
            price = 16;
        }
        console.log(`Total price: ${(count >= 100 ? price*(count-10) : price*count).toFixed(2)}`);
    }else if(type === "Regular"){
        if(day === "Friday"){
            price = 15;
        }else if(day === "Saturday"){
            price = 20;
        }else if(day === "Sunday"){
            price = 22.50;
        }
        console.log(`Total price: ${(count >= 10 && count <=20 ? price*count - price*count * 0.05 : price*count).toFixed(2)}`);
    }
}
solve(30,
    "Students",
    "Sunday")