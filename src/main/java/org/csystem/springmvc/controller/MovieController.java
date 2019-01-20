package org.csystem.springmvc.controller;

import org.csystem.springmvc.entity.Movie;
import org.csystem.springmvc.service.IMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static org.csystem.springmvc.global.Global.*;

@Controller
public class MovieController {
    private IMovieService m_movieService;

    public MovieController(IMovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping("/movie")
    public String movieForm(Model model)
    {
        model.addAttribute("movie", new Movie());

        return MOVIE_VIEW;
    }

    @PostMapping("/movie")
    public String movieSubmit(@ModelAttribute Movie movie)
    {
        m_movieService.save(movie);

        return MOVIE_VIEW;
    }
}
