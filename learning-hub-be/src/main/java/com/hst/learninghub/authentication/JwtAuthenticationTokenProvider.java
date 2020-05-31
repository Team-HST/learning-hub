package com.hst.learninghub.authentication;

import com.hst.learninghub.configuration.properties.AppProperties;
import com.hst.learninghub.utils.TimeUtils;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class JwtAuthenticationTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenProvider.class);

    private final AppProperties appProperties;

    public JwtAuthenticationTokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    /***
     * 토큰 발급
     * @param userNo 유저 No
     * @return 토큰
     */
    public AuthenticationToken issue(Long userNo) {
        return AuthenticationToken.builder()
                .userNo(userNo)
                .token(buildToken(userNo))
                .build();
    }

    // JWT 토큰 생성
    private String buildToken(Long userNo) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredAt = now.plus(appProperties.getAuth().getExpiredMs(), ChronoUnit.MILLIS);

        return Jwts.builder()
                .setSubject(String.valueOf(userNo))
                .setIssuedAt(TimeUtils.toDate(now))
                .setExpiration(TimeUtils.toDate(expiredAt))
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    /***
     * 토큰에서 userNo 취득
     * @param token 토큰
     * @return userNo
     */
    public Long getTokenOwnerNo(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    /***
     * 토큰 유효성 검사
     * @param token 토큰
     * @return 유효여부
     */
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
