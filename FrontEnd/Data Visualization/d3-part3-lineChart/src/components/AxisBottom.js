const offGap = 10;

export const AxisBottom = ({ xScale, innerHeight , timeFormat}) =>
  xScale.ticks().map((tickValue, i) => (
    <g
      className={"tick"}
      key={i}
      transform={`translate(${xScale(tickValue)} , ${0})`}
    >
      <line x1={0} y1={0} x2={0} y2={innerHeight} />
      <text style={{ textAnchor: "middle" }} dy={".71em"} y={innerHeight + offGap}>
        {timeFormat("%H h")(tickValue)}
      </text>
    </g>
  ));
