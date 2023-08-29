import "./App.css";
import AnimalFarm from "./components/AnimalFarm";
import {useState} from 'react';

function App() {
  const[feeds , setFeed] = useState(0);

  let animals = [
    {
      name: "Pesho",
      description: "Ko staa",
      age: 5,
    },
    {
      name: "Pesho2",
      description: "sssssss",
      age: 52,
    },
    {
      name: "Pesho3",
      description: "sssssaaaaaaaaa",
      age: 223,
    },
  ];
  return (
    <div className="App">
      <button onClick={ () => setFeed(feeds +1)}>Feed all animals</button>
      <AnimalFarm animals = {animals} feed = {feeds}/>
    </div>
  );
}

export default App;
