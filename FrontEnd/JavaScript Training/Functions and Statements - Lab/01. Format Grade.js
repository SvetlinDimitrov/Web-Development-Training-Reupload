function grade(num){
    if(num < 3.00){console.log(`Fail (2)`)}
    else if(num >= 3.00 && num <3.50){console.log(`Poor (${num.toFixed(2)})`)}
    else if(num >= 3.50 && num <4.50){console.log(`Good (${num.toFixed(2)})`)}
    else if(num >= 4.50 && num <5.50){console.log(`Very good (${num.toFixed(2)})`)}
    else{console.log(`Excellent (${num.toFixed(2)})`)};
}
