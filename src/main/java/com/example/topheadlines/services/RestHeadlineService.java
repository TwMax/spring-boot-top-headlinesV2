package com.example.topheadlines.services;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.dto.ArticleDTO;
import com.example.topheadlines.dto.HeadlineDTO;

import java.util.List;
import java.util.Set;

public interface RestHeadlineService {
    HeadlineDTO getHeadlineService(String country, String category);
    AllSourcesDTO getAllSourcesService();
    List<ArticleDTO> getArticles(String country, String category);
    Set<String> getCountries();
    Set<String> getCategories();
}
