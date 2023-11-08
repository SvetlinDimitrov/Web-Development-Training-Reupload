import { arc, easeLinear, easeCircleIn, pie, select, selectAll } from "d3";
import { useState, useEffect } from "react";

const diameter = 300;
const width = 500;
const height = 500;
const centerX = width / 2;
const centerY = height / 2;

function App() {
  const [data, setData] = useState([50, 50]);

  useEffect(() => {
    
    const colors = ["gray", "red"];
    const pieGenerator = pie()(data);

    const svg = select("g");
    svg.selectAll("*").remove();

    svg
      .selectAll("path")
      .data(pieGenerator)
      .enter()
      .append("path")
      .attr("d", (d) => {
        return arc()
          .innerRadius(diameter / 3.2)
          .outerRadius(diameter / 2.2)
          .startAngle(-d.startAngle)
          .endAngle(-d.endAngle)();
      })
      .style("fill", "gray")
      .transition()
      .ease(easeCircleIn)
      .duration(1000)
      .style("fill", (d, i) => colors[i]);

    selectAll("path")
      .append("title")
      .text((d) => d.data);

    svg
      .append("text")
      .style("fill", "white")
      .attr("transform", `translate(${0},${-20})`)
      .style("text-anchor", "middle")
      .style("font-size", "25px")
      .text(data[1] + "%")
      .transition()
      .ease(easeLinear)
      .duration(3000)
      .style("fill", "black")
      .delay();

    svg
      .append("text")
      .style("fill", "white")
      .attr("transform", `translate(${0},${+20})`)
      .text("This is below")
      .style("text-anchor", "middle")
      .style("font-size", "20px")
      .transition()
      .ease(easeLinear)
      .duration(3000)
      .style("fill", "black")
      .delay();
  }, [data]);

  return (
    <svg width={width} height={height}>
      <g transform={`translate(${centerX},${centerY})`}></g>
    </svg>
  );
}

export default App;
