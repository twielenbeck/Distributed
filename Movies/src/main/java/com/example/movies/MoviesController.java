package com.example.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @RequestMapping("/movies")
    public List<Movies> getThanks() {
        return moviesService.getAllMovies();
    }
    @RequestMapping("/movies/{id}")
    public Movies getTeam(@PathVariable String id) {
        return moviesService.getMovies(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/movies")
    public void addMovies(@RequestBody Movies movies) {
        moviesService.addMovies(movies);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/movies/{id}")
    public void updateMovies(@RequestBody Movies movies, @PathVariable String id) {
        moviesService.updateMovies(movies, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
    public void deleteMovies(@PathVariable String id) {
        moviesService.deleteMovies(id);
    }
}
