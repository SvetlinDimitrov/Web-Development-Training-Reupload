const offGap = 10;

export const AxisLeft = ({ yScale , innerWidth}) =>
  yScale.ticks().map((tickValue, i) => (
    <g
    className={"tick"}
    key={i}
    transform={`translate(${0} , ${yScale(tickValue)})`}
  >
    <line x1={innerWidth} y1={0} x2={0} y2={0} />
    <text style={{ textAnchor: "middle" }} dy={".71em"} x={-offGap * 3}>
      {tickValue}
    </text>
  </g>
  ));
