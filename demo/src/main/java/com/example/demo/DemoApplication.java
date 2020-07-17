package com.example.demo;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements ErrorController {

	private final static String PATH = "/error";

//	@RequestMapping("/resource")
//	public Map<String, Object> home() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("id", UUID.randomUUID().toString());
//		model.put("content", "Hello World");
//		return model;
//	}

	@RequestMapping("/")
	@CrossOrigin(origins="*", maxAge=3600)
	public Message home() {
		return new Message("Hello World");
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/* Adapter removed to test other type of Filter 	security */
//	@Configuration
//	@Order(SecurityProperties.IGNORED_ORDER)
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/home", "/login").permitAll()
//					.anyRequest().authenticated().and().csrf()
//					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		}
//	}

	@RequestMapping(value = PATH)
	public String error() {
		return "forward:/index.html";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session){
		return Collections.singletonMap("token", session.getId());
	}

	class Message {
		private String id = UUID.randomUUID().toString();
		private String content;

		public Message(String content) {
			this.content = content;
		}

		public Message() {
			super();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
