function execute(num1 , num2 ,sign){
    switch(sign){
        case('+'):
            console.log(num1 + num2);
        break;
        case('-'):
            console.log(num1-num2);
        break;
        case('*'):
            console.log(num1*num2);
        break;
        case('/'):
            console.log(num1/num2);
        break;
        case('%'):
            console.log(num1%num2);
        break;
        case('**'):
            console.log(num1**num2);
        break;
    }
}