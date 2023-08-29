import Animal from "./Animal";

export default function AnimalFarm(props) {
  return (
    <div>
    <h1>Farm feeds : {props.feed}</h1>
      <Animal
        name={props.animals[0].name}
        description={props.animals[0].description}
        age={props.animals[0].age}
        feed = {props.feed}
      />
      <Animal
        name={props.animals[1].name}
        description={props.animals[1].description}
        age={props.animals[1].age}
        feed = {props.feed}
      />
      <Animal
        name={props.animals[2].name}
        description={props.animals[2].description}
        age={props.animals[2].age}
        feed = {props.feed}
      />
    </div>
  );
}
