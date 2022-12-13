package com.ColitasMaku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        /*auth.inMemoryAuthentication().withUser("Eduardo")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("Andres")
                .password("{noop}456")
                .roles("VENDEDOR","USER")
                .and()
                .withUser("Jostin")
                .password("{noop}789")
                .roles("USER");*/
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo", "articulo/guardar",
                        "/articulo/modificar/**", "/articulo/eliminar/**",
          
                        "/cliente/nuevo", "cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**",
                
                        "/pedido/nuevo",  "/pedido/guardar",
                        "/pedido/modificar",  "/pedido/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado", "/cliente/listado", "/pedido/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .antMatchers("/","/carrito/**")
                .permitAll()
                .antMatchers("/faturar/carrito")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");

    }

}
