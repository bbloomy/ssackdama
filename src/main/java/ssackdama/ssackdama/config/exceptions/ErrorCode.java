package ssackdama.ssackdama.config.exceptions;
public enum ErrorCode {

    /* Common */
    // 400 - Bad Request
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
    INVALID_TYPE_VALUE(400, "C002", " Invalid Type Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    // 403 - Forbidden
    HANDLE_ACCESS_DENIED(403, "C004", "Access is Denied"),
    // 405 - 리소스 허용 x
    METHOD_NOT_ALLOWED(405, "C005", " Invalid Input Value"),
    // 서버
    INTERNAL_SERVER_ERROR(500, "C006", "Server Error"),

    /*Member*/

    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),

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