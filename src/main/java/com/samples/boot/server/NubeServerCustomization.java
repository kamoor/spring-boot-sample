package com.samples.boot.server;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;

/**
 * customize any server configuration
 * @author kamoorr
 */
public class NubeServerCustomization extends ServerProperties {

	static Logger logger = Logger.getLogger(NubeServerCustomization.class);

	/**
	 * This will override any properties loaded by application.properties. Be
	 * careful about this one
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		super.customize(container);
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
				"/jsp/404.jsp"));
		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
				"/jsp/500.jsp"));
		container.addErrorPages(new ErrorPage("/jsp/error.jsp"));
		logger.info("Server customized.");
	}

}
