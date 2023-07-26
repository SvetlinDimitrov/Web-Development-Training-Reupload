package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public LocalTime unmarshal(String value) throws Exception {
        return LocalTime.parse(value, FORMATTER);
    }

    @Override
    public String marshal(LocalTime value) throws Exception {
        return value.format(FORMATTER);
    }
}
