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
package com.rte.collector.batch.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.rte.collector.entity.Offre;



/**
 * @author wbenmbarek
 */
@Configuration
public class XmlReader {

	
	@Bean
	public StaxEventItemReader<Offre> offreItemReader() {
		System.out.println("debug====== offreItemReader");

		XStreamMarshaller unmarshaller = new XStreamMarshaller();

		Map<String, Class> aliases = new HashMap<>();
		aliases.put("offre", Offre.class);

		unmarshaller.setAliases(aliases);

		StaxEventItemReader<Offre> reader = new StaxEventItemReader<>();
		

		reader.setResource(new ClassPathResource("/data/offres.xml"));
		reader.setFragmentRootElementName("offre");
		reader.setUnmarshaller(unmarshaller);
		System.out.println("End reading from Xml");
		return reader;

	}


	
}