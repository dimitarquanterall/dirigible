/*
 * Copyright (c) 2010-2018 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */
exports.getTemplate = function() {
	return {
		"name": "HTTP Client",
		"description": "HTTP Client Template",
		"sources": [{
			"location": "/template-http-client/service.js.template", 
			"action": "generate",
			"rename": "{{fileName}}.js"
		}],
		"parameters": []
	};
};
