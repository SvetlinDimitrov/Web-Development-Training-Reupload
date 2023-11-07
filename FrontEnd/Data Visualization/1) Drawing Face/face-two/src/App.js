import { FullFace } from "./components/FullFace";
import { range } from "d3";

const array = range(8*8);

function App() {
  return (
    <div>
      {array.map((item, index) => (
        <FullFace key={index} diameter={200} />
      ))}
    </div>
  );
}

export default App;
