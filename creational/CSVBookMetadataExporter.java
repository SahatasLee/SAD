package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    private BookMetadataFormatter formatter;

    @Override
    public BookMetadataFormatter format() throws ParserConfigurationException, IOException {
        formatter = new CSVBookMetadataFormatter();
        return formatter;
    }
}
