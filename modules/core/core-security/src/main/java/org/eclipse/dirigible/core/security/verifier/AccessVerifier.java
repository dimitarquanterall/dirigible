/**
 * Copyright (c) 2010-2018 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */
package org.eclipse.dirigible.core.security.verifier;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.eclipse.dirigible.core.security.api.AccessException;
import org.eclipse.dirigible.core.security.api.ISecurityCoreService;
import org.eclipse.dirigible.core.security.definition.AccessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that checks whether the location is secured via the *.access file
 */
public class AccessVerifier {

	private static final Logger logger = LoggerFactory.getLogger(AccessVerifier.class);

	/**
	 * Checks whether the URI is secured via the *.access file or not
	 *
	 * @param securityCoreService
	 *            the security core service
	 * @param scope
	 *            the scope
	 * @param path
	 *            the path
	 * @param method
	 *            the method
	 * @return all the most specific AccessDefinition entry matching the URI if any
	 * @throws ServletException
	 *             the servlet exception
	 * @throws AccessException
	 *             the access exception
	 */
	public static List<AccessDefinition> getMatchingAccessDefinitions(ISecurityCoreService securityCoreService, String scope, String path, String method)
			throws ServletException, AccessException {
		List<AccessDefinition> accessDefinitions = new ArrayList<AccessDefinition>();
		AccessDefinition current = null;
		for (AccessDefinition accessDefinition : securityCoreService.getAccessDefinitions()) {
			if (scope.equalsIgnoreCase(accessDefinition.getScope()) && path.startsWith(accessDefinition.getPath())
					&& (accessDefinition.getMethod().equals("*") || method.equals(accessDefinition.getMethod()))) {
				logger.debug(String.format("URI [%s] with HTTP method [%s] is secured because of definition: %s", path, method,
						accessDefinition.getLocation()));
				if ((current == null) || (accessDefinition.getPath().length() > current.getPath().length())) {
					current = accessDefinition;
					accessDefinitions.clear();
					accessDefinitions.add(accessDefinition);
				} else if (accessDefinition.getPath().length() == current.getPath().length()) {
					accessDefinitions.add(accessDefinition);
				}
			}
		}
		if (accessDefinitions.isEmpty()) {
			logger.trace(String.format("URI [%s] with HTTP method [%s] is NOT secured", path, method));
		}
		return accessDefinitions;
	}

}
