package codingguru.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import codingguru.utilities.JWTHelper;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(2)
public class ValidateTokenFilter implements Filter {
	
	@Autowired
	private JWTHelper jwtHelper;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String token = req.getHeader("Authorization");
		if(token == null) {
			res.setStatus(401);
			res.getWriter().write("Invalid Token!");
			return;
		}
		try {
			jwtHelper.decodeJWT(token.split(" ")[1]);
		} catch(SignatureException ex) {
			res.setStatus(401);
			res.getWriter().write("Invalid Token!");
			return;
		}
		chain.doFilter(request, response);
	}

}
