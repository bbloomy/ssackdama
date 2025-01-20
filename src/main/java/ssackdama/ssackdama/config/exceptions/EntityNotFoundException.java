package ssackdama.ssackdama.config.exceptions;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }
    public EntityNotFoundException(String msg,ErrorCode code) {
        super(msg,code);
    }

}