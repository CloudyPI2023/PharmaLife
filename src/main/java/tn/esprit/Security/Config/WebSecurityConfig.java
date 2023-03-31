package tn.esprit.Security.Config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tn.esprit.Services.UserService;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration/**","/login/**","/PharmaLife/User/all-Users")
                .permitAll()
                .anyRequest()
                .authenticated().and();
              //  .formLogin();
    }*/

   /* @Override
    protected void configure(HttpSecurity http) throws Exception{

        //http
        //.logout()
        //.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
      /*  http.cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/PharmaLife/registration/**", "/PharmaLife/login/**").permitAll().and();
       // http.authorizeRequests().antMatchers(HttpMethod.GET,"/PharmaLife/User/all-Users").hasAnyAuthority("Admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/PharmaLife/User/all-Users").permitAll().and();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthentificationFilter(authenticationManager()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);*/


	/*http
	.authorizeRequests()
    .antMatchers("/registration/**","/User/**")
    .permitAll()
    .anyRequest()
    .authenticated();*/
    /*http.cors().and().csrf().disable().exceptionHandling().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/PharmaLife/User/all-Users").permitAll().antMatchers("/api/test/**").permitAll().anyRequest()
				.authenticated();
		http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new CustomAuthentificationFilter(authenticationManagerBean()));

    }

     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws  Exception{
       return super.authenticationManagerBean();

     }


      /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }*/
}