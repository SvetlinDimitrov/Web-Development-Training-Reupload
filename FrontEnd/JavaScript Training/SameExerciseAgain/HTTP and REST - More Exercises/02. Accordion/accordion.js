function solution() {
    let section = document.getElementById(`main`)
    fetch(`http://localhost:3030/jsonstore/advanced/articles/details/`)
    .then(e=> e.json())
    .then(e => {
        for (const key in e) {
            let object = e[key];
            let id = object[`_id`];
            let title = object[`title`];
            let content = object[`content`]
            let div = htmlElement(`div` , null ,section , [] , {class : `accordion`});
            let div2 = htmlElement(`div` ,null,div , [] , {class : `head`});
            htmlElement(`span`, title ,div2 , [] , {});
            let button = htmlElement(`button` , "More",div2 , [] , {class : `button` , id : id});
            button.addEventListener(`click` , showMore);
            let div3 = htmlElement(`div` ,null,div , [] , {class : `extra`});
            div3.style.display = "none";
            htmlElement(`p` ,content,div3 , [] , {});
        }
    })
}
solution();
function showMore(){
    if(this.textContent === "More"){
        this.textContent = "Less";
        console.log()
        this.parentNode.parentNode.children[1].style.display = "block";
    }else{
        this.textContent = "More";
        this.parentNode.parentNode.children[1].style.display = "none";
    }
}
function htmlElement (type ,textContent, parent , classes , atributes ){
    let element = document.createElement(type);
    if(textContent && (type !== `input` && type !== `textarea`)){
        element.textContent = textContent;
    }
    if(textContent && (type === `input` && type === `textarea`)){
        element.value = textContent;
    }
    for (let index = 0; index < classes.length; index++) {
       element.classList.add(classes[index]);
    }

    for (const key in atributes) {
        element.setAttribute(key , atributes[key]);
    }

    if(parent){
        parent.appendChild(element);
    }
    return element;
}