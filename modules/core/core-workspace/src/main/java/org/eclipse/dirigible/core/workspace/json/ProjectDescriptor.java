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
package org.eclipse.dirigible.core.workspace.json;

import java.util.ArrayList;
import java.util.List;

/**
 * The ProjectDescriptor transport object.
 */
public class ProjectDescriptor {

	private String name;

	private String path;

	private String type = "project";

	private List<FolderDescriptor> folders = new ArrayList<FolderDescriptor>();

	private List<FileDescriptor> files = new ArrayList<FileDescriptor>();

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path
	 *            the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the folders.
	 *
	 * @return the folders
	 */
	public List<FolderDescriptor> getFolders() {
		return folders;
	}

	/**
	 * Sets the.
	 *
	 * @param folders
	 *            the folders
	 */
	public void set(List<FolderDescriptor> folders) {
		this.folders = folders;
	}

	/**
	 * Gets the files.
	 *
	 * @return the files
	 */
	public List<FileDescriptor> getFiles() {
		return files;
	}

	/**
	 * Sets the files.
	 *
	 * @param files
	 *            the new files
	 */
	public void setFiles(List<FileDescriptor> files) {
		this.files = files;
	}

}
