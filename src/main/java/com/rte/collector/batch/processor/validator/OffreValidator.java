package com.rte.collector.batch.processor.validator;



import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

import com.rte.collector.entity.Offre;


public class OffreValidator implements Validator<Offre> {
	public static int processed;

	@Override
	public void validate(Offre offre) throws ValidationException {
	

		if(offre.getEda().equals("")){
			throw new ValidationException("Eda est null " + offre);          
        } else if (offre.getReferenceOffre().equals("")) {
        	throw new ValidationException("reference offre null " + offre);

        }else {
        	OffreValidator.incProcessed();
    		System.out.println("Offre Processing n° "+processed+" : nom : "+offre.getEda()+" "+offre.getReferenceOffre());
        }
	}
	
	private static void incProcessed() {
		++processed;
	}
    
}