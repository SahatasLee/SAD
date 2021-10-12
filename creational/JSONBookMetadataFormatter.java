package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject obj;
    private JSONArray bookList;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        obj = new JSONObject();
        bookList = new JSONArray();
        obj.put("Books", bookList);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONArray authors = new JSONArray();
        for (String author: b.getAuthors()) {
            authors.add(author);
        }
        JSONObject J_Book = new JSONObject();
        J_Book.put("ISBN", b.getISBN());
        J_Book.put("Authors", authors);
        J_Book.put("Title", b.getTitle());
        J_Book.put("Publisher", b.getPublisher());
        bookList.add(J_Book);
        obj.put("Books", bookList);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return obj.toJSONString();
    }
}
