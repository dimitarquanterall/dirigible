/*
 * Copyright (c) 2010-2020 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   SAP - initial API and implementation
 */

/**
 * API v4 Producer
 *
 * Note: This module is supported only with the Mozilla Rhino engine
 */

exports.queue = function(destination) {
	const queue = new Queue();
	queue.destination = destination;
	return queue;
};

exports.topic = function(destination) {
	const topic = new Topic();
	topic.destination = destination;
	return topic;
};

function Queue() {
	this.send = function(message) {
		org.eclipse.dirigible.api.v3.messaging.MessagingFacade.sendToQueue(this.destination, message);
	};
}

function Topic() {
	this.send = function(message) {
		org.eclipse.dirigible.api.v3.messaging.MessagingFacade.sendToTopic(this.destination, message);
	};
}
