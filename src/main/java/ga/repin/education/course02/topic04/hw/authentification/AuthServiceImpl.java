package ga.repin.education.course02.topic04.hw.authentification;

import org.springframework.stereotype.Service;
import static ga.repin.education.course02.topic04.hw.authentification.Authentication.verificateAuthenticationData;
import static ga.repin.education.creation.HtmlWrappers.mainTheme;

@Service
public class AuthServiceImpl implements AuthService {

    public String operationAuth(String login, String password, String confirmPassword) {
        if (login == null || password == null || confirmPassword == null) {
            return mainTheme("Передайте три параметра: "
                    + "login, password и confirmPassword"
                    + "<hr><a href=\"/auth?login=java_skyprogo&password=D_1hWiKjjP_9"
                    + "&passconfirm=D_1hWiKjjP_9\">"
                    + "[Пример входа 01]</a>"
                    + " (попытка ввода корректных данных);"
                    + "<br><a href=\"/auth?login=java_skypro.go&password=D_1hWiKjjP_9"
                    + "&passconfirm=D_1hWiKjjP_9\">"
                    + "[Пример входа 02]</a>"
                    + " (недопустимый символ в логине - срабатывание WrongLoginException);"
                    + "<br><a href=\"/auth?login=java_skyprogojava_skyprogojava_skyprogojava_skyprogo&password=D_1hWiKjjP_9"
                    + "&passconfirm=D_1hWiKjjP_9\">"
                    + "[Пример входа 03]</a>"
                    + " (недопустимая длина логина - срабатывание WrongLoginException);"
                    + "<br><a href=\"/auth?login=java_skyprogo&password=D_1hWiKjjP_9"
                    + "&passconfirm=D_2hWiKjjP_9\">"
                    + "[Пример входа 04]</a>"
                    + " (разные пароли - срабатывание WrongPasswordException);"
                    + "."
            );
        }
        try {
            verificateAuthenticationData(login, password, confirmPassword);
        } catch (Exception e) {
            return mainTheme(e.getMessage());
        }
        return mainTheme("Введены корректные данные.");
    }
}