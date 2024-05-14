import styles from './ToDo.module.css';

function ToDo({ task, onEdit, onDelete }) {
    return (
        <div className={styles['todo-container']}>
            <p className={styles['todo-task']}>{task}</p>
            <button onClick={onEdit} className={styles['edit-button']}>Edit</button>
            <button onClick={onDelete} className={styles['delete-button']}>Delete</button>
        </div>
    )
}

export default ToDo;