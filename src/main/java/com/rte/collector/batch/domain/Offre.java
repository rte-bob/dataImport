/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rte.collector.batch.domain;

import java.util.Date;

/**
 * @author wbenmbarek
 */
public class Offre {

	private final long id;

	private final String reference_offre;

	private final String eda;

	private final Date heure_debut;

	public Offre(long id, String reference_offre, String eda, Date heureDebut) {
		this.id = id;
		this.reference_offre = reference_offre;
		this.eda = eda;
		this.heure_debut = heureDebut;
	}

	public long getId() {
		return id;
	}

	

	public String getReference_offre() {
		return reference_offre;
	}

	public String getEda() {
		return eda;
	}

	public Date getHeure_debut() {
		return heure_debut;
	}

	@Override
	public String toString() {
		return "Offre{" +
				"id=" + id +
				", reference_offre='" + reference_offre + '\'' +
				", eda='" + eda + '\'' +
				", heure_debut=" + heure_debut +
				'}';
	}
}
