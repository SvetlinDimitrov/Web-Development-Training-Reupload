export const Marks = ({ yScale, xScale, data, xValue, yValue , valueFormat }) =>
  data.map((d, i) => (
    <rect
      className="mark"
      key={i}
      x={0}
      y={yScale(yValue(d))}
      width={xScale(xValue(d))}
      height={yScale.bandwidth()}
    >
      <title>{valueFormat(xValue(d))}</title>
    </rect>
  ));
