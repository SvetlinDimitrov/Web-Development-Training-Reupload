import {useEffect, useState} from "react";
import {auth} from "../../../firebase.js";
import {signOut} from "firebase/auth";
import {useNavigate} from "react-router-dom";

function Logout() {
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();

    useEffect(() => {
        const handleLogout = async () => {
            try {
                await signOut(auth);
            } catch (e) {
                console.error(e);
            }
            setLoading(false);
        };

        handleLogout();
        navigate('/');
    }, [navigate]);

    if (loading) {
        return <div>Loading...</div>;
    }

    return null;
}

export default Logout;