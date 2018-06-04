package site.it4u.zuul.conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import site.it4u.utils.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        boolean tokenInvalid = false;
        // 定义两个不需要过滤的api地址
        List<String> noTokenUrlList = Arrays.asList("/api/product/list", "/api/users/login");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        // 得到api的url地址
        String url = request.getRequestURI();
        // 需要校验token
        if(!noTokenUrlList.contains(url)) {
            //这里从url参数里获取, 也可以从cookie, header里获取
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) {
                tokenInvalid = true;
            }else {
                // 解密jwt
                Map<String, String> map = JwtHelper.verifyToken(token);
                Long exp = Long.valueOf(map.get("exp")); // 得到设置的过期时间
                Long now = System.currentTimeMillis();
                // 过期
                if(now - exp > JwtHelper.JWT_EXP_TIME_MILLIS) {
                    tokenInvalid = true;
                }
            }
        }
        if(tokenInvalid) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
