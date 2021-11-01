import java.sql.SQLOutput;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {

    SymbolSubscriber(String name) {
        super.type = "symbol";
        super.name = name;
    }

    public void onSubscribe(Flow.Subscription subscription){
        System.out.println("Sym");
        super.subscription = (StringSubscription) subscription;
        super.subscription.request(1);
    }

    public void onNext(String item){
        System.out.println("OnNext Symbol --> ");
        System.out.print(item);
    }
}
