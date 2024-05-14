import {createContext, useCallback, useState} from 'react';
import {Spinner, Toast} from 'react-bootstrap';
import style from './AppContext.module.css';

export const AppContext = createContext();

export const AppProvider = ({children}) => {
    const [toasts, setToasts] = useState([]);
    const [loading, setLoading] = useState(false);

    const showToast = useCallback((message, options = {}) => {
        setToasts(oldToasts => [...oldToasts, {id: Date.now(), message, ...options}]);
    }, []);

    const removeToast = useCallback((id) => {
        setToasts(oldToasts => oldToasts.filter(toast => toast.id !== id));
    }, []);

    const showLoading = useCallback((isLoading) => {
        setLoading(isLoading);
    }, []);

    return (
        <AppContext.Provider value={{showToast, showLoading}}>
            <div className={style.toastContainer}>
                {toasts.map((toast) => (
                    <Toast key={toast.id} onClose={() => removeToast(toast.id)} show={true} delay={3000} autohide>
                        <Toast.Header>
                            <strong className="mr-auto">{toast.title || 'Notification'}</strong>
                        </Toast.Header>
                        <Toast.Body>{toast.message}</Toast.Body>
                    </Toast>
                ))}
            </div>
            {loading && (
                <div className="loading-screen">
                    <Spinner animation="border" role="status">
                        <span className="sr-only">Loading...</span>
                    </Spinner>
                </div>
            )}
            {children}
        </AppContext.Provider>
    );
};

export default AppProvider;