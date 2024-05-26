import axios from 'axios';

const Login = () => {
    const handleGoogleLogin = async () => {
        try {
            const response = await axios.get('/auth/google');
            window.location.href = response.data.redirectUrl;
        } catch (error) {
            console.error('Error initiating Google login:', error);
        }
    };

    const handleFacebookLogin = async () => {
        try {
            const response = await axios.get('/auth/facebook');
            window.location.href = response.data.redirectUrl;
        } catch (error) {
            console.error('Error initiating Facebook login:', error);
        }
    };

    return (
        <div>
            <h1>Welcome to our Social Login App!</h1>
            <button onClick={handleGoogleLogin}>Login with Google</button>
            <button onClick={handleFacebookLogin}>Login with Facebook</button>
        </div>
    );
};

export default Login;