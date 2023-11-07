export const Eye = ({ eyeRadius , eyeCxOffSet ,eyeCyOffSet }) => (
  <circle
    r={eyeRadius}
    cx={-eyeCxOffSet}
    cy={-eyeCyOffSet}
    fill="black"
  />
);
