package ru.makarov.pipelinesAZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.makarov.pipelinesAZ.model.Pipeline;

@Repository
public interface PipelinesRepository extends JpaRepository<Pipeline, Integer> {

}
