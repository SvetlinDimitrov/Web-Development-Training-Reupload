import { useContext } from 'react';
import { UserContext } from '../../context/UserContext.jsx';
import styles from './Home.module.css'; // Import the CSS Module

function Home() {
    const user = useContext(UserContext);

    return (
        <div className={styles['home-container']}>
            <h1 className={styles['home-title']}>Welcome to the Home Page</h1>
            <p className={styles['home-text']}>This is the home page of our application.</p>
            {user && <p>Logged in as: {user.email}</p>}
        </div>
    )
}

export default Home;