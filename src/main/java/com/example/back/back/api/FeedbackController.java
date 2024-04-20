package com.example.back.back.api;

import com.example.back.back.dtos.Evenementdtos;
import com.example.back.back.dtos.Feedbackdtos;
import com.example.back.back.entities.Evenement;
import com.example.back.back.entities.Feedback;
import com.example.back.back.services.interfaces.ICommande;
import com.example.back.back.services.interfaces.IFeedback;
import com.example.back.back.services.interfaces.IMarket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    @Autowired
    public IFeedback iFeedback;
    @Autowired
    public IMarket iMarket;
    @Autowired
    public ICommande iCommande;
    @Autowired
    private ModelMapper modelMapper ;


    @PostMapping("/createFeedCmd")

    public ResponseEntity<Feedbackdtos> createFeedBackCmd(@RequestBody Feedbackdtos feedbackdtos){
        Feedback feedback = modelMapper.map(feedbackdtos,Feedback.class);

        if(feedbackdtos.getCommandeId()!=null  ){

            feedback.setCommande(iCommande.getOne(feedbackdtos.getCommandeId()));}
        Feedback created =iFeedback.create(feedback);
        return new ResponseEntity<>(modelMapper.map(created,Feedbackdtos.class), HttpStatus.CREATED);
    }


    @PostMapping("/createFeedMarket")

    public ResponseEntity<Feedbackdtos> createEvenement(@RequestBody Feedbackdtos feedbackdtos){
        Feedback feedback = modelMapper.map(feedbackdtos,Feedback.class);
        if(feedbackdtos.getMarketid()!=null){
         feedback.setMarketfeedback(iMarket.getOne(feedbackdtos.getMarketid()));}
         Feedback created= iFeedback.create(feedback);
        return new ResponseEntity<>(modelMapper.map(created,Feedbackdtos.class), HttpStatus.CREATED);
    }
    @GetMapping("/allfeed")
    public ResponseEntity<List<Feedbackdtos>> findfeed() {
        List<Feedback> feedbacks = iFeedback.getList();
        List<Feedbackdtos> feedbackdtos = feedbacks.stream()
                .map(feedback -> modelMapper.map(feedback, Feedbackdtos.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(feedbackdtos, HttpStatus.OK);
    }

}
