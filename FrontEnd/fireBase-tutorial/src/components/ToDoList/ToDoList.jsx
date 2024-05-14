import { useState } from 'react';
import ToDo from './ToDo/ToDo.jsx';
import styles from './ToDoList.module.css';

function ToDoList({tasks}) {
    const [newTask, setNewTask] = useState('');

    const handleAddTask = () => {

    };

    return (
        <div className={styles['todolist-container']}>
            {tasks?.map((task, index) => (
                <ToDo key={index} task={task}/>
            ))}
            <input
                type="text"
                value={newTask}
                onChange={(e) => setNewTask(e.target.value)}
                placeholder="New task"
            />
            <button onClick={handleAddTask}>Add Task</button>
        </div>
    )
}

export default ToDoList;