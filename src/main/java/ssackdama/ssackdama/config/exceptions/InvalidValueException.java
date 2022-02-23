package ssackdama.ssackdama.config.exceptions;

public class InvalidValueException extends BusinessException{
    public InvalidValueException(String value){
        super(value,ErrorCode.INVALID_INPUT_VALUE);
    }
    public InvalidValueException(String msg, ErrorCode errorCode) {
        super(msg, errorCode);
    }
}
