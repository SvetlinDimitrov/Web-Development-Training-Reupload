package p06_TirePressureMonitoringSystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {

    private Alarm alarm;

    @Test
    public void testAlarm(){
        alarm = new Alarm(new Sensor());
        assertTrue(alarm.check());
    }

}