package ga.repin.education.course02.topic11.hw.orders;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ga.repin.education.course02.topic11.hw.HwConstants.*;
import static ga.repin.education.creation.HtmlWrappers.*;

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
    public String index(String id) {
        return mainTheme(
                hrefPrep(
                        HW_ENDPOINT + "/get", "view Orders \uD83D\uDECD - API get method (clickable)") +
                        HR +
                        "Orders API Description" +
                        "A JSON interface is offered to manage orders via HTTP.<br>" +
                        "API access is provided at the following URLs:<br>" +
                        "<ul type=\"square\">" +

                        "<li>" +
                        HW_ENDPOINT +
                        "/add?ids=&ltarticle numbers of goods delimited with comma&gt " +
                        "<br>to add chosen positions to the session shopping cart;" +
                        "</li>" +

                        "<li>" +
                        HW_ENDPOINT +
                        "/get" +
                        "<br>to return current session shopping cart. (Demo link in title)" +
                        "</li>" +
                        "</ul>" +
                        commentPrep("Adding Demo (selecting in form by JS):", 3) +
                        orderFormSnippet(id) +
                        BR

        );
    }
}
