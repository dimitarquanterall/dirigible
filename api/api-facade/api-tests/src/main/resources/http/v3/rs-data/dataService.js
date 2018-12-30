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
const DataService  = require('http/rs-data').DataService;
var MyDAO = function(){};
MyDAO.prototype.list = function(){
    return [{id:1, text:'b'}];
};
MyDAO.prototype.count = function(){
    return this.list().length;
};
var svc = new DataService(new MyDAO());
svc.service();