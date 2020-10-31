package com.hms.app.domain.security.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.hms.app.domain.services.UserService;

@Service
public class RoleBasedStartPageService implements AuthenticationSuccessHandler {
	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Resource
	private UserService userService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	
	public String getStartPage(Authentication authentication) {
		Map<String, String> roleUrlMap = new HashMap<>();
	    roleUrlMap.put("ADMIN", "/admin/admin-dashboard");
	    roleUrlMap.put("CUSTOMER", "/app/patient-dashboard");
	    roleUrlMap.put("DOCTOR", "/doc/doctor-dashboard");
	    for(GrantedAuthority authority:authentication.getAuthorities()) {
	    	if(roleUrlMap.containsKey(authority.getAuthority())) {
	    		return roleUrlMap.get(authority.getAuthority());
	    	}
	    }
	    
	    return "/home";
		

		
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		
	}
	private void handle(
	        HttpServletRequest request,
	        HttpServletResponse response, 
	        Authentication authentication
	) throws IOException {
	 
	    String targetUrl = getStartPage(authentication);
	 
	    if (response.isCommitted()) {
	        logger.debug(
	                "Response has already been committed. Unable to redirect to "
	                        + targetUrl);
	        return;
	    }
	 
	    redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session == null) {
	        return;
	    }
	    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
