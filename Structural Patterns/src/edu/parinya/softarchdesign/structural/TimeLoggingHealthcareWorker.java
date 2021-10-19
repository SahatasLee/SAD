package edu.parinya.softarchdesign.structural;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareServiceable member){
        super(member);
        System.out.println("Decorate " + getName() + " with TimeLogging");
//        Decorate Nicholas Gonzalez with TimeLogging.
    }

    @Override
    public void service() {
        System.out.print("Thu Oct 14 00:57:26 ICT 2021:");
        super.service();
    }
}
