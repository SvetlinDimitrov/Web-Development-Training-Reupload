let loadBtn = document.getElementById(`load-product`);
let URL = "http://localhost:3030/jsonstore/grocery/";
loadBtn.addEventListener('click' , loadHandler);
let tableBody = document.getElementById(`tbody`);
let addBtn = document.getElementById(`add-product`);
addBtn.addEventListener('click' , addHandler);
let productName = document.getElementById(`product`);
let countInput = document.getElementById(`count`);
let priceInput = document.getElementById(`price`);
let updBtn = document.getElementById(`update-product`);
updBtn.addEventListener('click' , updHandler);
let editElement;


function loadHandler(event){
    if(event){
        event.preventDefault();
    }
    tableBody.innerHTML ="";
    fetch(URL)
        .then(res => res.json())
        .then(obj => {
            for (const {product ,count ,price,_id} of Object.values(obj)) {
                let tr = document.createElement('tr');
                tr.id = _id;

                let tdName = document.createElement('td');
                tdName.textContent = product;
                tdName.classList.add("name");

                let tdCount = document.createElement('td');
                tdCount.textContent = count;
                tdCount.classList.add("count-product"); 

                let tdPrice = document.createElement('td');
                tdPrice.textContent = price;
                tdPrice.classList.add("product-price");

                let tdContainer = document.createElement('td');
                tdContainer.classList.add("btn");

                let btnUpdate = document.createElement('button');
                btnUpdate.textContent = "Update";
                btnUpdate.addEventListener('click' , actionUpdHandler);
                btnUpdate.classList.add("update");

                let btnDelete = document.createElement('button');
                btnDelete.textContent = "Delete";
                btnDelete.addEventListener('click' , deleteHandler);
                btnDelete.classList.add("delete");
                
                tr.appendChild(tdName);
                tr.appendChild(tdCount);
                tr.appendChild(tdPrice);
                tr.appendChild(tdContainer);
                tdContainer.appendChild(btnUpdate);
                tdContainer.appendChild(btnDelete);
                tableBody.appendChild(tr);
            }
        })
        productName.value = "";
        countInput.value = "";
        priceInput.value ="";
}

function addHandler(event){
    if(event){
        event.preventDefault();
    }
    if(productName.value.trim().length !==0 &&
        count.value.trim().length !== 0 &&
        price.value.trim().length !== 0)
    {
        let body = {
            method: "post" ,
            body : JSON.stringify({
                product : productName.value,
                count : countInput.value,
                price : priceInput.value
            })
        }
        fetch(URL , body)
        .then(res => loadHandler());
    }
}

function deleteHandler(){
    let deleteUrl = this.parentNode.parentNode.id;
    fetch(`${URL}${deleteUrl}` , {method : 'delete'})
    .then(res => {
        addBtn.disabled = false;
        updBtn.disabled = true;
        loadHandler();
    });
}

function actionUpdHandler(){
    let Id = this.parentNode.parentNode.id;
    updBtn.disabled = false;
    addBtn.disabled = true;
    editElement = this.parentNode.parentNode;
    fetch(`${URL}${Id}`)
    .then(res => res.json())
    .then(obj => {
        let {product ,count ,price} = obj;
        countInput.value = count;
        priceInput.value = price;
        productName.value = product;
    })
}

function updHandler(event){
    if(event){
        event.preventDefault();
    }
    let Id =  document.getElementsByClassName(`list`)[0].id;
    document.getElementsByClassName(`list`)[0].id = "";
    let body = {
        method: "PATCH" ,
        body : JSON.stringify({
            product : productName.value,
            count : countInput.value,
            price : priceInput.value
        })
    }
    fetch(`${URL}${editElement.id}`,body)
    .then(res => {
        loadHandler();
        addBtn.disabled = false;
        updBtn.disabled = true;
    });
}