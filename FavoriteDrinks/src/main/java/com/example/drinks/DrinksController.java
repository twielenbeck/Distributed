package com.example.drinks;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
public class DrinksController {
    @RequestMapping("/drinks")
    public List<Drinks> getAllSongs() {
        List<Drinks> songs = new ArrayList<>();
        songs.add(new Drinks("Code Red","Mountain Dew", 5));
        songs.add(new Drinks("Sake","Tyku", 4));
        songs.add(new Drinks("12 yr Single Malt","Glenlivet", 5));
        return songs;
    }
}
