package org.lavignelibrary.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.lavignelibrary.domain.Category;
import org.lavignelibrary.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {
	
	private final CategoryService categoryService;
	 
    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
 
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Category category = categoryService.get(Integer.parseInt(text));
        setValue(category);
	}

}
