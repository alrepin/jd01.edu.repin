package ga.repin.education.course02.topic04.hw.authentification;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }
}
