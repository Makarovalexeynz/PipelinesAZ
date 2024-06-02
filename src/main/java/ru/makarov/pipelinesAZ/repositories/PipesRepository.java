package ru.makarov.pipelinesAZ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.makarov.pipelinesAZ.model.Pipe;
import ru.makarov.pipelinesAZ.model.Pipeline;


@Repository
public interface PipesRepository extends JpaRepository<Pipe, Integer> {
	
	List <Pipe> findAllByOwner(Pipeline pipeline);

}
