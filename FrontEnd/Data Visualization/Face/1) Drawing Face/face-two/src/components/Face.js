export const Face = ({ strokeWidth, mainRadius }) => {
  return (
    <circle
      r={mainRadius}
      fill="yellow"
      stroke="black"
      strokeWidth={strokeWidth}
    />
  );
};
