package com.tobias.saul.shiro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.SecurityContext;

import org.apache.shiro.authz.annotation.RequiresAuthentication;

import com.okta.shiro.OktaJwtPrincipal;

// base path for all methods in class
@Path("/")
// returns plain text
@Produces("plain/text")
public class SecureResource {
	
	// handles GET requests
	@GET
	
	// requires authentication
	@RequiresAuthentication
	public String showUser(SecurityContext securityContext) { // inject current user's security context
		// if you want other information out of access token
		OktaJwtPrincipal jwtPrincipal = (OktaJwtPrincipal) securityContext;
		System.out.println("jwtPrincipal Name: " + jwtPrincipal.getName());
		System.out.println("jwt Access Toke Value: " + jwtPrincipal.getJwtAccessToken().getTokenValue());
		
		return "Current User" + securityContext.getUserPrincipal().getName(); //get name from the Java Principal
	}

}
