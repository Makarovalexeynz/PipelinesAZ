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
import ru.makarov.pipelinesAZ.model.Pipeline;
import ru.makarov.pipelinesAZ.services.PipelinesService;
import ru.makarov.pipelinesAZ.services.PipesService;



@Controller
@RequestMapping("/pipelines")
public class PipelineController {
	
	private final PipelinesService pipelinesService;
	private final PipesService pipesService;
	
	@Autowired
	public PipelineController(PipelinesService pipelinesService, PipesService pipesService ) {
		this.pipelinesService = pipelinesService;
		this.pipesService = pipesService;
	}

	@GetMapping()
	 public String index(Model model) {                       
        model.addAttribute("pipelines", pipelinesService.findAll());
        return "pipelines/index";
    }
	
	  @GetMapping("/{id}")
	    public String show(@PathVariable("id") int id, Model model) {
	        model.addAttribute("pipeline", pipelinesService.findOne(id));
	        return "pipelines/showpipeline";
	    }
	  
	  @GetMapping("/new")
		public String newPipe(@ModelAttribute("pipeline") Pipeline pipeline) {
			
			return "pipelines/new";
		}
	  
	  @PostMapping()
		public String create(@ModelAttribute("pipeline") Pipeline pipeline ) {
			pipelinesService.save(pipeline);
			return "redirect:/pipelines";
			}
	  
	  @GetMapping("/{id}/edit")        // возвращает html страницу для редактирования 
		public String edit(Model model, @PathVariable("id") int id) {
			model.addAttribute("pipeline", pipelinesService.findOne(id));
			return "pipelines/edit";
		}
		
		@PatchMapping("/{id}")
	    public String update(@ModelAttribute("pipeline") Pipeline pipeline, 
	    					@PathVariable("id") int id) {

		   pipelinesService.update(id, pipeline);
	        return "redirect:/pipelines";
	    }
		
		@DeleteMapping("/{id}")
		public String delete(@PathVariable("id") int id) {
			pipelinesService.delete(id);
			return "redirect:/pipelines";
		}
		
		@GetMapping("/{id}/pipes")                         // возвращает трубы входящие в систему трубопровода
		 public String showpipes(@PathVariable("id") int id,  Model model, @ModelAttribute("pipeline") Pipeline pipeline) {                       
	       model.addAttribute("pipes", pipesService.findAllByOwner(pipeline));
	       return "pipelines/showpipeinsystem";
	   }

}
