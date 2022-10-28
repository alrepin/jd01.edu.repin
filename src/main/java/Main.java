import ga.repin.education.common.model.RndPersonKey;
import ga.repin.education.course02.topic13.hw.employees.EmployeeServiceV5Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<RndPersonKey> rp = new ArrayList<>();
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            rp.add(new RndPersonKey("test"));

            q.add(rp.get(i).getAvailableQuantity());


            rp.add(new RndPersonKey("test2"));
            i++;
            q.add(rp.get(i).getAvailableQuantity());

        }

        rp.forEach(p ->
                System.out.println( (rp.indexOf(p) + 1) + " " +
                        p.getName() + " " +
                        p.getSurname() + " " +
                        p.listEqualCallings() + " reserve: " +
                        q.get(rp.indexOf(p))));

        /*IntStream.range(0, rp.size())
                .mapToObj(i ->
                        System.out.println(//"".valueOf(i) + " " +
                                rp.get(i).getName() + " " +
                                rp.get(i).getSurname() + " " +
                                rp.get(i).listEqualCallings() + " reserve: " +
                                rp.get(i).getAvailableQuantity()));*/


    }


}