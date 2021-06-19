/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nmrsreports.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.nmrsreports.api.NmrsreportsService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.Iterator;
import java.util.List;

/**
 *  * Controller for a fragment that shows all users  
 */
public class UsersFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("userService") UserService service) {
		String metadataModuleVersion = null;
		NmrsreportsService nmrsreportingService = Context.getService(NmrsreportsService.class);
		List<Module> modules = nmrsreportingService.getModules();
		Iterator var6 = modules.iterator();
		
		while (var6.hasNext()) {
			Module m = (Module) var6.next();
			if (m.getModuleId().equalsIgnoreCase("nmrsmetadata")) {
				metadataModuleVersion = m.getVersion();
			}
		}
		
		model.addAttribute("users", service.getAllUsers());
		model.addAttribute("metadataModuleVersion", metadataModuleVersion);
	}
}
