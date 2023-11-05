import "./App.css";
import { useState, useEffect } from "react";
import { json } from 'd3';

function App() {
  const url = 'https://gist.githubusercontent.com/SvetlinDimitrov/f0868d52afdfd42d6d3f7be525ba2c0b/raw/ca36cbf818ef40c887056b473f14839bb791371c/dogsData';
  const [data, setData] = useState(null);

  useEffect(() => {
    json(url).then(setData);
  }, [])

  console.log(data);
  return (
    <div className="App">
      <h1>{data && data.length}</h1>
    </div>
  );
}

export default App;
