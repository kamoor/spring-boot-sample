package com.samples.boot.server;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

/**
 * customize any server configuration
 * @author kamoorr
 */
public class NubeServerCustomization extends ServerProperties {

	static Logger logger = Logger.getLogger(NubeServerCustomization.class);

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		super.customize(container);
		TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) container;
        containerFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
            	connector.setProperty("compression","on");
            	connector.setProperty("compressableMimeTypes", "application/json,application/xml");
            }
        });
	}
	
	


}
