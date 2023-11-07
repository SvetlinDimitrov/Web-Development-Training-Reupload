import { useState, useEffect } from "react";
import Data from "./data.json";
import { max, min, scaleLinear } from "d3";

import { AxisBottom } from "./components/AxisBottom";
import { AxisLeft } from "./components/AxisLeft";
import { Marks } from "./components/Marks";

const width = 960;
const height = 500;
const offSetGap = 70;
const margin = { top: 10, right: 10, bottom: 10, left: 100 };
const innerHeight = height - margin.top - margin.bottom;
const innerWidth = width - margin.left - margin.right;

function App() {
  const [data, setData] = useState(null);

  useEffect(() => setData(Data), []);

  if (!data) {
    return <data>Loading ...</data>;
  }

  const yValue = (d) => d.sepal_length;
  const yTextLabel = "Sepal Length";

  const xValue = (d) => d.sepal_width;
  const xTextLabel = "Sepal Width";

  const yScale = scaleLinear()
    .domain([min(data, yValue), max(data, yValue)])
    .range([0, innerHeight])
    .nice();

  const xScale = scaleLinear()
    .domain([min(data, xValue), max(data, xValue)])
    .range([0, innerWidth])
    .nice();

  return (
    <svg width={width} height={height}>
      <g transform={`translate(${margin.left} , ${margin.top})`}>

        <AxisBottom xScale={xScale} innerHeight={innerHeight} />
        <AxisLeft yScale={yScale} innerWidth={innerWidth} />

        <text className="axis-label" x={innerWidth / 2} y={innerHeight + offSetGap}>
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
        />
      </g>
    </svg>
  );
}

export default App;
