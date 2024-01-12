function solve(arr){
    let items = arr[0].split("!");
    
    for (let i = 1; i < arr.length; i++) {
        let element = arr[i];
        let command = element.split(" ")[0];
        let item = element.split(" ")[1];
        if(command === "Urgent"){
            if(!items.includes(item)){
                items.unshift(item)
            }
        }else if (command === "Unnecessary"){
            let index = items.indexOf(item);
            if(index !== -1){
                items.splice(index , 1);
            }
        }else if (command === "Correct"){
            let index = items.indexOf(item);
            let newItem = element.split(" ")[2];
            if(index !== -1){
                items.splice(index , 1);
                items.splice(index , 0, newItem);
            }
        }else if (command === "Rearrange"){
            let index = items.indexOf(item);
            if(index !== -1){
                items.splice(index , 1);
                items.push(item);
            }
        }else if (command === "Go"){
            console.log(items.join(", "));
        }
    }
}
solve((["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"]))