import ToDo from './ToDo';
import {useEffect , useState} from 'react';

export default function ToDoWrapper() {

    const [toDo , setToDo] = useState([]);
    useEffect(() => {
        fetch("http://localhost:3030/jsonstore/todos")
        .then((res) => res.json())
        .then((data) => {

            Object.keys(data).forEach((key) => {
                setToDo(<ToDo key={data[key].id} {...data[key]}/>)
              });
        })
    },[]);

  return (
    <div className="table-wrapper">
      <table className="table">
        <thead>
          <tr>
            <th className="table-header-task">Task</th>
            <th className="table-header-status">Status</th>
            <th className="table-header-action">Action</th>
          </tr>
        </thead>
        <tbody>
            {
                {ToDo}
            }
        </tbody>
      </table>
    </div>
  );
}
