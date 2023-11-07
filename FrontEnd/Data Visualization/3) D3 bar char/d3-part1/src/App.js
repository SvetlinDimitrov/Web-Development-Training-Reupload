import "./App.css";
import { useState, useEffect } from "react";
import Data from "./data.json";
import { max, scaleBand, scaleLinear } from "d3";

const width = 1620;
const height = 500;
const margin = { top: 20, right: 20, bottom: 20, left: 200 };
const innerHeight = height - margin.top - margin.bottom;
const innerWidth = width - margin.left - margin.right;

function App() {
  const [data, setData] = useState(null);

  useEffect(() => {
    setData(Data.slice(0, 10));
  }, []);
  if (!data) {
    return <data>Loading ...</data>;
  }

  // This is the scale band and here how it works.
  // When we use the domain , this is the value from witch we will access the current position.
  // What is doing scaleBand it just take the min value from the range (0) , it takes all the objects,
  // and then it take the maxims value (height).From there it calculates exactly where every element should be,
  // doesn't matter if it is on the x or y, and it can tell the length of the object in order to fit all
  // elements from zero to height using (bandwidth()).
  const yScale = scaleBand()
    .domain(data.map((d) => d.Country))
    .range([0, innerHeight]);

  //The same from above but it used for values that are numbers
  const xScale = scaleLinear()
    .domain([0, max(data.map((d) => d["2020"]))])
    .range([0, innerWidth]);

  return (
    <svg width={width} height={height}>
      <g transform={`translate(${margin.left} , ${margin.top})`}>
        {/* This is responsible for the lines on the field.
      When the liner scale arrange our value on the x position its also collect a 
      marks called ticks , that can be used for showing labels on the bar char. */}
        {xScale.ticks().map((tickValue , i) => (
          <g key={i} transform={`translate(${xScale(tickValue)} , ${0})`}>
            <line x1={0} y1={0} x2={0} y2={innerHeight} stroke="black" />
            <text
              style={{ textAnchor: "middle" }}
              dy={".71em"}
              y={innerHeight + 3}
            >
              {tickValue}
            </text>
          </g>
        ))}

        {yScale.domain().map((tickValue , i) => (
            <text key={i} style={{textAnchor : 'end'}} dy={".32em"} x={-3} y={yScale(tickValue) + yScale.bandwidth() / 2}>
              {tickValue}
            </text>
        ))}

        {/* 1) in the svg we need to defined the rectangle because we want to make a bar char diagram.
      Each data will have his own rectangle .
      We define x as 0 because we want to start from the begin of the picture.
      We define y using band scale witch are used for ordinal attributes*/}
        {data.map((d, i) => (
          <rect
            key={i}
            x={0}
            y={yScale(d.Country)}
            width={xScale(d["2020"])}
            height={yScale.bandwidth()}
          />
        ))}
      </g>
    </svg>
  );
}

export default App;
