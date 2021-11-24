package com.thp.spring.simplecontext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.thp.spring.simplecontext.dto.CategoryDto;
import com.thp.spring.simplecontext.service.CategoryService;

//@RestController  // ======> json
@Controller // ======> jsp
@RequestMapping("/categoryManagement")
public class CategoryController {

	public CategoryController() {
	}

	@Autowired
	private CategoryService categoryService;

	/********************************************************************************************************************************/
	@RequestMapping({ "/", "/welcomePage" })
	public String home(Model model) {
		model.addAttribute("message", "Gestion Categoriiiiies");
		return "welcomePage";
	}

	/*************************************************************************************************************************************/
	@GetMapping(value = "/ListCategory")
	public String findAllCatgory(Model model) {

			List<CategoryDto> categoryDtosToView = categoryService.getListCategory();

			model.addAttribute("listCategoriiiies", categoryDtosToView);
			return "ListCategory";
		
	}

	/********************************************************************************************************************************/

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
			categoryService.deleteCategroyById(id);

			return "redirect:/categoryManagement/ListCategory";
		
	}

	/*******************************************************************************************************************************/

	@RequestMapping(value = "updateCategory/{id}/{name}/{descripton}", method = RequestMethod.GET)
	public String updateCategoryById(@PathVariable("id") Long id, @PathVariable("name") String name,
			@PathVariable("description") String description) {

			CategoryDto dto = new CategoryDto();
			dto.setDescription(description);
			dto.setName(name);
			categoryService.updateById(id, dto);
			return "redirect:/categoryManagement/ListCategory";

		

	}

	/*******************************************************************************************************/

	@PostMapping(value = "/addCategory")
	public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
			CategoryDto categoryDtoAdded = categoryService.addCategory(categoryDto);
			return categoryDtoAdded;
		

	}

	/***********************************************************************************************************/

	@GetMapping(value = "/findCategory/{id}")
	public CategoryDto findCategoryById(@PathVariable Long id) {
			return categoryService.getCategoryById(id);
		
	}

}
