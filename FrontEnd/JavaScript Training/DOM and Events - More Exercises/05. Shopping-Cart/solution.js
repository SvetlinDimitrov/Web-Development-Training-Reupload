function solve() {
   let buttons = [...document.getElementsByTagName(`button`)];
   buttons[0].addEventListener(`click` , add);
   buttons[1].addEventListener(`click` , add);
   buttons[2].addEventListener(`click` , add);
   buttons[3].addEventListener(`click` , sum);
   let answer = document.getElementsByTagName(`textarea`)[0];
   let obj = {};

   function add(){
      let nameItem = this.parentNode.parentNode.children[1].children[0].textContent;
      let money = this.parentNode.parentNode.children[3].textContent;
      if(obj.hasOwnProperty(nameItem)){
         obj[nameItem] = obj[nameItem] + Number(money);
      }else{
         obj[nameItem] = Number(money);
      }
      answer.value += `Added ${nameItem} for ${money} to the cart.\n`
   }
   function sum(){
      let arrNames =[];
      let arrPrices =[];
      buttons[0].disabled = true;
      buttons[1].disabled = true;
      buttons[2].disabled = true;
      buttons[3].disabled = true;
      Object.entries(obj).forEach(e => {
         arrNames.push(e[0]);
         arrPrices.push(e[1]);
      })
      answer.value += `You bought ${arrNames.join(", ")} for ${arrPrices.reduce((f,s) => f+s,0).toFixed(2)}.`
   }
}