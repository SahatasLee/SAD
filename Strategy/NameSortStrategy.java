package edu.parinya.softarchdesign.behavior2;

import java.util.Comparator;
import java.util.List;

public class NameSortStrategy implements SortStrategy {

    @Override
    public void customSort(List<Person> people) {
//        Collections.sort(people, this::compare);
        people.sort(Comparator.comparing(Person::getName));
    }

//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!

}
