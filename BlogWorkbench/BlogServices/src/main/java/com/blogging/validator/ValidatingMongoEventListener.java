package com.blogging.validator;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.mongodb.DBObject;

public class ValidatingMongoEventListener extends AbstractMongoEventListener<Object> {
	
	public static final Logger LOG = LogManager.getLogger(ValidatingMongoEventListener.class);

	private Validator validator;

	@Override
	public void onBeforeSave(Object source, DBObject dbo) {
		Set<ConstraintViolation<Object>> violations = validator.validate(source);

		if (violations.size() > 0) {
			 LOG.info("During object: {} validation violations found: {}", source, violations);
			throw new ConstraintViolationException(violations);
		}
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}