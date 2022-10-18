package ga.repin.education.course02.topic04.hw.authentification;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
