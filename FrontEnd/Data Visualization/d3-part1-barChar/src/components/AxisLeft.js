export const AxisLeft = ({ yScale }) =>
  yScale.domain().map((tickValue, i) => (
    <g className="tick">
      <text
        key={i}
        style={{ textAnchor: "end" }}
        dy={".32em"}
        x={-3}
        y={yScale(tickValue) + yScale.bandwidth() / 2}
      >
        {tickValue}
      </text>
    </g>
  ));
