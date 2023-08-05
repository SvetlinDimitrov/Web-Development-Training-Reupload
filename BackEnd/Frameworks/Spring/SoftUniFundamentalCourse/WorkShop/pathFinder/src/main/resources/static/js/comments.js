let commentForm = document.getElementById("commentForm");
let userId = document.getElementById("userId");
let routeId = document.getElementById("routeId");
let textArea = document.getElementById("message");
let commentFillSection = document.getElementById("commentCtnr");

fillCommends();

commentForm.addEventListener('submit', (event) => {

    let csrfToken = document.getElementById("csrf");

    event.preventDefault();

    if(textArea.value.length !== 0){

        fetch(`http://localhost:8080/comment/create/${routeId.value}/${userId.value}`,{
            method : 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken.value
            },
            body : JSON.stringify({
                "commentText":textArea.value
            })
        }).then(() => {
            textArea.value = "";
            fillCommends();
        })

    }

})

function fillCommends() {
    commentFillSection.innerHTML = "";
    fetch(`http://localhost:8080/comment/${routeId.value}`)
        .then((res) => res.json())
        .then((res) => {
            for (let comment of res) {

                let container = document.createElement('div');
                container.id = comment.id;
                let authorName = document.createElement('h4');
                authorName.textContent = comment.author;
                let commentText = document.createElement('p');
                commentText.textContent = comment.textContent;
                let date = document.createElement('span');
                date.textContent = comment.created;

                container.appendChild(authorName);
                container.appendChild(commentText);
                container.appendChild(date);

                commentFillSection.innerHTML+=container.innerHTML;

            }
        })
}

