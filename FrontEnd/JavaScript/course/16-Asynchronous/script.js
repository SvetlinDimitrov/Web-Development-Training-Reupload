'use strict';

const BASE_URL = 'https://restcountries.com/v2';
const BASE_URL_PORTUGAL = `${BASE_URL}/name/portugal`;
/*
AJAX: Asynchronous JavaScript And XML


const fetchCountry = (country) => {
  const request = new XMLHttpRequest();
  request.open('GET', `${BASE_URL}/name/${country}`, true);
  request.send();
  request.addEventListener('load', function () {
    const [data] = JSON.parse(this.responseText);

    console.log(data);
  });
}
// this are all async functions
// witch means that they will run in parallel
// and the order of the console.log will be different
// fetchCountry('portugal');
// fetchCountry('spain');
// fetchCountry('canada');
// fetchCountry('france');
// fetchCountry('germany');

//in order to execute the functions in sequence we can do this
const fetchCountry2 = () => {
  const request = new XMLHttpRequest();
  request.open('GET', `${BASE_URL}/name/portugal`, true);
  request.send();
  request.addEventListener('load', function () {
    const [data] = JSON.parse(this.responseText);
    console.log(data);

    const request = new XMLHttpRequest();
    request.open('GET', `${BASE_URL}/name/spain`, true);
    request.send();
    request.addEventListener('load', function () {
      const [data] = JSON.parse(this.responseText);
      console.log(data);

      const request = new XMLHttpRequest();
      request.open('GET', `${BASE_URL}/name/canada`, true);
      request.send();
      request.addEventListener('load', function () {
        const [data] = JSON.parse(this.responseText);
        console.log(data);

        const request = new XMLHttpRequest();
        request.open('GET', `${BASE_URL}/name/france`, true);
        request.send();
        request.addEventListener('load', function () {
          const [data] = JSON.parse(this.responseText);
          console.log(data);

          const request = new XMLHttpRequest();
          request.open('GET', `${BASE_URL}/name/germany`, true);
          request.send();
          request.addEventListener('load', function () {
            const [data] = JSON.parse(this.responseText);
            console.log(data);

          });
        });
      });
    });
  });
}
// this is what we call callback hell or pyramid of doom
// this is not a good way to do it
fetchCountry2();
 */
/*
Promises and the Fetch API
 */

// const result = fetch(`${BASE_URL}/name/portugal`)
// console.log(result);
// A promise is a container for a value that is not yet known when the promise is created
// A promise can be in one of three states:
// - pending: initial state, neither fulfilled nor rejected.
// - fulfilled: meaning that the operation completed successfully.
// - rejected: meaning that the operation failed.

// Instead of nesting callbacks , we can chain promises for a sequence of asynchronous operations
// escaping the callback hell
const getCountryData = (country) => {
  return fetch(`${BASE_URL}/name/${country}`)
    .then(response => {
      // The response contains a body property that is a readable stream
      // In order to access the body we need to call the json method
      // this method returns a promise that resolves with the result of parsing the body text as JSON
      return response.json();
    })
    .then(data => {
      console.log(data[0]);
    });
}

getCountryData('portugal');