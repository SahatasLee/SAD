package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    protected Set<HealthcareServiceable> members = new HashSet();

    public void addMember(HealthcareServiceable member){
        members.add(member);
    }

    public void addMember(HealthcareServiceable... member){
        members.addAll(List.of(member));
    }

    public void removeMember(HealthcareServiceable member){
        members.remove(member);
    }

    public void removeMember(HealthcareServiceable... member){
        List.of(member).forEach(members::remove);
    }

    @Override
    public void service() {
        for (HealthcareServiceable member: members) {
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double sum = 0.0;
        for (HealthcareServiceable member: members) {
            sum += member.getPrice();
        }
        return sum;
    }
}
