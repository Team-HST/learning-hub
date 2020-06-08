package com.hst.learninghub.authentication.provider;

import com.hst.learninghub.authentication.model.AuthenticationToken;
import com.hst.learninghub.configuration.properties.AppProperties;
import com.hst.learninghub.utils.TimeUtils;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
@ConditionalOnProperty(prefix = "app", name = "auth.freepass.enable", havingValue = "false")
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenProvider.class);

    private final AppProperties appProperties;

    public JwtAuthenticationTokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public String parseTokenString(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    public AuthenticationToken issue(Long userNo) {
        return AuthenticationToken.builder()
                .userNo(userNo)
                .token(buildToken(userNo))
                .build();
    }

    // JWT 토큰 생성
    private String buildToken(Long userNo) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredAt = now.plus(appProperties.getAuth().getTokenExpirationMs(), ChronoUnit.MILLIS);

        return Jwts.builder()
                .setSubject(String.valueOf(userNo))
                .setIssuedAt(TimeUtils.toDate(now))
                .setExpiration(TimeUtils.toDate(expiredAt))
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    @Override
    public Long getTokenOwnerNo(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    @Override
    public boolean validateToken(String token) {
        if (StringUtils.isNotEmpty(token)) {
            try {
                Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token);
                return true;
            } catch (SignatureException e) {
                logger.error("Invalid JWT signature", e);
            } catch (MalformedJwtException e) {
                logger.error("Invalid JWT token", e);
            } catch (ExpiredJwtException e) {
                logger.error("Expired JWT token", e);
            } catch (UnsupportedJwtException e) {
                logger.error("Unsupported JWT token", e);
            } catch (IllegalArgumentException e) {
                logger.error("JWT claims string is empty.", e);
            }
        }
        return false;
    }
}
