package ssackdama.ssackdama.config.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ssackdama.ssackdama.domain.Member;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {
    private Member member;
    public PrincipalDetails(Member member){
        this.member=member;
    }
    // Member의 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect=new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collect;
    }
    //password
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    //email
    @Override
    public String getUsername() {
        return member.getEmail();
    }

    //address
    public Member getMember(){
        return member;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 1년동안 로그인안하면 휴면계정
        // 현재시간-마지막로그인시간
        return true;
    }
}
