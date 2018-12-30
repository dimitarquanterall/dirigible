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
package org.eclipse.dirigible.runtime.ide.generation.model.template;

import java.util.List;

/**
 * The Generation Template Metadata serialization object.
 */
public class GenerationTemplateMetadata {
	
	private String id;
	
	private String name;
	
	private String description;
	
	private boolean model;
	
	private List<GenerationTemplateMetadataSource> sources;
	
	private List<GenerationTemplateMetadataParameter> parameters;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Getter for the model flag
	 * 
	 * @return true if it is model based
	 */
	public boolean isModel() {
		return model;
	}
	
	/**
	 * Sets the model flag
	 * 
	 * @param model the flag
	 */
	public void setModel(boolean model) {
		this.model = model;
	}

	/**
	 * Gets the sources.
	 *
	 * @return the sources
	 */
	public List<GenerationTemplateMetadataSource> getSources() {
		return sources;
	}

	/**
	 * Sets the sources.
	 *
	 * @param sources the new sources
	 */
	public void setSources(List<GenerationTemplateMetadataSource> sources) {
		this.sources = sources;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public List<GenerationTemplateMetadataParameter> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters the new parameters
	 */
	public void setParameters(List<GenerationTemplateMetadataParameter> parameters) {
		this.parameters = parameters;
	}

}
