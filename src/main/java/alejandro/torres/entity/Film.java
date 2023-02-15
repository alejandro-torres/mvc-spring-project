package alejandro.torres.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "synopsis")
	private String synopsis;
	
	@Column(name = "first_release")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date firstRelease;
	
	@Column(name = "trailer")
	private String trailer;
	
	@Column(name = "cover")
	private String cover;
	
	@OneToOne
	@JoinColumn(name = "fk_genre")
	private Genre genre;
	

	public Film() {
	}

	public Film(Integer id, String title, String synopsis, Date firstRelease, String trailer, String cover,
			Genre genre) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.firstRelease = firstRelease;
		this.trailer = trailer;
		this.cover = cover;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getFirstRelease() {
		return firstRelease;
	}

	public void setFirstRelease(Date firstRelease) {
		this.firstRelease = firstRelease;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
