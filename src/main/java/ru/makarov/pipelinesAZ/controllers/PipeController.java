package ru.makarov.pipelinesAZ.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.makarov.pipelinesAZ.model.Pipe;
import ru.makarov.pipelinesAZ.services.PipesService;





@Controller
@RequestMapping("/pipes")
public class PipeController {
	
	private final PipesService pipesService;
	

	@Autowired
	public PipeController(PipesService pipesService) {
		this.pipesService = pipesService;
	}

	@GetMapping()
	 public String index(Model model) {                       
        model.addAttribute("pipes", pipesService.findAll());
        return "pipes/index";
    }
	
	  @GetMapping("/{id}")
	    public String show(@PathVariable("id") int id, Model model) {
	        model.addAttribute("pipe", pipesService.findOne(id));
	        return "pipes/showPipe";
	    }
	
	@GetMapping("/getPipe")
	public String getPipe(){
		return "FirstPipe";
	}
	
	@GetMapping("/new")
	public String newPipe(@ModelAttribute("pipe") Pipe pipe) {
		
		return "pipes/new";
	}
	
	
	@PostMapping()
	public String create(@ModelAttribute("pipe") Pipe pipe ) {
		pipesService.save(pipe);
		return "redirect:/pipes";
		
	}
	
	@GetMapping("/{id}/edit")        // возвращает html страницу для редактирования 
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("pipe", pipesService.findOne(id));
		return "pipes/edit";
	}
	
	@PatchMapping("/{id}")
    public String update(@ModelAttribute("pipe") Pipe pipe, 
    					@PathVariable("id") int id) {

	   pipesService.update(id, pipe);
        return "redirect:/pipes";
    }
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		pipesService.delete(id);
		return "redirect:/pipes";
	}
	
	
	
	
	
}
