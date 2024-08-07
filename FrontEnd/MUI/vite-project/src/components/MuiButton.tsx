import {Button, ButtonGroup, IconButton, Stack} from "@mui/material";
import AccessTimeFilledIcon from '@mui/icons-material/AccessTimeFilled';

const MuiButton = () => {
  return (
    <div>
      <Stack spacing={2} direction="column">
        <Stack spacing={2} direction="row">
          <Button variant="contained">Contained</Button>
          <Button variant="text">Text</Button>
          <Button variant="outlined">Outlined</Button>
        </Stack>

        <Stack spacing={2} direction="row">
          <Button variant="contained" color="primary">Primary</Button>
          <Button variant="contained" color="secondary">Secondary</Button>
          <Button variant="contained" color="error">Error</Button>
          <Button variant="contained" color="warning">Warning</Button>
          <Button variant="contained" color="info">Info</Button>
          <Button variant="contained" color="success">Success</Button>
        </Stack>

        <Stack spacing={2} direction="row">
          <Button variant="contained" size="medium">Medium</Button>
          <Button variant="contained" size="small">Small</Button>
          <Button variant="contained" size="large">Large</Button>
        </Stack>

        <Stack spacing={2} direction="row">
          <Button variant="contained" startIcon={<AccessTimeFilledIcon/>}>Start Icon</Button>
          <IconButton color={"success"} size={"large"}>
            <AccessTimeFilledIcon/>
          </IconButton>
        </Stack>

        <Stack spacing={2} direction="row">
          <ButtonGroup variant={"contained"}
                       orientation={"vertical"}
                       size={"small"}
                       color={"success"}>
            <Button>Left</Button>
            <Button>Center</Button>
            <Button>Right</Button>
          </ButtonGroup>
        </Stack>
      </Stack>
    </div>
  );
}

export default MuiButton;