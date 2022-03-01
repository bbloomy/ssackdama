package ssackdama.ssackdama.config.exceptions;

public class EmailDuplicateException extends InvalidValueException{

    public EmailDuplicateException(String msg) {
        super(msg,ErrorCode.EMAIL_DUPLICATION);
    }

}
