package creational;

import javax.xml.parsers.ParserConfigurationException;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    private BookMetadataFormatter formatter;

    @Override
    public BookMetadataFormatter format() throws ParserConfigurationException {
        formatter = new JSONBookMetadataFormatter();
        return formatter;
    }
}
