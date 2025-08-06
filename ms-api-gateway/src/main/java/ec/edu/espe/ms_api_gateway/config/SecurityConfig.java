package ec.edu.espe.ms_api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ec.edu.espe.ms_api_gateway.filter.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private static final String SECRET_KEY = "u6rckmOPVwT9OuoWZf9lZtabfM6TTRGTYiS6OQ4Nkb8=";

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(SECRET_KEY);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                                // Permitir acceso público
//                                .anyRequest().permitAll()
                                .requestMatchers("/api/v1/api/auth/**").permitAll()
                                .requestMatchers("/api/v1/api/roles/**").permitAll()
                                // Permitir GET para ROLE_USER y ROLE_ADMIN
                                .requestMatchers(HttpMethod.GET, "/api/v1/api/autores/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/api/libros/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/api/articulos-cientificos/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/notificaciones/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/v1/catalogo/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                // Proteger otras operaciones para ROLE_ADMIN
                                .requestMatchers("/api/v1/api/autores/**").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers("/api/v1/api/libros/**").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers("/api/v1/api/articulos-cientificos/**").hasAnyAuthority("ROLE_ADMIN")
                                //Cualquier otra
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
