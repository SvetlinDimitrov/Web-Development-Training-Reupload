import styles from './NotFound.module.css'; // Import the CSS Module

function NotFound() {
    return (
        <div className={styles['notfound-container']}>
            <h1 className={styles['notfound-title']}>404</h1>
            <p className={styles['notfound-text']}>Page Not Found</p>
        </div>
    )
}

export default NotFound;