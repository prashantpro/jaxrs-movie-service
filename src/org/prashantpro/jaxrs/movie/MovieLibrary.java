package org.prashantpro.jaxrs.movie;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Prashant Padmanabhan <http://javaspecialist.wordpress.com>
 *
 */
@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
public class MovieLibrary {
	//Store the in memory movie list as our repository.
	static final List<Movie> MOVIE_LIST = new ArrayList<Movie>();
	
	//Build a dummy list of movies to work with.
	static {
		MOVIE_LIST.add(new Movie(1971,"Dirty Harry","Action"));
		MOVIE_LIST.add(new Movie(2008,"Gran Torino","Drama"));
		MOVIE_LIST.add(new Movie(2012,"Argo","Drama"));
	}
	
	@GET
	@Path("/{year}")
	public Response getMovies(@PathParam("year") int year) {
		if(year < 1880 || year > 9999) {
			//Invalid input for year so return HTTP Status 400
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		List<Movie> list = getMoviesByYear(year);
		return Response.status(Response.Status.OK).entity(list).build();
	}
	
	@GET
	@Path("/list")
	public Response getMoviesByGenre(@QueryParam("order") String order,@QueryParam("genre") String genre) throws BusinessException {
		List<String> errorMessages = new ArrayList<String>();
		
		if(order == null || order.length() == 0) {
			errorMessages.add("order is required");
		}
		
		if(genre == null || genre.length() == 0) {
			errorMessages.add("genre is required");
		}
		
		if(!"ASC".equals(order) && !"DESC".equals(order)) {
			errorMessages.add("order of either ASC or DESC must be specified");
		}
		
		if(!"Action".equals(genre) &&  !"Drama".equals(genre)) {
			errorMessages.add("genre of either Action or Drama must be specified");
		}
		if(!errorMessages.isEmpty()) {
			throw new BusinessException(errorMessages);
		}
		
		List<Movie> list = listMoviesByGenre(genre,order);
		return Response.status(Response.Status.OK).entity(list).build();
	}

	private List<Movie> listMoviesByGenre(String genre, String order) {		
		//Just return the list as is as this is a demo
		//We would use some logic to do the filtering and ordering in real world apps.
		return MOVIE_LIST;
	}

	private List<Movie> getMoviesByYear(int targetYear) {
		List<Movie> found = new ArrayList<Movie>();
		for(Movie movie : MOVIE_LIST) {
			if(movie.getYear() == targetYear)
				found.add(movie);
		}
		return found;
	}

}
