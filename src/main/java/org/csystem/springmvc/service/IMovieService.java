package org.csystem.springmvc.service;

import org.csystem.service.IService;
import org.csystem.springmvc.entity.Movie;

public interface IMovieService extends IService<Movie, Long> {
    Iterable<Movie> findByName(String name);
    Iterable<Movie> findByYear(int year);
    Iterable<Movie> findByYears(int start, int end);
    Iterable<Movie> findByDirector(String director);
}
