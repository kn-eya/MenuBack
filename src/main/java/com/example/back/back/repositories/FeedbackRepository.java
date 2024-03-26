package com.example.back.back.repositories;

import com.example.back.back.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> , CrudRepository<Feedback,Long> {
}
