package net.sourceforge.wurfl.spring;

import java.util.Map;

import net.sourceforge.wurfl.core.CapabilityNotDefinedException;
import net.sourceforge.wurfl.core.MarkUp;

import org.springframework.mobile.device.Device;

/**
 * WURFL-based {@link Device} implementation.
 * Also implements net.sourceforge.wurfl.core.Device, exposing the full capabilities of the WURFL API.
 * @author Keith Donald
 * @author Roy Clarkson
 */
public class WurflDevice implements Device, net.sourceforge.wurfl.core.Device {

	private final net.sourceforge.wurfl.core.Device device;
	
	public WurflDevice(net.sourceforge.wurfl.core.Device device) {
		this.device = device;
	}

	// implementing our Device interface
	
	public boolean isMobile() {
		String capability = getCapability("is_wireless_device");
		return capability != null && Boolean.valueOf(capability) && !isTablet();
	}
	
	public boolean isTablet() {
	    String capability = getCapability("is_tablet");
	    return capability != null && Boolean.valueOf(capability);
	}
	
	public boolean isNormal() {
	    return !isMobile() && !isTablet();
	}

	// implementing Wurfl Device
	
	public String getId() {
		return device.getId();
	}

	public String getUserAgent() {
		return device.getUserAgent();
	}

	public String getCapability(String name) throws CapabilityNotDefinedException {
		return device.getCapability(name);
	}

	@SuppressWarnings("rawtypes")
	public Map getCapabilities() {
		return device.getCapabilities();
	}

	public MarkUp getMarkUp() {
		return device.getMarkUp();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[WurflDevice ");
		builder.append("mobile").append("=").append(isMobile()).append(", ");
		builder.append("id").append("=").append(getId()).append(", ");
		builder.append("userAgent").append("=").append(getUserAgent()).append(", ");
		builder.append("capabilities").append("=").append(getCapabilities()).append(", ");
		builder.append("markup").append("=").append(getMarkUp());
		builder.append("]");
		return builder.toString();
	}

	public String getDeviceRootId() {
		return device.getDeviceRootId();
	}

	public boolean isActualDeviceRoot() {
		return device.isActualDeviceRoot();
	}

}