export default function ToDo({text,isCompleted}){
    return (
        <tr className= {isCompleted ? 'todo is-completed' : 'todo'}>
            <td>{text}</td>
            <td> {isCompleted} ? Complete : Not Complete</td>
            <td className="todo-action">
              <button className="btn todo-btn">Change status</button>
            </td>
          </tr>
    )
}