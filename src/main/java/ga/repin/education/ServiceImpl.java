package ga.repin.education;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {


    private String htmlFormat(String unformattedString) {
        return "<html><body link=\"aqua\" vlink=\"aqua\" bgcolor=\"blue\" text=\"aqua\"><h2>"
                + unformattedString
                + "<hr><a href=\"/.\">[ДОМОЙ]</a>   <a href=\".\">[НАЗАД]</a><hr>"
                + "</h2></body></html>";
    }

    public String operationIndex() {

        return htmlFormat("Выбор сервиса: "
                + "<hr><a href=\"/auth\">[АУТЕНТИФИКАЦИЯ]</a>"
                + "<br><a href=\"/calculator\">[КАЛЬКУЛЯТОР]</a>");
    }



}
