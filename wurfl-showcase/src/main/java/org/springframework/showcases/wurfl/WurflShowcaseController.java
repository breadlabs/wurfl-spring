/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.showcases.wurfl;

import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the wurfl showcase.
 * @author Keith Donald
 */
@Controller
public class WurflShowcaseController {

	/**
	 * Show the home page to the user.
	 * Declares a {@link SitePreference} parameter to show how you can resolve the user's site preference.
	 * This controller renders a different version of the home view if the user has a mobile site preference.
	 */
	@RequestMapping("/")
	public String home(SitePreference sitePreference) {
		if (sitePreference == SitePreference.MOBILE) {
			return "home-mobile";
		} else {
			return "home";
		}
	}
	
	/**
	 * Show a page generated by WNG to the user.
	 * The page will automatically render in format that's graded as the optimal format for the user's device (e.g. WML, XHTML Simple, XHTML Advanced).
	 */
	@RequestMapping("/wng")
	public void wng() {
	}

}