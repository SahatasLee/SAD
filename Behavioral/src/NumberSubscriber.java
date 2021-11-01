import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{

    NumberSubscriber(String name) {
        super.type = "number";
        super.name = name;
    }

    public void onSubscribe(Flow.Subscription subscription){
        System.out.println("number");
        super.subscription = (StringSubscription) subscription;
        super.subscription.request(1);
    }

    public void onNext(String item){
        System.out.println("OnNext number");
        System.out.print(item);
    }
}
