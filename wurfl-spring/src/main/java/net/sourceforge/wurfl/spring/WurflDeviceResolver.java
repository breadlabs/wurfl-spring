package net.sourceforge.wurfl.spring;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.wurfl.core.WURFLManager;
import net.sourceforge.wurfl.core.request.DefaultWURFLRequestFactory;
import net.sourceforge.wurfl.core.request.WURFLRequestFactory;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceResolver;

/**
 * WURFL-based device resolver.
 * WURL provides a comprehensive catalog of Devices and their capabilities.
 * See http://wurfl.sourceforge.net for more information.
 * @author Keith Donald
 */
public class WurflDeviceResolver implements DeviceResolver {

	private final WURFLManager wurflManager;

	private final WURFLRequestFactory requestFactory;

	/**
	 * Creates a new Wurfl-based device resolution service.
	 * @param wurflManager the central WURFL manager object to delegate to.
	 */
	public WurflDeviceResolver(WURFLManager wurflManager) {
		this(wurflManager, new DefaultWURFLRequestFactory());
	}

	/**
	 * Creates a new Wurfl-based device resolution service.
	 * @param wurflManager the central WURFL manager object to delegate to
	 * @param requestFactory a custom WurflRequest factory
	 */
	public WurflDeviceResolver(WURFLManager wurflManager, WURFLRequestFactory requestFactory) {
		this.wurflManager = wurflManager;
		this.requestFactory = requestFactory;
	}

	public Device resolveDevice(HttpServletRequest request) {
		return new WurflDevice(wurflManager.getDeviceForRequest(requestFactory.createRequest(request)));
	}

}