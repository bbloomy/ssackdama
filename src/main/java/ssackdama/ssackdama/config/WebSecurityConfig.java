package ssackdama.ssackdama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ssackdama.ssackdama.service.MemberServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private MemberServiceImpl memberServiceImpl;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
        .authorizeRequests()
        .antMatchers("/","/css/**","/img/**","/signup").permitAll()
        .anyRequest().authenticated()//인증
        ;
        http
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .usernameParameter("email");
        http
        .logout()
        .logoutSuccessUrl("/")
        .permitAll();

        }
    @Override//로그인
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberServiceImpl).passwordEncoder(passwordEncoder());
    }


}

