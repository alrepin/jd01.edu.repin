package ga.repin.education.course02.topic11.hw.orders;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope("session")
public class OrderServiceImpl implements OrderService {
    private final List<Integer> orderItems;

    public OrderServiceImpl(List<Integer> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public void add(List<Integer> idList) {
        //orderItems.addAll(idList);
        idList.stream().sequential()
                .collect(Collectors.toCollection(() -> orderItems));

    }

    @Override
    public Object get() {

        return orderItems.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        /*return orderItems
                .stream()
                .sequential()
                .sorted()
                .collect(Collectors.toList()
                );*/
    }

    @Override
    public String index() {
        return "hi";
    }
}
