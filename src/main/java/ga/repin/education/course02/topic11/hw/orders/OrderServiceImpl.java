package ga.repin.education.course02.topic11.hw.orders;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ga.repin.education.common.HtmlWrappers.*;
import static ga.repin.education.course02.topic11.hw.HwConstants.HW_ENDPOINT;

@Service
@SessionScope
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
                "Orders API Description" +
                        HR +
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
                        "<br>to return current session shopping cart." +
                        "</li>" +
                        "</ul>" +
                        hrefPrep(
                                HW_ENDPOINT + "/get", "\uD83D\uDECD ") +
                        commentPrep("<div id=\"demo\">Select goods and push +</div>", 3) +
                        orderFormSnippet(id)
        );
    }
}
