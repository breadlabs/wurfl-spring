package net.sourceforge.wurfl.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Registers bean-definition parsers for the device XML configuration namespace.
 * @author Keith Donald
 */
public class WurflNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("device-resolver", new WurflDeviceResolverBeanDefinitionParser());
	}

}

