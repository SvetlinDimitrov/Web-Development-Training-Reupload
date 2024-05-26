import {useAuth0} from "@auth0/auth0-react";
import LogoutButton from "./LogoutButton.jsx";
import {useEffect} from "react";

const Profile = () => {
    const {user, isAuthenticated, isLoading, getAccessTokenSilently} = useAuth0();

    useEffect(() => {
        getAccessTokenSilently().then(token => console.log(token));
    }, []);

    if (isLoading) {
        return <div>Loading ...</div>;
    }

    return (
        isAuthenticated && (
            <div>
                <img src={user.picture} alt={user.name}/>
                <h2>{user.name}</h2>
                <p>{user.email}</p>
                <LogoutButton/>
            </div>
        )
    );
};

export default Profile;