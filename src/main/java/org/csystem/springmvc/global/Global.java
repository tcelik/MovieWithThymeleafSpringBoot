package org.csystem.springmvc.global;

public class Global {
    private Global() {}

    //Thymeleaf html ile çalışır
    public static final String RESULT_VIEW = "result"; // resource/templates/result.html
    public static final String MOVIE_VIEW = "movie";   // resource/templates/movie.html
    public static final String LIST_VIEW = "movies/list";   // resource/templates/movie.html, template'in altında movies altında list.html diye bir sayfa olsun demek

}
