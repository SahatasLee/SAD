package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter{
    private BookMetadataFormatter formatter;

    public BookMetadataFormatter format() throws ParserConfigurationException {
        formatter = new XMLBookMetadataFormatter();
        return formatter;
    }
}
