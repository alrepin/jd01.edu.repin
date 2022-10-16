package ga.repin.education.course02.topic11.hw.orders;

import static ga.repin.education.course02.topic11.hw.HwConstants.*;
import ga.repin.education.exceptions.ErrorMessage;
import ga.repin.education.exceptions.HttpException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RequestMapping(HW_ENDPOINT)
@RestController
@Scope("session")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage()));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(),exception.getMessage()));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public String index() {
        return orderService.index();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "/add")
    public void addItem(@RequestParam(value = "ids", required = false) List<Integer> idList) {
        orderService.add(idList);
    }

    @GetMapping(path = "/get")
    public Object getItems() {
        return orderService.get();
    }
}
