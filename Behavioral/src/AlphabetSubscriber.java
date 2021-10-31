import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {

    AlphabetSubscriber(String name) {
        super.type = "alphabet";
        super.name = name;
    }

    public void onSubscribe(Flow.Subscription subscription){
        System.out.println("Alp");
        super.subscription = (StringSubscription) subscription;
        super.subscription.request(1);
    }

    public void onNext(String item){
        System.out.println("OnNext Alp");
        System.out.print(item);
    }
}
