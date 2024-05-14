import {useContext, useState} from "react";
import styles from './Login.module.css';
import {signInWithEmailAndPassword} from "firebase/auth";
import {auth} from "../../../firebase.js";
import {useNavigate} from "react-router-dom";
import {AppContext} from "../../../context/AppContext.jsx";

function Login() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate();
    const {showToast, showLoading} = useContext(AppContext);

    const handleEmailChange = (e) => setEmail(e.target.value)
    const handlePasswordChange = (e) => setPassword(e.target.value)

    const handleSubmit = async (e) => {
        e.preventDefault();
        showLoading(true);
        try {
            await signInWithEmailAndPassword(auth, email, password);
            showToast('Login successful', {type: 'success'});
            navigate('/');
        } catch (error) {
            showToast(error.message, {type: 'error'});
            console.error(error);
        } finally {
            showLoading(false);
        }

    };

    return (
        <>
            <h1>Login Page</h1>
            <form onSubmit={handleSubmit} className={styles['login-form']}>
                <input
                    type='email'
                    value={email}
                    placeholder={'Email'}
                    onChange={handleEmailChange}
                    className={styles['login-input']}
                />
                <input
                    type='password'
                    value={password}
                    placeholder={'Password'}
                    onChange={handlePasswordChange}
                    className={styles['login-input']}
                />
                <button type='submit' className={styles['login-button']}>Login</button>
            </form>
        </>
    )
}

export default Login;