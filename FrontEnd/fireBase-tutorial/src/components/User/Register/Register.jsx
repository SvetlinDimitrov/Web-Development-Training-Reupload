import {useState} from "react";
import styles from './Register.module.css';
import {auth, googleProvider} from "../../../firebase.js";
import {useNavigate} from "react-router-dom";
import {createUserWithEmailAndPassword, signInWithPopup} from "firebase/auth";

function Register() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate();

    const handleEmailChange = (e) => setEmail(e.target.value)
    const handlePasswordChange = (e) => setPassword(e.target.value)

    const handleSubmit = async (e) => {
        e.preventDefault()
        try {
            await createUserWithEmailAndPassword(auth, email, password)
            navigate('/');
        } catch (e) {
            console.error(e)
        }
    }

    const handleGoogleSignIn = async () => {
        try {
            await signInWithPopup(auth, googleProvider);
            navigate('/');
        } catch (e) {
            console.error(e)
        }
    }

    return (
        <>
            <h1>Register Page</h1>
            <form onSubmit={handleSubmit} className={styles['register-form']}>
                <input
                    type='email'
                    value={email}
                    placeholder={'Email'}
                    onChange={handleEmailChange}
                    className={styles['register-input']}
                />
                <input
                    type='password'
                    value={password}
                    placeholder={'Password'}
                    onChange={handlePasswordChange}
                    className={styles['register-input']}
                />
                <button type='submit' className={styles['register-button']}>Register</button>
            </form>
            <button onClick={handleGoogleSignIn} className={styles['google-signin-button']}>Sign in with Google</button>
        </>
    )
}

export default Register;