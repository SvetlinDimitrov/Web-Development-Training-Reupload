let solve = (pass) => {
    let boolean1 = pass.length >=6 && pass.length <=10;
    let lengthNum = pass.split("")
    .filter(symbol => symbol.charCodeAt(0) >= 48 && symbol.charCodeAt(0) <=57).length;
    let lengthWords = pass.split("").filter(symbol => 
        (symbol.charCodeAt(0) >= 97 && symbol.charCodeAt(0) <=122) ||
        (symbol.charCodeAt(0) >= 65 && symbol.charCodeAt(0) <=90)
    ).length;
    let boolean2 = lengthNum + lengthWords === pass.length;
    let boolean3 = lengthNum >= 2;
    if(!boolean1){console.log("Password must be between 6 and 10 characters")};
    if(!boolean2){console.log("Password must consist only of letters and digits")};
    if(!boolean3){console.log("Password must have at least 2 digits")};
    if(boolean1 && boolean2 && boolean3){console.log("Password is valid")}

}
console.log(solve('MyPass123'));