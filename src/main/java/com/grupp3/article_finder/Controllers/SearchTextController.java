package com.grupp3.article_finder.Controllers;

import com.grupp3.article_finder.Entities.Article;
import com.grupp3.article_finder.Services.SearchTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchTextController {

    @Autowired
    SearchTextService searchTextService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/data")
    public List<Article> matchSearchText(@RequestBody String searchText){
        return searchTextService.matchSearchText(searchText);
    }
}
