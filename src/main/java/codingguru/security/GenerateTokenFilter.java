package codingguru.security;

import java.io.IOException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import codingguru.utilities.JWTHelper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class GenerateTokenFilter implements Filter {
	@Value("${codingguru.clientId}")
	private String clientId;
	@Value("${codingguru.clientSecret}")
	private String clientSecret;
	@Value("${codingguru.username}")
	private String username;
	@Value("${codingguru.password}")
	private String password;
	@Autowired
	private JWTHelper jwtHelper;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if(req.getServletPath().contains("api/v1/token") && req.getMethod().equals("POST")) {
			String clientId = req.getHeader("clientId");
			String clientSecret = req.getHeader("clientSecret");	
			String username = req.getHeader("username");
			String password = req.getHeader("password");
			
			if(Strings.isBlank(clientId) || Strings.isBlank(clientSecret) &&
			   Strings.isBlank(username) || Strings.isBlank(password)) {
				res.setStatus(401);
				res.getWriter().print("Invalid Client Key or Secret");
				return;
			}
			
			if(clientId.equals(this.clientId) && clientSecret.equals(this.clientSecret) &&
			   username.equals(this.username) && password.equals(this.password)) {
				res.setStatus(200);
				res.getWriter().print(jwtHelper.createJWT(username, "codingguru", 36000000));
				return;
			} else {
				res.setStatus(401);
				res.getWriter().print("Invalid Client Key or Secret");
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
