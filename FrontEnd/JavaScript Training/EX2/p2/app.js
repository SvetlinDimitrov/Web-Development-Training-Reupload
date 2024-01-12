window.addEventListener('load', solve);

function solve() {
    let inputs = {};
    
    let addBtn = document.getElementById(`add-btn`);
    let likeCounts = document.getElementsByClassName(`likes`)[0];
    let collectionSongs = document.getElementsByClassName(`all-hits-container`)[0];
    let saveContainer = document.getElementsByClassName(`saved-container`)[0];
    addBtn.addEventListener('click' , addSongHandler);



    function addSongHandler(event){

        inputs = {gene : document.getElementById(`genre`) ,
            nameSong : document.getElementById(`name`),
            nameAuthor : document.getElementById(`author`),
            date : document.getElementById(`date`)
        };
        
        if(event){
            event.preventDefault();
        }
        
        let filedChecked = false;
        for (let input of Object.values(inputs)) {
            if(input.value.trim().length === 0){
                filedChecked = true;
                break;
            }
        }
        if(!filedChecked){
            
            let div = createElementByPower('div' , null , collectionSongs , ['hits-info'] , {});
            createElementByPower('img' , null , div ,[] , {src : "./static/img/img.png"});
            createElementByPower('h2' , `Genre: ${inputs.gene.value}` , div ,[] , {});
            createElementByPower('h2' , `Name: ${inputs.nameSong.value}` , div ,[] , {});
            createElementByPower('h2' , `Author: ${inputs.nameAuthor.value}` , div ,[] , {});
            createElementByPower('h3' , `Date: ${inputs.date.value}` , div ,[] , {});
            let saveBtn = createElementByPower('button' , 'Save song' , div , ["save-btn"] , {});
            saveBtn.addEventListener('click' , saveHandler);
            let likeBtn = createElementByPower('button' , 'Like song' , div , ["like-btn"] , {});
            likeBtn.addEventListener('click' , likeFunction);
            let deleteBtn = createElementByPower('button' , 'Delete' , div , ["delete-btn"] , {});
            deleteBtn.addEventListener('click', deleteFunction);
            inputs.gene.value = "";
            inputs.nameSong.value ="";
            inputs.nameAuthor.value="";
            inputs.date.value = "";
        }
    }
    function deleteFunction(){
        this.parentNode.parentNode.removeChild(this.parentNode);
    }

    function saveHandler(){
        let divToRemove = this.parentNode;
        collectionSongs.removeChild(divToRemove);
        divToRemove.removeChild(divToRemove.children[divToRemove.children.length-2]);
        divToRemove.removeChild(divToRemove.children[divToRemove.children.length-2]);
        saveContainer.appendChild(divToRemove);
    }

    function likeFunction(){
        let p = likeCounts.children[0];
        let num = Number(p.textContent.split(": ")[1])+1;
        p.textContent = `Total Likes: ${num}`;
        this.disabled = true;
    }

    function createElementByPower(type , text , parent , classes , attributes){
        let element = document.createElement(type);

        if(type === "input" || type === "textArea"){
            if(text){
                element.value = text;
            }
        }else{
            if(text){
                element.textContent = text;
            }
        }

        if(parent){
            parent.appendChild(element);
        }

        for (let i = 0; i < classes.length; i++) {
            element.classList.add(classes[i]);
        }

        for (let key of Object.keys(attributes)) {
            element[key] = attributes[key];
        }
        return element;
    }
}