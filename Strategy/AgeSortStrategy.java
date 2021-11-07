package edu.parinya.softarchdesign.behavior2;

import java.util.Comparator;
import java.util.List;

public class AgeSortStrategy implements SortStrategy {
    @Override
    public void customSort(List<Person> people) {
//        Collections.sort(people, this::compare);
        people.sort(Comparator.comparing(Person::getAge));
    }

//    @Override
//    public int compare(Person o1, Person o2) {
//        return Integer.compare(o1.getAge(), o2.getAge());
//    }
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!

}
