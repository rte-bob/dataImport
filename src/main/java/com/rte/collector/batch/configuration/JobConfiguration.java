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
package com.rte.collector.batch.configuration;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import com.rte.collector.batch.processor.OffreItemProcessor;
import com.rte.collector.batch.processor.validator.OffreValidator;
import com.rte.collector.batch.reader.XmlReader;
import com.rte.collector.entity.Offre;
import com.rte.collector.entity.OffreSpeciale;

import com.rte.collector.repository.OffreSpecialRepository;

import com.rte.collector.listener.JobListener;

import com.rte.collector.listener.ChunkListener;




/**
 * @author zoheir Boutaleb 
 */
@Configuration

public class JobConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;
	
	@Autowired
	private OffreSpecialRepository offreSpecialRepository;

	
	
	@Bean
	public ItemWriter<Offre> offreItemWriter() {
		return items -> {
			//please add the logic to insert the data in the database.
					
			for (Offre item : items) {
				
				OffreSpeciale newOffre = null;
				
				OffreSpeciale xmlOffre = new OffreSpeciale();
				
				xmlOffre.setEda(item.getEda());
				xmlOffre.setActeur(item.getReferenceOffre());
				
				
				try {
					newOffre = offreSpecialRepository.save(xmlOffre);
					
				}catch (Exception e) {
					System.out.println("Exception occur");
				}
				
				//System.out.println(item.toString());

			}
		};
	}

	@Bean 
	public OffreItemProcessor processor() {
		
		return new OffreItemProcessor();
	}
	
	@Bean
	public ValidatingItemProcessor<Offre> itemProcessor() {
		ValidatingItemProcessor<Offre> customerValidatingItemProcessor =
				new ValidatingItemProcessor<>(new OffreValidator());

		customerValidatingItemProcessor.setFilter(true);

		return customerValidatingItemProcessor;
	}

	@Bean
	public Step step1() {
		System.out.println("Execution Job1");
		XmlReader xmlReder= new XmlReader();
		return stepBuilderFactory.get("step1")
				.<Offre, Offre>chunk(100)
				.listener(new ChunkListener())
				.reader(xmlReder.offreItemReader())
				.processor(itemProcessor())
				.writer(offreItemWriter())
				.build();
	}

	@Bean (name= "Job XML")
	public Job job(JavaMailSender javaMailSender) {
		return jobBuilderFactory.get("Job XML")
				.start(step1())
				.listener(new JobListener(javaMailSender))
				.build();
	}
}
