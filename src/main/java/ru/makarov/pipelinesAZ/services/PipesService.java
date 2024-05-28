package ru.makarov.pipelinesAZ.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.makarov.pipelinesAZ.model.Pipe;
import ru.makarov.pipelinesAZ.model.Pipeline;
import ru.makarov.pipelinesAZ.repositories.PipesRepository;




@Service
@Transactional(readOnly = true)
public class PipesService {
	
	private final PipesRepository pipesRepository;
	
	@Autowired
	public PipesService(PipesRepository pipesRepository) {
		this.pipesRepository = pipesRepository;
	}
	
	public List <Pipe> findAll(){
		return pipesRepository.findAll();
	}
	public Pipe findOne(int id) {
        Optional<Pipe> foundPipe = pipesRepository.findById(id);
        return foundPipe.orElse(null);
    }
	
	@Transactional
    public void save(Pipe pipe) {
        pipesRepository.save(pipe);
    }
	
	@Transactional
    public void update(int id, Pipe updatedPipe) {
        updatedPipe.setId(id);
        pipesRepository.save(updatedPipe);
    }
	
	@Transactional
    public void delete(int id) {
        pipesRepository.deleteById(id);
    }
	
	@Transactional
	public void link(int id, Pipeline selectedPipeline) {
		pipesRepository.findById(id).ifPresent(
				pipe -> {
                    pipe.setOwner(selectedPipeline);
				}
		);
	}

}
