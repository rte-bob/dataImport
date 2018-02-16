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
package com.rte.collector.entity;

import java.util.Date;

/**
 * @author wbenmbarek
 */
public class Offre {

	private final long id;

	private final String referenceOffre;

	private final String eda;

	private final Date heureDebut;

	public Offre(long id, String referenceOffre, String eda, Date heureDebut) {
		this.id = id;
		this.referenceOffre = referenceOffre;
		this.eda = eda;
		this.heureDebut = heureDebut;
	}

	public long getId() {
		return id;
	}

	

	public String getReferenceOffre() {
		return referenceOffre;
	}

	public String getEda() {
		return eda;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	@Override
	public String toString() {
		return "Offre{" +
				"id=" + id +
				", referenceOffre='" + referenceOffre + '\'' +
				", eda='" + eda + '\'' +
				", heureDebut=" + heureDebut +
				'}';
	}
}
