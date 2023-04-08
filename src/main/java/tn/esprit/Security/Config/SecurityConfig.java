package tn.esprit.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



  /*  @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowedMethods("*");
                // .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization");
                // .exposedHeaders("Authorization")
                // .allowCredentials(true);
                // .maxAge(3600);

            }
        };
    }*/

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
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/registration/**").permitAll();
        http.authorizeRequests().antMatchers(GET ,"/User/**").hasAnyAuthority("Admin");
        http.authorizeRequests().antMatchers(GET ,"/DeliveryPerson/**").hasAnyAuthority("Admin");
      //  http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthentificationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        // Configure CORS
        http.cors().configurationSource(request -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
            corsConfiguration.setAllowedMethods(Arrays.asList("*"));
            corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
            return corsConfiguration;
        });
    }


     @Bean
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