package com.example.movies;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MoviesService {
    private List<Movies> movies = new ArrayList<>(Arrays.asList(
            new Movies("Saturday the 14th", 2),
            new Movies("Repo the Genetic Opera", 1),
            new Movies("You've Got Mail", 5),
            new Movies("Shawshank Redemption", 5)
    ));

    public List<Movies> getAllMovies() {
        return movies;
    }

    public Movies getMovies(String id) {
        return movies.stream().filter(t -> t.getName().contains(id)).findFirst().get();
    }

    public void addMovies(Movies movie) {
        movies.add(movie);
    }

    public void updateMovies(Movies movie, String id) {
        for(int i = 0; i < movies.size(); i++)
        {
            Movies t = movies.get(i);
            if (t.getName().equals(id))
            {
                movies.set(i, movie);
                return;
            }
        }
    }

    public void deleteMovies(String id) {
        movies.removeIf(t -> t.getName().equals(id));
    }
}
