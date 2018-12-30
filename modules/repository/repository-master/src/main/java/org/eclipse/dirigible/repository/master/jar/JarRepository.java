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
package org.eclipse.dirigible.repository.master.jar;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.dirigible.repository.api.IRepository;
import org.eclipse.dirigible.repository.local.LocalRepositoryException;
import org.eclipse.dirigible.repository.master.zip.ZipRepository;

/**
 * The Jar Repository.
 */
public class JarRepository extends ZipRepository {

	private String jarRepositoryRootFolder;

	/**
	 * Instantiates a new jar repository.
	 *
	 * @param zip
	 *            the zip
	 * @throws LocalRepositoryException
	 *             the local repository exception
	 * @throws IOException 
	 */
	public JarRepository(String zip) throws LocalRepositoryException, IOException {

		InputStream in = JarRepository.class.getClassLoader().getSystemResourceAsStream(zip);
		try {
			if (in == null) {
				in = JarRepository.class.getClassLoader().getParent().getResourceAsStream(zip);
			}
			if (in == null) {
				in = JarRepository.class.getResourceAsStream(zip);
			}
			if (in != null) {
				try {
					Path rootFolder = Files.createTempDirectory("jar_repository");
					unpackZip(in, rootFolder.toString());
					String zipFileName = zip.substring(zip.lastIndexOf(IRepository.SEPARATOR) + 1);
					jarRepositoryRootFolder = zipFileName.substring(0, zipFileName.lastIndexOf("."));
					createRepository(rootFolder.toString(), true);
				} catch (IOException e) {
					throw new LocalRepositoryException(e);
				}
			} else {
				throw new LocalRepositoryException(
						String.format("Zip file containing Repository content does not exist at path: %s", zip));
			} 
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * Instantiates a new jar repository.
	 *
	 * @param rootFolder
	 *            the root folder
	 * @param absolute
	 *            the absolute
	 * @throws LocalRepositoryException
	 *             the local repository exception
	 */
	// disable usage
	protected JarRepository(String rootFolder, boolean absolute) throws LocalRepositoryException {
		super(rootFolder, absolute);
	}

	/**
	 * Instantiates a new jar repository.
	 *
	 * @throws LocalRepositoryException
	 *             the local repository exception
	 */
	// disable usage
	protected JarRepository() throws LocalRepositoryException {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.dirigible.repository.master.zip.ZipRepository#getRepositoryRootFolder()
	 */
	@Override
	protected String getRepositoryRootFolder() {
		return this.jarRepositoryRootFolder;
	}
}
