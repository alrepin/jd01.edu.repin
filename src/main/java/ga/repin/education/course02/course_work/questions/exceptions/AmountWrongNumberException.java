package ga.repin.education.course02.course_work.questions.exceptions;

public class AmountWrongNumberException extends RuntimeException{
    public AmountWrongNumberException (){
        super("There is no such quantity");
    }

    public AmountWrongNumberException (String message){
        super(message);
    }
}
