package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from Blog where category_id =:categoryId and blog_name like:searchName" , nativeQuery = true)
    Page<Blog> findAllBy(Pageable pageable, @Param("categoryId") int categoryId,@Param("searchName") String searchName);
}
