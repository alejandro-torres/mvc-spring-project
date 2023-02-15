package alejandro.torres.service;

import java.util.ArrayList;

import alejandro.torres.entity.Film;
import alejandro.torres.entity.Genre;

public interface FilmService {

	public Genre saveGenre(Genre genre);
	public boolean deleteGenreById(Integer id);
	public Genre readGenreById(Integer id);
	public ArrayList<Genre> readAllGenres();
	
	public Film saveFilm(Film film);
	public boolean deleteFilmById(Integer id);
	public Film readFilmById(Integer id);
	public ArrayList<Film> readAllFilms();
}
