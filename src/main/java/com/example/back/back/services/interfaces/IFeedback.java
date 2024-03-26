package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Feedback;

import java.util.List;

public interface IFeedback {
    List<Feedback> getList();

    Feedback getOne(Long id);

    Feedback create(Feedback feedback);

    void deteletOne(long id);

    Feedback update(Feedback feedback);
}
