package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import com.logonedigital.pi_mentorat_virtuel.service.FeedBack.FeedBackService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedBackController {
    private FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("feedBack/add")
    public ResponseEntity<FeedBack> addFeedBack(@Valid @RequestBody FeedBack feedBack) {
        return ResponseEntity
                .ok(this.feedBackService.addFeedBack(feedBack));
    }

    @GetMapping(path = "feedBackById/get_By_Id/{id}")
    public ResponseEntity<FeedBack> getFeedBackById(Integer feedBackId){
        return ResponseEntity
                .status(200)
                        .

                body(this.feedBackService.getFeedBackById(feedBackId));
    }
    @GetMapping(path = "feedback/get-feedback-commentaire/{commentaire}")
    public ResponseEntity<FeedBack> getFeedBackByCommentaire(@PathVariable String commentaire){
        return ResponseEntity
                .ok(this.feedBackService.findFeedBackByCommentaire(commentaire));
    }
    @GetMapping(path = "feedBack/get-all")
    public ResponseEntity<List<FeedBack>> getFeedBack(){
        return ResponseEntity
                .status(200)
                .body(this.feedBackService.getFeedBack());

    }
    @PatchMapping(path = "feedBack/update-by-id/{FeedBackId}")
    public ResponseEntity<FeedBack> updateFeedBackById(@PathVariable Integer FeedBackId,@RequestBody FeedBack feedBack ){
        return  ResponseEntity
                .status(202)
                .body(this.feedBackService.updatedFeedBackById(feedBack, FeedBackId));
    }
    @DeleteMapping(path = "feedBack/delete_by_id/{feedBackId}")
    public ResponseEntity<String> deleteFeedBackById(@PathVariable Integer feedBackId){
        this.feedBackService.deleteFeedBack(feedBackId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
