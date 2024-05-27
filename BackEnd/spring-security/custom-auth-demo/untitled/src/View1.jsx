// View1.jsx
import {useEffect, useState} from 'react';
import axiosInstance from './axios.js';

function View1() {
    const [cars, setCars] = useState(null);

    useEffect(() => {
        const getCars = async () => {
            try {
                const response = await axiosInstance.get(
                    '/demo',
                    {withCredentials: true}
                );

                if (response.headers['content-type'].includes('text/html')) {
                    window.location.href = response.request.responseURL;
                } else {
                    setCars(response.data);
                }
            } catch (error) {
                console.error('Error fetching data: ', error);
            }
        };

        getCars();
    }, []);

    return (
        cars ? (
            <div>
                <h1>{cars}</h1>
            </div>
        ) : (
            <div>Loading...</div>
        )
    );
}

export default View1;