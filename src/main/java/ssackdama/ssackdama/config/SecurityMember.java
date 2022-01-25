package ssackdama.ssackdama.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.domain.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter@Setter
public class SecurityMember extends User{
    public SecurityMember(Member member){
        super(member.getEmail(),member.getPassword(),makeGrantedAuthority(member.getRole()));

    }



    private static List<GrantedAuthority> makeGrantedAuthority(Role role){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(role.toString()));
        return list;
    }

}
