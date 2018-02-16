package com.rte.collector.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.rte.collector.entity.Offre;


public class OffreItemProcessor implements ItemProcessor <Offre,Offre>{
private static int processed;
	@Override
	public Offre process(Offre item) throws Exception {
		
		OffreItemProcessor.incProcessed();
		System.out.println("Offre Processing n° "+processed+" : nom : "+item.getEda()+" "+item.getReferenceOffre());
		
		return item;
	}
	private static void incProcessed() {
		++processed;
	}

}
