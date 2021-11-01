

import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription{
    public long number = 0;

    @Override
    public void request(long n) {
//        System.out.println("Subscription");
        number += n;
    }

    @Override
    public void cancel() {
        System.out.println("cancel");
    }
}
