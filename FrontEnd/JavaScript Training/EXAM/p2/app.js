window.addEventListener('load', solve);

function solve() {
    let taskCount = 0;
    let totalPointsCount = 0;
    let toRemove = "";
 
    let totalPoints = document.getElementById(`total-sprint-points`);
    let tasksSection = document.getElementById(`tasks-section`);
    let createBtn = document.getElementById(`create-task-btn`);
    let deleteBtn = document.getElementById(`delete-task-btn`);
    deleteBtn.addEventListener(`click` , deleteButtonHandler)
    createBtn.addEventListener('click' , createHandler);

    let titleName = document.getElementById(`title`);
    let description = document.getElementById(`description`);
    let label = document.getElementById(`label`);
    let points = document.getElementById(`points`);
    let assignee = document.getElementById(`assignee`);
    




    function createHandler(){
        if(titleName.value.trim().length !== 0 && description.value.trim().length !== 0 &&
            label.value.trim().length !== 0 && points.value.trim().length !== 0 &&
            assignee.value.trim().length !==0){

            taskCount++;
            totalPointsCount +=Number(points.value);
            totalPoints.textContent = `Total Points ${totalPointsCount}pts`;
            document.getElementById(`task-id`).value = `task-${taskCount}`;
            let article = createElementByHand('article' , null , tasksSection , `task-${taskCount}` , ["task-card"] , {});
            
            let feature = createElementByHand('div' , label.value , article , null , ['task-card-label'] , {});
            
            

            if(label.value === 'Feature'){
                feature.classList.add("feature");
                feature.innerHTML = feature.textContent + ' &#8865'
            }else if (label.value === 'Low Priority Bug'){
                feature.classList.add("low-priority");
                feature.innerHTML = feature.textContent + ' &#9737'
            }else{
                feature.classList.add("high-priority");
                feature.innerHTML = feature.textContent + ' &#9888'
            }
            createElementByHand('h3' , titleName.value , article , null , ["task-card-title"] , {});
            createElementByHand('p' , description.value , article , null ,["task-card-description"] , {});
            createElementByHand('div' ,`Estimated at ${points.value} pts` , article , null , ["task-card-points"],{});
            createElementByHand('div' , `Assigned to: ${assignee.value}` , article , null , ["task-card-assignee"] , {});
            let div = createElementByHand('div' , null , article , null , ["task-card-actions"] , {});
            let deleteBtn = createElementByHand('button' , 'Delete' , div , null , [] , {});
            deleteBtn.addEventListener('click' , editDeleteHandler);

            titleName.value = "";
            description.value = "";
            points.value = "";
            assignee.value = "";
            label.value = "";
        }
    }


    function createElementByHand(type , text , parent ,id , classes , attributes){
        let element = document.createElement(type);

        if(text){
            if(type === 'input' || type === 'textArea'){
                element.value = text;
            }else{
                element.textContent = text;
            }
        }
        if(parent){
            parent.appendChild(element);
        }
        if(id){
            element.id = id;
        }

        for (let i = 0; i < classes.length; i++) {
            
            element.classList.add(classes[i]);
        }

        for (const key of Object.keys(attributes)) {
            element[key] = attributes[key];
        }

        return element;
    }

    function editDeleteHandler(){
        let article = this.parentNode.parentNode;
        toRemove = article;
        
        titleName.value = article.children[1].textContent;
        description.value = article.children[2].textContent;

        let labelValue = article.children[0].textContent.split(" ")[0];
        if(labelValue === "Feature"){
            label.value = "Feature";
        }else if (labelValue === "Low"){
            label.value = "Low Priority Bug";
        }else{
            label.value = "High Priority Bug";
        }
    
        points.value = Number(article.children[3].textContent.split(" ")[2]);
        assignee.value = article.children[4].textContent.split(": ")[1];

        deleteBtn.disabled = false;
        createBtn.disabled = true;

        titleName.disabled = true;
        description.disabled = true;
        label.disabled = true;
        points.disabled = true;
        assignee.disabled=true;

    }

    function deleteButtonHandler(){
        titleName.disabled = false;
        description.disabled = false;
        label.disabled = false;
        points.disabled = false;
        assignee.disabled= false;
        
        totalPointsCount -=Number(points.value);
        totalPoints.textContent = `Total Points ${totalPointsCount}pts`;

        titleName.value = "";
        description.value = "";
        points.value = "";
        assignee.value = "";
        label.value = "";

        deleteBtn.disabled = true;
        createBtn.disabled = false;

        tasksSection.removeChild(toRemove);

    }
}