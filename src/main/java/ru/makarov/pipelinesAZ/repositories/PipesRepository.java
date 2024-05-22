package ru.makarov.pipelinesAZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.makarov.pipelinesAZ.model.Pipe;


@Repository
public interface PipesRepository extends JpaRepository<Pipe, Integer> {

}
