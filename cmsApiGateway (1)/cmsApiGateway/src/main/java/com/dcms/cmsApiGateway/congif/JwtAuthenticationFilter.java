package com.dcms.cmsApiGateway.congif;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {
    private static final String SECRET_KEY = "myverysecuresecretkeywith32chars";
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private static final List<String> EXCLUDED_PATHS = List.of("/DCMS-SECURITY/auth/register", "/DCMS-SECURITY/auth/login"); // Excluded routes

    public JwtAuthenticationFilter() {
        super(Config.class); // Pass the Config class to the superclass
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();

            // Skip validation for excluded paths
            if (EXCLUDED_PATHS.stream().anyMatch(path::startsWith)) {
                return chain.filter(exchange); // Skip validation
            }

            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            // Validate the Authorization header
            if (config.isJwtValidationEnabled() && authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);

                try {
                    // Parse and validate the JWT
                    Claims claims = Jwts.parserBuilder()
                            .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                            .build()
                            .parseClaimsJws(token)
                            .getBody();

                    // Add claims to the request headers
                    ServerHttpRequest request = exchange.getRequest().mutate()
                            .header("X-User-Id", claims.getSubject()) // Add the user ID
                            .header("X-User-Role", claims.get("role", String.class)) // Add the user role
                            .build();

                    exchange = exchange.mutate().request(request).build();
                } catch (Exception e) {
                    logger.error("JWT validation failed", e);
                    exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            } else if (config.isJwtValidationEnabled()) {
                logger.warn("Missing or invalid Authorization header");
                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            // Proceed with the filter chain
            return chain.filter(exchange);
        };
    }


    public static class Config {
        private boolean jwtValidationEnabled = true;

        public boolean isJwtValidationEnabled() {
            return jwtValidationEnabled;
        }

        public void setJwtValidationEnabled(boolean jwtValidationEnabled) {
            this.jwtValidationEnabled = jwtValidationEnabled;
        }
    }
}
