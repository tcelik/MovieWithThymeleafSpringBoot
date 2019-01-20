package org.csystem.springmvc.service;

import org.csystem.springmvc.entity.Movie;
import org.csystem.springmvc.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private IMovieRepository m_movieRepository;

    public MovieService(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> findAll()
    {
        return m_movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id)
    {
        return Optional.ofNullable(null);
    }

    @Override
    public Iterable<Movie> findByName(String name)
    {
        return m_movieRepository.findByName(name);
    }

    @Override
    public Iterable<Movie> findByDirector(String director)
    {
        return m_movieRepository.findByDirector(director);
    }

    @Override
    public Iterable<Movie> findByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }

    @Override
    public Iterable<Movie> findByYears(int start, int end)
    {
        return m_movieRepository.findByYears(start, end);
    }

    @Override
    public <E extends Movie> E save(E e)
    {
        m_movieRepository.save(e);

        return e;
    }


}
