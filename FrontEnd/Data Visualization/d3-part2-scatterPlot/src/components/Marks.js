export const Marks = ({ yScale, xScale, data, xValue, yValue}) =>
  data.map((d, i) => (
    <circle
      className="mark"
      key={i}
      cx={xScale(xValue(d))}
      cy={yScale(yValue(d))}
      r={5}
    >
      <title>{xValue(d)}</title>
    </circle>
  ));
