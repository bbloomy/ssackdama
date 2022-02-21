package ssackdama.ssackdama.config.exceptions;

public class BussinessException extends RuntimeException{
    private ErrorCode errorCode;
    public BussinessException(String msg,ErrorCode errorCode){
        super(msg);
        this.errorCode=errorCode;
    }
    public BussinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }
    public ErrorCode getErrorCode(){
        return errorCode;
    }
}
