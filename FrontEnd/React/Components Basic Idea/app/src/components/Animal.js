import { useState } from 'react';

export default function Animal(props) {
  const [eatTimes, setEatTimes] = useState(props.feed);
  return (
    <div>
      <h4>Nmae :{props.name}</h4>
      <p>Description :{props.description}</p>
      <p>Age : {props.age}</p>
      <p>Time feeded : {eatTimes + props.feed}</p>
      <button onClick={() => setEatTimes(eatTimes + 1)}>
        Feed {props.name}
      </button>
    </div>
  );
}
