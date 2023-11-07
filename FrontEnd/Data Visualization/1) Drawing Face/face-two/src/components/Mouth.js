import * as d3 from "d3";

export const Mouth = ({ diameter }) => {
  const mouthArc = d3
    .arc()
    .innerRadius(diameter / 3.5)
    .outerRadius(diameter / 3)
    .startAngle(Math.PI / 2)
    .endAngle(Math.PI * 1.5);
    
  return <path d={mouthArc()} />;
};
