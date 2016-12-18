package wi.co.gpstrackerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final String[] CLASSPATH_PUBLIC_RESOURCE_LOCATIONS = { "classpath:/public/" };

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry
				.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry
				.addResourceHandler("/**")
				.addResourceLocations(CLASSPATH_PUBLIC_RESOURCE_LOCATIONS);
		}
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
	}

}
