package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{

    public TaxPayingHealthcareWorker(HealthcareServiceable member){
        super(member);
        System.out.println("Decorate " + getName() + " with TaxPaying");
//        Decorate Nicholas Gonzalez with TaxPaying.
    }
    @Override
    public double getPrice() {

        return super.getPrice()*1.1;
    }
}
