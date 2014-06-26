package org.lavignelibrary.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.lavignelibrary.domain.Occupation;
import org.lavignelibrary.service.OccupationService;

public class OccupationEditor extends PropertyEditorSupport {
	
	private final OccupationService occupationService;
	 
    public OccupationEditor(OccupationService occupationService) {
        this.occupationService = occupationService;
    }
 
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Occupation occupation = occupationService.get(Integer.parseInt(text));
        setValue(occupation);
	}

}
