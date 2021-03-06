package com.crossover.techtrial.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crossover.techtrial.model.Article;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    List<Article> findTop10ByTitleContainingIgnoreCase(String title);

    public Optional<Article> findById(Long id);

    public void deleteById(Long id);

}
