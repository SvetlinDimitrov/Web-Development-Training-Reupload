// View2.jsx
import React, {useEffect, useState} from 'react';
import axiosInstance from "./axios.js";

function View2() {
    const [cars, setCars] = useState(null);

    useEffect(() => {
        const getCars = async () => {
            try {
                const csrfResponse = await axiosInstance.get(
                    '/csrf-token',
                    {withCredentials: true}
                );
                const csrfToken = csrfResponse.data;

                const demo2Response = await axiosInstance.post(
                    '/demo2',
                    {},
                    {
                        withCredentials: true,
                        headers: {
                            'X-CSRF-TOKEN': csrfToken
                        }
                    }
                );

                if (demo2Response.headers['content-type'].includes('text/html')) {
                    window.location.href = demo2Response.request.responseURL;
                } else {
                    setCars(demo2Response.data);
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

export default View2;