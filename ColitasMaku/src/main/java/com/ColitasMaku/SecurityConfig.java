package com.ColitasMaku;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Eduardo")
                .password("{noop}123")
                .roles("ADMIN", "USER", "VENDEDOR")
                .and()
                .withUser("Andres")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .and()
                .withUser("Jostin")
                .password("{noop}789")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo",   "articulo/guardar",
                        "/articulo/modificar/**", "/articulo/eliminar/**",
                        
                        "/categoria/nuevo",        "categoria/guardar",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        
                        "/cliente/nuevo",        "cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**",
                        
                        "/usuario/nuevo",        "usuario/guardar",
                        "/usuario/modificar/**", "/usuario/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado",
                        "categoria/listado",
                        "cliente/listado")
                .hasAnyRole("ADMIN")
                .antMatchers("/","/carrito/**")
                .permitAll()
                .antMatchers("facturar/carrito")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
