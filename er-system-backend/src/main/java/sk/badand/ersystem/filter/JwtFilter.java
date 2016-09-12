package sk.badand.ersystem.filter;

import io.jsonwebtoken.*;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abadinka on 2. 9. 2016.
 */
public class JwtFilter extends GenericFilterBean {

    public static final String SIGNING_KEY = "secretKey";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("Authorization");

        if ("OPTIONS".equals(request.getMethod())) { //TODO: extract to options filter?
            response.setStatus(HttpServletResponse.SC_OK);
        } else {

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid authorization header.");
                return;
            }

            final String token = authHeader.substring(7); // The part after "Bearer "
            try {
                final Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            } catch (JwtException e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token! " + e.getMessage());
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
