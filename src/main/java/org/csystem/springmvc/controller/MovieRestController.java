package org.csystem.springmvc.controller;


import org.csystem.springmvc.entity.Movie;
import org.csystem.springmvc.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
    private final IMovieService m_movieService;

    public MovieRestController(IMovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping
    public Iterable<Movie> getMovies()
    {
        return m_movieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") long id)
    {
        var movieOptional = m_movieService.findById(id);

        //return movieOptional.isPresent() ? ResponseEntity.ok(movieOptional.get()) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //return movieOptional.isPresent() ? ResponseEntity.ok(movieOptional.get()) : ResponseEntity.notFound().build();
        return ResponseEntity.of(movieOptional);
    }

    @GetMapping("/contains/{name}")
    public Iterable<Movie> getMoviesByName(@PathVariable("name") String name)
    {
        return m_movieService.findByName(name);
    }

    @GetMapping("/directors/{director}")
    public Iterable<Movie> getMoviesByDirector(@PathVariable("director") String director)
    {
        return m_movieService.findByDirector(director);
    }

    @GetMapping("/year")
    public Iterable<Movie> getMoviesByYear(@RequestParam(name="year") int year)
    {
        return m_movieService.findByYear(year);
    }

    @GetMapping("/years")
    public Iterable<Movie> getMoviesByYears(@RequestParam(name="start") int start, @RequestParam(name="end") int end)
    {
        return m_movieService.findByYears(start, end);
    }

    @PostMapping
    public Movie saveMovie1(@RequestBody Movie movie)
    {
        m_movieService.save(movie);

        return movie;
    }

    @PostMapping("/savegetlist")
    public Iterable<Movie> saveMovie2(@RequestBody Movie movie)
    {
        m_movieService.save(movie);

        return getMovies();
    }

    @PostMapping("/savegeturi")
    public Movie saveMovie3(@RequestBody Movie movie, UriComponentsBuilder uriComponentsBuilder)
    {
        m_movieService.save(movie);

        URI uri = uriComponentsBuilder.path("/movies/{id}").build(movie.getId());

        return ResponseEntity.created(uri).body(movie).getBody();
    }
}
