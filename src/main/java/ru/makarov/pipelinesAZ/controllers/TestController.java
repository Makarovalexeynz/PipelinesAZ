package ru.makarov.pipelinesAZ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.makarov.pipelinesAZ.model.Pipeline;
import ru.makarov.pipelinesAZ.services.PipelinesService;



@Controller
@RequestMapping("/test")
public class TestController {
	
	private final PipelinesService pipelinesService;
	
	@Autowired
	public TestController(PipelinesService pipelinesService) {
		this.pipelinesService = pipelinesService;
	}
	
	@GetMapping()
	public String pipelinePage(Model model, @ModelAttribute("pipeline") Pipeline pipeline) {
		model.addAttribute("pipelines", pipelinesService.findAll());
		
		return "FirstPipe";
		
	}
	
	@PatchMapping("/add")
    public String makeLink(@ModelAttribute("pipeline") Pipeline pipeline) {
        System.out.println(pipeline.getId());

        return "redirect:/pipelines";
    }

}
