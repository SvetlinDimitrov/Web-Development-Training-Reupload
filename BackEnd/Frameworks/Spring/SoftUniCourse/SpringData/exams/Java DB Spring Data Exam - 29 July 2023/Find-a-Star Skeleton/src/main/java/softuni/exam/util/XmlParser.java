package softuni.exam.util;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParser {
    public static <T> T fromFile(File file, Class<T> object) throws JAXBException, FileNotFoundException {
        final JAXBContext context = JAXBContext.newInstance(object);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final FileReader fileReader = new FileReader(file);

        return (T) unmarshaller.unmarshal(fileReader);
    }
}