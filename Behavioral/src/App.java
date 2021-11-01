

public class App {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher("Books");
        StringSubscriber alpha = new AlphabetSubscriber("alpha");
        StringSubscriber number = new NumberSubscriber("number");
        StringSubscriber symbol = new SymbolSubscriber("symbol");
        StringSubscription subscription = new StringSubscription();
        alpha.onSubscribe(subscription);
        number.onSubscribe(subscription);
        symbol.onSubscribe(subscription);

        publisher.subscribe(alpha);
        publisher.subscribe(number);
        publisher.subscribe(symbol);

        String i = "12";
        String b = "@!@#";
        publisher.submit("AaZz12309$$#");
//        publisher.submit(i);
//        publisher.submit(b);

    }
}
