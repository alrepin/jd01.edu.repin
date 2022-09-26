package ga.repin.education.course02.topic04.hw.authentification;

public class Authentication {
    public static boolean verificateAuthenticationData(
            String login, String password, String confirmPassword) {
        return (checkLogin(login) && checkPassword(password) && comparePasswordWithConfirmPassword(password, confirmPassword));
    }

    public static boolean checkLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть не более 20 символов" +
                    ", а введено " + login.length());
        }
        if (!login.matches("^[a-zA-Z0-9_]*$")) {
            throw new WrongLoginException("Логин должен содержать только " +
                    "латинские буквы, цифры и знак подчеркивания");
        }
        return true;
    }

    public static boolean checkPassword(String password) {
        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль должен быть строго меньше 20 символов" +
                    ", а введено " + password.length());
        }
        if (!password.matches("^[a-zA-Z0-9_]*$")) {
            throw new WrongPasswordException("Пароль должен содержать только " +
                    "латинские буквы, цифры и знак подчеркивания");
        }
        return true;
    }

    public static boolean comparePasswordWithConfirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Параметры password и confirmPassword " +
                    "должны быть равны");
        }
        return true;
    }


}


