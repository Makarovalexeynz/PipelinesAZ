package ru.makarov.pipelinesAZ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.makarov.pipelinesAZ.services.PipelinesService;



@Controller
@RequestMapping("/pipelines")
public class PipelineController {
	
	private final PipelinesService pipelinesService;
	
	@Autowired
	public PipelineController(PipelinesService pipelinesService) {
		this.pipelinesService = pipelinesService;
	}

	@GetMapping()
	 public String index(Model model) {                       
        model.addAttribute("pipelines", pipelinesService.findAll());
        return "pipelines/index";
    }

}
