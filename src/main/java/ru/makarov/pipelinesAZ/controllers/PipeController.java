package ru.makarov.pipelinesAZ.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ru.makarov.pipelinesAZ.model.Pipe;
import ru.makarov.pipelinesAZ.model.Pipeline;
import ru.makarov.pipelinesAZ.services.PipelinesService;
import ru.makarov.pipelinesAZ.services.PipesService;


@Controller
@RequestMapping("/pipes")
public class PipeController {
	
	private final PipesService pipesService;
	private final PipelinesService pipelinesService;
	

	@Autowired
	public PipeController(PipesService pipesService, PipelinesService pipelinesService ) {
		this.pipesService = pipesService;
		this.pipelinesService = pipelinesService;
	}
	
	

	@GetMapping()
	 public String index(Model model) {                       
        model.addAttribute("pipes", pipesService.findAll());
        return "pipes/index";
    }
	
	  @GetMapping("/{id}")
	    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("pipeline") Pipeline pipeline ) {
	        model.addAttribute("pipe", pipesService.findOne(id));
	        model.addAttribute("pipelines", pipelinesService.findAll());
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
	public String create(@ModelAttribute("pipe") @Valid Pipe pipe, BindingResult bd) {
		if(bd.hasErrors()) return "pipes/new";
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
	
	
	
	
	@PatchMapping("/{id}/linkpipelines")
    public String makeLink(@PathVariable("id") int id, @ModelAttribute("pipeline") Pipeline selectedPipeline) {
		pipesService.link(id, selectedPipeline);

        return "redirect:/pipes";
    }
	
	
	
	
	
	
	
}
