package ru.makarov.pipelinesAZ.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.makarov.pipelinesAZ.model.Pipeline;
import ru.makarov.pipelinesAZ.repositories.PipelinesRepository;


@Service
@Transactional(readOnly = true)
public class PipelinesService {
	
	
	private final PipelinesRepository pipelinesRepository;
	
	@Autowired
	public PipelinesService(PipelinesRepository pipelinesRepository) {
		this.pipelinesRepository = pipelinesRepository;
	}
	
	public List <Pipeline> findAll(){
		return pipelinesRepository.findAll();
		}

}
