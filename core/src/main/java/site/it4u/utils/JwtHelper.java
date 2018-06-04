package site.it4u.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtHelper {
  
  private static final String SECRET = "it4u";
  
  private static final String ISSUER = "it4u";

  public static final Long JWT_EXP_TIME_MILLIS = 1000 * 60 * 60L; // jwt 有效期：1小时

  /**
   * 生成token
   * @param claims
   * @return
   */
  public static String genToken(Map<String, String> claims){
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addHours(new Date(), 1));
      claims.forEach((k,v) -> builder.withClaim(k, v));
      return builder.sign(algorithm).toString();
    } catch (IllegalArgumentException | UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 解密token
   * @param token
   * @return
   */
  public static Map<String, String> verifyToken(String token)  {
    Algorithm algorithm;
    try {
      algorithm = Algorithm.HMAC256(SECRET);
    } catch (IllegalArgumentException | UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
    DecodedJWT jwt = verifier.verify(token);
    Map<String, Claim> map = jwt.getClaims();
    Map<String, String> resultMap = new HashMap<>();
    map.forEach((k,v) -> resultMap.put(k, v.asString()));
    return resultMap;
  }

}
