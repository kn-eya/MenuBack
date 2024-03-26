package com.example.back.back.services.impls;

import com.example.back.back.entities.Feedback;
import com.example.back.back.repositories.FeedbackRepository;
import com.example.back.back.services.interfaces.IFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class FeedbackService implements IFeedback {
    @Autowired
    private FeedbackRepository feedbackRepository ;
    @Override
    public List<Feedback> getList() {
        return feedbackRepository.findAll();
    }
    @Override

    public Feedback getOne(Long id) {
        return feedbackRepository.findById(id).get();
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteOne(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Feedback update(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

}
