package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer{
	public void onStartup(ServletContext container) {
		
		
		//Déclaration des classes de configuration
		AnnotationConfigWebApplicationContext myContext = new AnnotationConfigWebApplicationContext();
		AnnotationConfigWebApplicationContext myWebContext = new AnnotationConfigWebApplicationContext();
//		AnnotationConfigWebApplicationContext myApiContext = new AnnotationConfigWebApplicationContext();
		
		myContext.register(AppConfig.class);
		myWebContext.register(WebConfig.class);
//		myApiContext.register(ApiConfig.class);
		
		//Déclaration de l'écouteur Spring pour charger le context
		container.addListener(new ContextLoaderListener(myContext));
		
		//Déclaration de la Servlet DispatcherServlet
//		DispatcherServlet apiServlet = new DispatcherServlet(myApiContext);
//		ServletRegistration.Dynamic api = container.addServlet("api", apiServlet);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(myWebContext);
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
//		api.addMapping("/api/*");
//		api.setLoadOnStartup(2);
	}
}
