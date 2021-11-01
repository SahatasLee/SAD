
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
        String str = (String) item;
        if(str != ""){
            if(checkNum(item)){
                List<StringSubscriber> subscribe = this.subscribers.get("number");
                for(StringSubscriber subscriber : subscribe){
                    subscriber.onNext(item);
                }
            }

            if(checkSym(item)){
                List<StringSubscriber> subscribe = this.subscribers.get("symbol");
                for(StringSubscriber subscriber : subscribe){
                    subscriber.onNext(item);
                }
            }

            if(checkAlp(item)){
                List<StringSubscriber> subscribe = this.subscribers.get("alphabet");
                for(StringSubscriber subscriber : subscribe){
                    subscriber.onNext(item);
                }
            }
        }
//        if(item instanceof String){
//            List<StringSubscriber> subscribe = this.subscribers.get("alphabet");
//            for(StringSubscriber subscriber : subscribe){
//                subscriber.onNext(item);
//            }
//        } else if(item instanceof Integer){
//            List<StringSubscriber> subscribe = this.subscribers.get("number");
//            for(StringSubscriber subscriber : subscribe){
//                subscriber.onNext(item);
//            }
//        } else if(item instanceof Boolean){
//            List<StringSubscriber> subscribe = this.subscribers.get("symbol");
//            for(StringSubscriber subscriber : subscribe){
//                subscriber.onNext(item);
//            }
//        }
    }

    public boolean checkSym(Object item){
        String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        String str = (String)  item;
        boolean check = false;
        for(int i = 0;i < str.length();i++){
            String strChar = Character.toString(str.charAt(i));
            if (specialChars.contains(strChar)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkNum(Object item){
        String number = "1234567890";
        String str = (String)  item;
        boolean check = false;
        for(int i = 0;i < str.length();i++){
            String strChar = Character.toString(str.charAt(i));
            if (number.contains(strChar)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkAlp(Object item){
        String str = (String)  item;
        boolean check = false;
        for(int i = 0;i < str.length();i++){
            int asciiVal = (int) str.charAt(i);
            // Check whether String contains special character or not
            if ((65 <= asciiVal && asciiVal <= 90) || (97 <= asciiVal && asciiVal <= 122)) {
                check = true;
                break;
            }
        }
        return check;
    }

}
