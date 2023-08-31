export default function ToDo({_id,text,isCompleted,changeButton}){
    return (
        <tr className= {isCompleted ? 'todo is-completed' : 'todo'}>
            <td>{text}</td>
            <td> {isCompleted ? 'Complete' : 'Not Complete'}</td>
            <td className="todo-action">
              <button id = {_id} onClick={() => changeButton(_id)} className="btn todo-btn">Change status</button>
            </td>
          </tr>
    )
}