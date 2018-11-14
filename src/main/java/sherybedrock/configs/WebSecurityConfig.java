package sherybedrock.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Enable authentication with user admin
     * <p>
     * Spring Security will provide a default login form where insert username
     * and password.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        // Defines user with password and role
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }

    /**
     * Disable CSRF protection (to simplify this demo) and enable the default
     * login form.
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Disable CSRF protection
                .csrf().disable()
                // Set default configurations from Spring Security
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
