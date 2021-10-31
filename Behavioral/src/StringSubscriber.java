
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public class StringSubscriber extends StringSubscription implements Flow.Subscriber{
    public StringSubscription subscription;
    public String type;
    public String name;


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = (StringSubscription) subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Got : " + item);
        try {
            FileWriter myWriter = new FileWriter(this.name + ".txt");
            myWriter.write("" + item);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public String getType() {
        return type;
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
