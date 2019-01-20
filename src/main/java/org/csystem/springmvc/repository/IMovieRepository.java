package org.csystem.springmvc.repository;

import org.csystem.springmvc.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
    @Query("SELECT m from Movie m WHERE m.m_name like ?1%")
    Iterable<Movie> findByName(String name);

    //:parametre ismi ile parametrelere sorgular içerisinde de ulaşılabilir
    @Query(value = "SELECT * from movies m where date_part('year', date)=:year", nativeQuery = true)
    Iterable<Movie> findByYear(int year);

    @Query(value = "SELECT * from movies m where date_part('year', date) between :start and :end", nativeQuery = true)
    Iterable<Movie> findByYears(int start, int end);

    @Query("SELECT m from Movie m WHERE m.m_director like ?1%")
    Iterable<Movie> findByDirector(String director);
}
