function solve(speed , environment){
    if(environment === "city"){
        if(speed <= 50){
            console.log(`Driving ${speed} km/h in a ${50} zone`);
        }else{
            console.log(`The speed is ${speed - 50} km/h faster than the allowed speed of ${50} - ${status(speed - 50)}`)
        }
    }else if(environment === "residential"){
        if(speed <= 20){
            console.log(`Driving ${speed} km/h in a ${20} zone`);
        }else{
            console.log(`The speed is ${speed - 20} km/h faster than the allowed speed of ${20} - ${status(speed - 20)}`)
        }
    }else if(environment === "interstate"){
        if(speed <= 90){
            console.log(`Driving ${speed} km/h in a ${90} zone`);
        }else{
            console.log(`The speed is ${speed - 90} km/h faster than the allowed speed of ${90} - ${status(speed - 90)}`)
        }
    }else if(environment === "motorway"){
        if(speed <= 130){
            console.log(`Driving ${speed} km/h in a ${130} zone`);
        }else{
            console.log(`The speed is ${speed - 130} km/h faster than the allowed speed of ${130} - ${status(speed - 130)}`)
        }
    }
    function status(speed){
        if(speed <=20){return "speeding"}
        if(speed <=40){return "excessive speeding"}
        return "reckless driving";
    }
}
solve(40, 'city');
solve(21, 'residential');