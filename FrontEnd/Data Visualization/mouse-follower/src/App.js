import "./App.css";
import { useState, useCallback } from "react";

function App() {
  const initCoordinates = { x: 500, y: 500 };

  const [coordinates, setCoordinates] = useState(initCoordinates);

  const handleMouseMove = useCallback(
    (e) => {
      const { clientX, clientY } = e;
      setCoordinates({ x: clientX, y: clientY });
    },
    [setCoordinates]
  );

  const handleMouseClick = useCallback(
    () => {

      setCoordinates({ x: 500, y: 500 });
    },
    [setCoordinates]
  );

  return (
    <div className="App">
      <svg onMouseMove={handleMouseMove} onClick={handleMouseClick}>
        <circle
          r={20}
          cx={coordinates.x}
          cy={coordinates.y}
          fill="black"
        ></circle>
      </svg>
    </div>
  );
}

export default App;
