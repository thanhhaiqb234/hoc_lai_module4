package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from blog where category_id =:id",nativeQuery = true)
    List<Blog> getAllBlogId(@Param("id") int id);

    Page<Blog> findAllByNameContaining(Pageable pageable,String name);
}
