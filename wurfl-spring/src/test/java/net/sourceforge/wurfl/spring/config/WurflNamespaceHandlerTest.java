package net.sourceforge.wurfl.spring.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceResolver;
import org.springframework.mock.web.MockHttpServletRequest;

public class WurflNamespaceHandlerTest {
	
	@Test
	@Ignore
	public void wurflDeviceResolutionService() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("net/sourceforge/wurfl/spring/config/device.xml");
		DeviceResolver service = context.getBean("root", DeviceResolver.class);
		MockHttpServletRequest request = new MockHttpServletRequest();
		Device device = service.resolveDevice(request);
		assertNotNull(device);
		assertTrue(device.isMobile());
		context.getBean("rootAndPatches", DeviceResolver.class);
	}
	
}