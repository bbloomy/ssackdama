package ssackdama.ssackdama.domain;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class Email {
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Column(name = "email")
    private String value;


    public Email(String emailAddress) {
        Assert.isTrue(isValid(emailAddress), "유효하지 않은 이메일 주소입니다.");
        this.value = emailAddress;
    }

    protected Email() {

    }

    public static boolean isValid(String candidate) {
        return candidate == null ? false : PATTERN.matcher(candidate).matches();
    }

    @Override
    public String toString() {
        return value;
    }
}
