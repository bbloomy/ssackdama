package ssackdama.ssackdama.config.exceptions;

public class MemberNotFoundException extends EntityNotFoundException {
    public MemberNotFoundException(String msg) {
        super(msg,  ErrorCode.MEMBER_NOT_FOUND);
    }
}
