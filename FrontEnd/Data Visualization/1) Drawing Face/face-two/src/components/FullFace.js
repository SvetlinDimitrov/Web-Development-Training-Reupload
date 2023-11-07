import { Face } from "./Face";
import { Eye } from "./Eye";
import { Mouth } from "./Mouth";

export const FullFace = ({ diameter }) => {
  const mainCx = diameter / 2;
  const mainCy = diameter / 2;
  const strokeWidth = diameter / 40;
  const mainRadius = diameter / 2 - strokeWidth / 2;
  const eyeRadius = mainRadius / 6;
  const eyeCxOffSet = mainCx / 2;
  const eyeCyOffSet = mainCy / 3;

  return (
    <svg width={diameter} height={diameter}>
      <g transform={`translate(${mainCx} , ${mainCy})`}>
        <Face mainRadius={mainRadius} strokeWidth={strokeWidth} />
        <Eye
          eyeRadius={eyeRadius}
          eyeCxOffSet={eyeCxOffSet}
          eyeCyOffSet={eyeCyOffSet}
        />
        <Eye
          eyeRadius={eyeRadius}
          eyeCxOffSet={-eyeCxOffSet}
          eyeCyOffSet={eyeCyOffSet}
        />
        <Mouth diameter={diameter} />
      </g>
    </svg>
  );
};
