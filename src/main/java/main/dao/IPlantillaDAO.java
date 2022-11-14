package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Plantilla;

public interface IPlantillaDAO extends JpaRepository<Plantilla, Long>{

}
