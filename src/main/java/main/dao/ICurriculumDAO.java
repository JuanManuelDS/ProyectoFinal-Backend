package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Curriculum;

public interface ICurriculumDAO extends JpaRepository<Curriculum, Long>{

}
