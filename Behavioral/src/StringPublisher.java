
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;

public class StringPublisher extends StringSubscription implements Flow.Publisher {
    String name;
    Map<String, List<StringSubscriber>> subscribers = new HashMap<>();

    StringPublisher(String name){
        this.name = name;
        this.subscribers.put("alphabet", new ArrayList<StringSubscriber>());
        this.subscribers.put("number", new ArrayList<StringSubscriber>());
        this.subscribers.put("symbol", new ArrayList<StringSubscriber>());
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscriber.onNext("Subscribe");
        StringSubscriber user = (StringSubscriber) subscriber;
//        System.out.println("type --> " + user.getType());
        List<StringSubscriber> subscribe = this.subscribers.get(user.getType());
//        System.out.println(this.subscribers.get("number") + "  " + subscribe);
        subscribe.add((StringSubscriber) subscriber);
        subscriber.onComplete();
    }

    public void submit(Object item){
        if(item instanceof String){
            List<StringSubscriber> subscribe = this.subscribers.get("alphabet");
            for(StringSubscriber subscriber : subscribe){
                subscriber.onNext(item);
            }
        } else if(item instanceof Integer){
            List<StringSubscriber> subscribe = this.subscribers.get("number");
            for(StringSubscriber subscriber : subscribe){
                subscriber.onNext(item);
            }
        } else if(item instanceof Boolean){
            List<StringSubscriber> subscribe = this.subscribers.get("symbol");
            for(StringSubscriber subscriber : subscribe){
                subscriber.onNext(item);
            }
        }
    }

}
