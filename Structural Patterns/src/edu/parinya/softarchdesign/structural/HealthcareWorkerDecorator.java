package edu.parinya.softarchdesign.structural;

public class HealthcareWorkerDecorator extends HealthcareWorker{
    protected HealthcareServiceable worker;

    HealthcareWorkerDecorator(HealthcareServiceable member){
        super((HealthcareWorker) member);
        worker = member;
    }

    @Override
    public void service() {
        worker.service();
    }

    @Override
    public double getPrice() {
        return worker.getPrice();
    }
}
