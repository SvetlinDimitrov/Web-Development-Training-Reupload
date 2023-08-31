import ToDo from "./ToDo";
import { useEffect, useState } from "react";
import Spinner from "./Spinner";

export default function ToDoWrapper() {
  const [toDo, setToDo] = useState([]);
  useEffect(() => {
    fetch("http://localhost:3030/jsonstore/todos")
      .then((res) => res.json())
      .then((data) => {
        // Пълним с нормална дата тоДо . Сега тоДо ми е масив.
        let massive = [];

        Object.keys(data).forEach((key) => setToDo(massive.push(data[key])));

        setToDo(massive);
      });
  }, []);

  const changeButton = (_id) => {
    setToDo((oldState) =>
      oldState.map((element) => {
        if (element._id === _id) {
          element.isCompleted = !element.isCompleted;
        }
        return element;
      })
    );
  };

  return (
    <div className="table-wrapper">
      {toDo.length === 0 ? (
        <Spinner />
      ) : (
        <table className="table">
          <thead>
            <tr>
              <th className="table-header-task">Task</th>
              <th className="table-header-status">Status</th>
              <th className="table-header-action">Action</th>
            </tr>
          </thead>
          <tbody>
            {toDo.map((element) => (
              <ToDo
                key={element._id}
                {...element}
                changeButton={changeButton}
              />
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
