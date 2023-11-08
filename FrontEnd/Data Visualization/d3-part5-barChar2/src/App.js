import React, { useState, useEffect } from "react";
import { scaleLinear, easeLinear } from "d3";
import { select, selectAll } from "d3-selection";

function App() {
  const [data, setData] = useState();
  const weight = 300;
  const height = 20;

  useEffect(() => {
    setData({ name: "Gosh", age: 22 });
  }, []);

  useEffect(() => {
    if (data) {
      const xScale = scaleLinear().domain([0, 32]).range([0, weight]);

      const svg = select(".svg");

      selectAll(".svg rect").remove();

      const rect = svg
        .append("rect")
        .attr("width", 0)
        .attr("height", height)
        .attr("fill", "#67C240") // Green color
        .attr("stroke", "black");

      rect
        .transition()
        .ease(easeLinear)
        .duration(2000)
        .attr("width", xScale(data.age));
    }
  }, [data]);

  if (!data) {
    return <div>Loading ...</div>;
  }

  return (
    <div
      className="WorkHere"
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        width: weight + 80,
        height: height + 60, // Adjust height for the added text
        backgroundColor: "#EFEFEF", // Light gray background
        borderRadius: 15,
        overflow: "hidden",
      }}
    >
      <div style={{ display: "flex" }}>
        <span style={{ padding: 5, color: "white" }}>1211</span>
        <div
          className="container"
          style={{
            width: weight,
            height: height,
            backgroundColor: "#67C240", // Green color
            borderRadius: 15,
            overflow: "hidden",
          }}
        >
          <svg className="svg" style={{ width: weight, height: height }}></svg>
        </div>
        <span style={{ padding: 5, color: "white" }}>3100</span>
      </div>
      <div style={{ color: "#67C240", fontSize: 16, marginTop: 10 }}>
        Text Below the Bar
      </div>
    </div>
  );
}

export default App;
