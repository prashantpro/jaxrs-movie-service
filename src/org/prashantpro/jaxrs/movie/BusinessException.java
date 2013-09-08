package org.prashantpro.jaxrs.movie;

import java.util.List;

/**
 * @author Prashant Padmanabhan <http://javaspecialist.wordpress.com>
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private List<String> messages;

	public BusinessException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
