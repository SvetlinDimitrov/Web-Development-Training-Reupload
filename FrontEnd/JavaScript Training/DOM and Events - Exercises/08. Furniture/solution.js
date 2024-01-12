function solve() {
  let buttons = document.getElementsByTagName(`button`);
  let textAreas = document.getElementsByTagName(`textarea`);
  buttons[0].addEventListener(`click` , handler);
  function handler(){
    let makeProducts  = JSON.parse(textAreas[0].value);
    let tbody = document.getElementsByTagName(`tbody`)[0];
    for (const object of makeProducts) {
      let {img,name,price,decFactor} = object;
      let tr = createHtmlElements('tr' , '' ,'' , tbody)
      let td1 = createHtmlElements('td' , '' , '' , tr);
      createHtmlElements('img' , '' , {src:img} , td1);
      let td2 = createHtmlElements('td' , '' , '' , tr);
      createHtmlElements('p' , name , '' , td2);
      let td3 = createHtmlElements('td' , '' , '' , tr);
      createHtmlElements('p' , price, '' , td3);
      let td4 = createHtmlElements('td' , '' , '' , tr);
      createHtmlElements('p' , decFactor, '' , td4);
      let td5 = createHtmlElements('td' , '' , '' , tr);
      createHtmlElements('input' , '', {type:'checkbox'} , td5);

    }
  }
  buttons[1].addEventListener(`click` , handle);
  function handle(){
    let products = [...document.querySelectorAll('tbody tr input:checked')];
    let names = [];
    let price = [];
    let avr = [];
    for(let i =0 ; i < products.length ; i++){
      let parent = products[i].parentNode.parentNode;
      names.push(parent.children[1].textContent);
      price.push(parent.children[2].textContent);
      avr.push(parent.children[3].textContent);
    }
   
    textAreas[1].value = `Bought furniture: ${names.join(", ")}\n`;
    let sum = price.map(e=>Number(e)).reduce((total , current)=> total+current);
    textAreas[1].value += `Total price: ${sum.toFixed(2)}\n`;
    let avrSum = avr.map(e=>Number(e)).reduce((total , current)=> total+current);
    textAreas[1].value += `Average decoration factor: ${(avrSum/avr.length)}`;

  }









function createHtmlElements(type , content , attributes , parent){
  let element = document.createElement(type);

  if(content && type != "input"){
    element.textContent = content;
  }else if (content){
    element.value = content;
  }

  if(attributes){
    for (const key in attributes) {
      element.setAttribute(key , attributes[key]);
    }
  }

  if(parent){
    parent.appendChild(element);
  }

  return element;
}
  
}