import React, { useState } from 'react';
import { useAuth0 } from '@auth0/auth0-react';

function AccessPrivateThings() {
    const { getAccessTokenSilently } = useAuth0();
    const [data, setData] = useState(null);

    const fetchData = async () => {
        try {
            const token = await getAccessTokenSilently();
            const response = await fetch('http://localhost:8080/api/private', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const responseData = await response.json();
            setData(responseData);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <>
            <button onClick={fetchData}>Fetch Private Data</button>
            {data && <div>{JSON.stringify(data)}</div>}
        </>
    );
}

export default AccessPrivateThings;