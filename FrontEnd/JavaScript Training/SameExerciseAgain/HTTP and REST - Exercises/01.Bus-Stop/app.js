function getInfo() {
    let output = document.getElementById(`stopName`);
    let buses = document.getElementById(`buses`);
    let bussNumber = document.getElementById(`stopId`);
    let URL = 'http://localhost:3030/jsonstore/bus/businfo/';
    
    fetch(`${URL}${bussNumber.value}`)
        .then(x => x.json())
        .then(x => {
            output.textContent = x.name;
            Object.keys(x.buses).forEach(e => {
                let li = document.createElement(`li`);
                li.textContent = `Bus ${e} arrives in ${x.buses[e]} minutes`
                buses.appendChild(li);
            })
        })
        .catch(e=> {
            output.textContent = "Error";
        })
        

}