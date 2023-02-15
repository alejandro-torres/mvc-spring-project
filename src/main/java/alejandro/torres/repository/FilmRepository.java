package alejandro.torres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alejandro.torres.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{

}
