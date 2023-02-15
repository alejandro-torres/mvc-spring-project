package alejandro.torres.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import alejandro.torres.entity.Film;
import alejandro.torres.entity.Genre;
import alejandro.torres.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {
	
	@Autowired
	FilmService filmService;
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/genre/save")
	public String saveGenre(Model model, Genre genre)
	{
		filmService.saveGenre(genre);
		model.addAttribute("listOfGenres", filmService.readAllGenres());
		return "genres";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/genre")
	public String goGenres(Model model)
	{
		model.addAttribute("listOfGenres", filmService.readAllGenres());
		return "genres";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/genre/delete/{id}")
	public String deleteGenre(@PathVariable("id")Integer id, Model model)
	{
		filmService.deleteGenreById(id);
		model.addAttribute("listOfGenres", filmService.readAllGenres());
		return "genres";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/new")
	public String newFilm(Model model)
	{
		model.addAttribute("listOfGenres", filmService.readAllGenres());
		return "new-film";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/save")
	public String saveFilm(Film film, BindingResult result, @RequestParam("cover") MultipartFile cover, Model model)
	{
		if (!cover.isEmpty()) {

			Path directorioRecursos = Paths.get("src/main/resources/static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();

			try {

				byte[] bytes = cover.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + cover.getOriginalFilename());
				Files.write(rutaCompleta, bytes);

				film.setCover(cover.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(film.getCover() == null && film.getId() != null) {
			film.setCover((filmService.readFilmById(film.getId())).getCover());
		}
		
		filmService.saveFilm(film);
		model.addAttribute("listOfFilms", filmService.readAllFilms());
		return "redirect:/film/list";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/list")
	public String goAllFilms(Model model)
	{
		model.addAttribute("listOfFilms", filmService.readAllFilms());
		return "films";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/update/{id}")
	public String updateFilm(@PathVariable("id") Integer id, Model model)
	{
		model.addAttribute("film", filmService.readFilmById(id));
		model.addAttribute("listOfGenres", filmService.readAllGenres());
		return "new-film";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/delete/{id}")
	public String deleteFilm(@PathVariable("id") Integer id, Model model)
	{
		filmService.deleteFilmById(id);
		return "redirect:/film/list";
	}
	
	
}
