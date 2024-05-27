import axios from 'axios';

// Create a default instance
const instance = axios.create({
    baseURL: 'http://localhost:8080/api', // Replace with your server URL
});


export default instance;