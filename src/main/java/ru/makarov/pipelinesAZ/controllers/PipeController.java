package ru.makarov.pipelinesAZ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	
	
	
	
}
