function subtract() {
    let firstNum = document.getElementById('firstNumber')
    let secondNum = document.getElementById(`secondNumber`)

    document.getElementById(`result`).textContent += Number(firstNum.value)
     - Number(secondNum.value);
}