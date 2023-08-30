import ToDoWrapper from "./components/ToDoWrapper";
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">

      <main className="main">

        <section className="todo-list-container">
          <h1>Todo List</h1>
          <ToDoWrapper />
        </section>

      </main>

      <Footer />
    </div>
  );
}

export default App;
