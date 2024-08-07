import {Typography} from "@mui/material";

const MuiTypography = () => {
  return (
    <div>
      <Typography variant='h1'>h1 Heading</Typography>
      <Typography variant='h2'>h2 Heading</Typography>
      <Typography variant='h3'>h3 Heading</Typography>
      <Typography variant='h4'
                  component='h1'
                  gutterBottom>h4 Heading</Typography>
      <Typography variant='h5'>h5 Heading</Typography>
      <Typography variant='h6'>h6 Heading</Typography>

      <Typography variant='subtitle1'>subtitle1 Heading</Typography>
      <Typography variant='subtitle2'>subtitle2 Heading</Typography>

      <Typography variant='body1'>loremasdddddddddddddddddddddddddddddddddddddsadadasdasdad</Typography>
      <Typography variant='body2'>loremasdddddddddddddddddddddddddddddddddddddsadadasdasdad</Typography>
    </div>
  )
}

export default MuiTypography;
