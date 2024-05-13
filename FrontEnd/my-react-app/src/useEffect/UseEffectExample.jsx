import {useEffect, useState} from "react";

function UseEffectExample() {
  const [count, setCount] = useState(0);
  const [value, setValue] = useState('');

  // Run on every render
  useEffect(() => {
    console.log('This runs after every render');
  });

  // Run only once after the initial render
  useEffect(() => {
    console.log('This runs only once after the initial render');
  }, []);

  // Run only when a specific prop or state value changes
  useEffect(() => {
    console.log(`The count value has changed to ${count}`);
  }, [count]);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click me</button>
      <input type="text" value={value} onChange={(e) => setValue(e.target.value)} />
    </div>
  );
}

export default UseEffectExample;