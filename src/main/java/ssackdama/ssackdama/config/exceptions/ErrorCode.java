package ssackdama.ssackdama.config.exceptions;
public enum ErrorCode {

    /* Common */
    /*BusinessException*/
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),//InvalidValueException
    ENTITY_NOT_FOUND(400, "C002", " Entity Not Found"),//EntityNotFoundException

    /*Member*/
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    MEMBER_NOT_FOUND(400,"M002","Member not Found"),
    ;
    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }


}