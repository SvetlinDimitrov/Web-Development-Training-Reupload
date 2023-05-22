function attachEvents() {
    let loadButton = document.getElementById(`btnLoadPosts`);
    loadButton.addEventListener(`click` , viewAll);
    var x = document.getElementById("posts");
    var viewButton = document.getElementById(`btnViewPost`);
    viewButton.addEventListener(`click` , loadAll);
    let save = {};

    async function viewAll(){
        try{
            let input = await fetch(`http://localhost:3030/jsonstore/blog/posts`)
            let jsonInput = await input.json();
            for (const key in jsonInput) {
                var option = document.createElement("option");
                option.text = jsonInput[key].title;
                save[jsonInput[key].title] = {id:jsonInput[key].id , body:jsonInput[key].body}
                x.add(option);  
            }
        }catch(err){

        }
    }

    async function loadAll(){
        try{
            document.getElementById(`post-comments`).innerHTML = ' ';
            let input = await fetch(`http://localhost:3030/jsonstore/blog/comments`)
            let jsonInput = await input.json();
            document.getElementById(`post-title`).textContent = x.value;
            document.getElementById(`post-body`).textContent = save[x.value].body;
            for (const key in jsonInput) {
                if(jsonInput[key].postId === save[x.value].id){
                    var li = document.createElement("li");
                    li.textContent = jsonInput[key].text;
                    document.getElementById(`post-comments`).appendChild(li);
            }
        }
        }catch(err){

        } 
    }
}

attachEvents();