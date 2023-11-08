import { arc, easeCircleIn, pie, select } from "d3";
import { useState, useEffect } from "react";


const width = 250;
const height = 250;
const diameter = width / 2 + height / 2;
const centerX = width / 2;
const centerY = height / 2;

function App() {
  const [data, setData] = useState({ age: 19 });

  useEffect(() => {
    const svg = select("g");
    svg.selectAll("*").remove();

    const pieData = pie()([data.age, 100 - data.age]);

    svg
      .append("path")
      .attr("d", (d) => {
        return arc()
          .innerRadius(diameter / 3.2)
          .outerRadius(diameter / 2.2)
          .startAngle(-0)
          .endAngle(-100)();
      })
      .style("fill", "gray");

    svg
      .data(pieData)
      .append("path")
      .style("fill", "gray")
      .transition()
      .ease(easeCircleIn)
      .duration(2000)
      .attr("d", (d) => {
        return arc()
          .innerRadius(diameter / 3.2)
          .outerRadius(diameter / 2.2)
          .startAngle(-d.startAngle)
          .endAngle(-d.endAngle)();
      })
      .style("fill", "red");

    select("path").append("title").text(data.age);

    svg
      .append("text")
      .style("fill", "white")
      .attr("transform", `translate(${0},${-20})`)
      .style("text-anchor", "middle")
      .style("font-size", "25px")
      .text(data.age + "%")
      .transition()
      .ease(easeCircleIn)
      .duration(2000)
      .style("fill", "black");

    svg
      .append("text")
      .style("fill", "white")
      .attr("transform", `translate(${0},${+20})`)
      .text("This is below")
      .style("text-anchor", "middle")
      .style("font-size", "20px")
      .transition()
      .ease(easeCircleIn)
      .duration(2000)
      .style("fill", "black");
  }, [data]);

  return (
    <svg width={width} height={height}>
      <g transform={`translate(${centerX},${centerY})`}></g>
    </svg>
  );
}

export default App;
