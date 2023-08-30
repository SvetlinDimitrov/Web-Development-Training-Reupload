import React, { useEffect, useState } from "react";
import Person from "./components/Person";

function App() {
  const [persons, setPersons] = useState([]);

  useEffect(() => {
    fetch("https://swapi.dev/api/people")
      .then((res) => res.json())
      .then((data) => {
        
        setPersons(data.results.map((person) => 
            <Person key={person.name} {...person} />
        ));
      });
  }, []); 

  return <div className="character-card">
    {persons}
    </div>;
}

export default App;