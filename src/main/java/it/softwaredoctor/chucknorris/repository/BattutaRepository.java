package it.softwaredoctor.chucknorris.repository;

import java.util.List;

import it.softwaredoctor.chucknorris.entity.Battuta;


public interface BattutaRepository extends JpaRepository<Battuta, Integer> {

	List<Battuta> findAllOrderByDate(); 
	
	List<Battuta> findByValueoOrUpdatedAt(String term);
	
}
