function attachEvents() {

    document.getElementById(`submit`).addEventListener(`click` , handle);
    let nameInput = document.getElementById(`location`);
    let forecast = document.getElementById(`forecast`);

    let URL1 = `http://localhost:3030/jsonstore/forecaster/today/`;
    let URL2 = `http://localhost:3030/jsonstore/forecaster/upcoming/`;
    let code ='';
    

    async function handle(){
        let firstFetch =  await fetch(`http://localhost:3030/jsonstore/forecaster/locations`)
        let firstJson = await firstFetch.json();
        await firstJson.forEach(object => {
            if(object.name === nameInput.value){
                code = object.code;
                forecast.style.display = `block`;
            }
        })
        let secondJson = await (await fetch(`${URL1}${code}`)).json();
        let divForecast = document.createElement(`div`);
        divForecast.className = `forecasts`;
        document.getElementById(`current`).appendChild(divForecast);
        let spanConditionSymbol = document.createElement(`span`)
        spanConditionSymbol.className = `condition symbol`;
        spanConditionSymbol.textContent = '*';
        divForecast.appendChild(spanConditionSymbol);
        let spanCondition = document.createElement(`span`)
        spanCondition.className = `condition`;
        divForecast.appendChild(spanCondition);
        let spanForecastData1 = document.createElement(`span`);
        spanForecastData1.className = `forecast-data`;
        spanForecastData1.textContent = secondJson.name;
        spanCondition.appendChild(spanForecastData1);
        let spanForecastData2 = document.createElement(`span`);
        spanForecastData2.className = `forecast-data`;
        spanForecastData2.textContent = `${secondJson.forecast.low}/${secondJson.forecast.high}`
        spanCondition.appendChild(spanForecastData2);
        let spanForecastData3 = document.createElement(`span`);
        spanForecastData3.className = `forecast-data`;
        spanForecastData3.textContent = secondJson.forecast.condition;
        spanCondition.appendChild(spanForecastData3);

        
        let thirdJson = await (await fetch(`${URL2}${code}`)).json();
        console.log(thirdJson);
    
    }
}

attachEvents();