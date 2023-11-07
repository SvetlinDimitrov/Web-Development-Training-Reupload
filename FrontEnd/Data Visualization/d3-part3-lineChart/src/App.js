import { useState, useEffect } from "react";
import jsonData from "./data.json";
import { extent, scaleLinear, scaleTime, timeFormat, line } from "d3";

import { AxisBottom } from "./components/AxisBottom";
import { AxisLeft } from "./components/AxisLeft";
import { Marks } from "./components/Marks";

const width = 960;
const height = 500;
const offSetGap = 60;
const margin = { top: 10, right: 10, bottom: 10, left: 100 };
const innerHeight = height - margin.top - margin.bottom;
const innerWidth = width - margin.left - margin.right;

function App() {
  const [data, setData] = useState(null);

  const convertedData = jsonData.map((d) => {
    return { time: new Date(d.time), temperature: d.temperature };
  });

  useEffect(() => setData(convertedData), []);

  if (!data) {
    return <data>Loading ...</data>;
  }

  const yValue = (d) => d.temperature;
  const yTextLabel = "Temperature";

  const xValue = (d) => d.time;
  const xTextLabel = "Time";

  const yScale = scaleLinear()
    .domain(extent(data, yValue))
    .range([innerHeight, 0])
    .nice();

  const xScale = scaleTime()
    .domain(extent(data, xValue))
    .range([0, innerWidth])
    .nice();

  return (
    <svg width={width} height={height}>
      
      <g transform={`translate(${margin.left} , ${margin.top})`}>
      <path
        fill="none"
        stroke="black"
        strokeWidth={4}
        d={line()
          .x((d) => xScale(xValue(d)))
          .y((d) => yScale(yValue(d)))(data)}
      />
        <AxisBottom
          xScale={xScale}
          innerHeight={innerHeight}
          timeFormat={timeFormat}
        />
        <AxisLeft yScale={yScale} innerWidth={innerWidth} />

        <text
          className="axis-label"
          x={innerWidth / 2}
          y={innerHeight + offSetGap}
        >
          {xTextLabel}
        </text>

        <text
          className="axis-label"
          x={0 - offSetGap}
          y={innerHeight / 2}
          transform={`rotate(-90, ${-offSetGap}, ${innerHeight / 2})`}
        >
          {yTextLabel}
        </text>

        <Marks
          yScale={yScale}
          xScale={xScale}
          data={data}
          xValue={xValue}
          yValue={yValue}
          timeFormat={timeFormat}
        />
      </g>
    </svg>
  );
}

export default App;
