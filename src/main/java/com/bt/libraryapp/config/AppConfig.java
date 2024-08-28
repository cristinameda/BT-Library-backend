package com.bt.libraryapp.config;

import com.bt.libraryapp.entity.User;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.repository.user.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@AllArgsConstructor
public class AppConfig {

  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      Optional<User> optionalUser = userRepository.findByUsername(username);

      if (optionalUser.isPresent()) {
        return optionalUser.get();
      }

      throw new NotFoundException("User with username " + username + " could not be found!");
    };
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
      throws Exception {
    return configuration.getAuthenticationManager();
  }

  //  @Bean
  //  public CorsConfigurationSource corsConfigurationSource() {
  //    CorsConfiguration corsConfiguration = new CorsConfiguration();
  //    corsConfiguration.setAllowedOrigins(
  //        List.of("https://its-app-07-dev", "https://its-app-07-dev:445"));
  //    corsConfiguration.setAllowedMethods(List.of("*"));
  //    corsConfiguration.setAllowCredentials(true);
  //    corsConfiguration.setAllowedHeaders(List.of("*"));
  //    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  //    source.registerCorsConfiguration("/**", corsConfiguration);
  //    return source;
  //  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(List.of("*")); // Allow all origins for testing
    corsConfiguration.setAllowedMethods(List.of("*")); // Allow all methods
    corsConfiguration.setAllowCredentials(true); // If you need credentials, set this to true
    corsConfiguration.setAllowedHeaders(List.of("*")); // Allow all headers
    corsConfiguration.setExposedHeaders(
        List.of("Authorization")); // Expose the Authorization header if needed

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
