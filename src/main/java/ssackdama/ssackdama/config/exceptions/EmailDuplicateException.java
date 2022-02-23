package ssackdama.ssackdama.config.exceptions;

public class EmailDuplicateException extends InvalidValueException{

    public EmailDuplicateException(String email) {
        super(email,ErrorCode.EMAIL_DUPLICATION);//중복된 이메일, 에러코드
    }
}
