/*
 * Copyright 2015 the original author or authors.
 */
package com.rte.collector.entity;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author zoheir Boutaleb
 */
public class OffreFieldSetMapper implements FieldSetMapper<Offre> {

	@Override
	public Offre mapFieldSet(FieldSet fieldSet) throws BindException {
		return new Offre(fieldSet.readLong("id"),
				fieldSet.readString("referenceOffre"),
				fieldSet.readString("eda"),
				fieldSet.readDate("heureDebut", "yyyy-MM-dd HH:mm:ss"));
	}
}
