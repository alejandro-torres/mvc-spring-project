package alejandro.torres.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alejandro.torres.entity.Film;
import alejandro.torres.entity.Genre;
import alejandro.torres.repository.FilmRepository;
import alejandro.torres.repository.GenreRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public Genre saveGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public boolean deleteGenreById(Integer id) {
		try {
			genreRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Genre readGenreById(Integer id) {
		return genreRepository.getById(id);
	}

	@Override
	public Film saveFilm(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public boolean deleteFilmById(Integer id) {
		try {
			
			filmRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Film readFilmById(Integer id) {
		return filmRepository.getById(id);
	}

	@Override
	public ArrayList<Genre> readAllGenres() {
		return (ArrayList<Genre>) genreRepository.findAll();
	}

	@Override
	public ArrayList<Film> readAllFilms() {
		return (ArrayList<Film>)filmRepository.findAll();
	}

	

}
