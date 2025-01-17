/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: 2022 SAP SE or an SAP affiliate company and Eclipse Dirigible contributors
 * SPDX-License-Identifier: EPL-2.0
 */
let extensions = require('core/v4/extensions');

exports.getMenu = function () {
	let menu = {
		label: "Window",
		order: 2,
		items: [
			{
				label: "Open Perspective",
				order: 1,
				items: [],
			},
			{
				label: "Show View",
				order: 2,
				items: [],
			},
		]
	};

	let perspectiveExtensions = extensions.getExtensions('ide-perspective');
	let perspectiveExtensionDefinitions = [];

	for (let i = 0; i < perspectiveExtensions.length; i++) {
		let module = perspectiveExtensions[i];
		perspectiveExtensionDefinitions.push(require(module).getPerspective());
	}

	perspectiveExtensionDefinitions = perspectiveExtensionDefinitions.sort((a, b) => a.name.toLowerCase().localeCompare(b.name.toLowerCase()));
	for (let i = 0; i < perspectiveExtensionDefinitions.length; i++) {
		let perspectiveInfo = perspectiveExtensionDefinitions[i];
		menu.items[0].items.push({
			id: perspectiveInfo.id,
			label: perspectiveInfo.name,
			order: i,
			link: perspectiveInfo.link,
			action: 'openPerspective',
		});
	}

	let viewExtensions = extensions.getExtensions('ide-view');
	let viewExtensionDefinitions = [];
	for (let i = 0; i < viewExtensions.length; i++) {
		let module = viewExtensions[i];
		viewExtensionDefinitions.push(require(module).getView());
	}
	viewExtensionDefinitions = viewExtensionDefinitions.sort((a, b) => a.label.toLowerCase().localeCompare(b.label.toLowerCase()));

	for (let i = 0; i < viewExtensionDefinitions.length; i++) {
		let viewInfo = viewExtensionDefinitions[i];
		menu.items[1].items.push({
			id: viewInfo.id,
			label: viewInfo.label,
			order: i,
			action: 'openView',
		});
	}

	return menu;
}