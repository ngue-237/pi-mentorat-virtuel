package com.logonedigital.pi_mentorat_virtuel.service.FeedBack;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.FeedBackMapper;
import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import com.logonedigital.pi_mentorat_virtuel.repositories.FeedBackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImp implements FeedBackService{
    public final FeedBackRepo feedBackRepo;
public final FeedBackMapper feedBackMapper;
    public FeedBackServiceImp(FeedBackRepo feedBackRepo, FeedBackMapper feedBackMapper) {
        this.feedBackRepo = feedBackRepo;
        this.feedBackMapper = feedBackMapper;
    }


    @Override
    public FeedBack addFeedBack(FeedBack feedBack) {
        return this.feedBackRepo.save(feedBack);
    }

    @Override
    public List<FeedBack> getFeedBack() {
        return this.feedBackRepo.findAll();
    }

    @Override
    public FeedBack findFeedBackByCommentaire(String commentaire) {
        Optional<FeedBack> feedBack = this.feedBackRepo.findFeedBackByCommentaire(commentaire);
        if (feedBack.isEmpty())
            throw new ResourceNotFoundException("feedback not found");
        return feedBack.get();
    }

    @Override
    public FeedBack getFeedBackById(Integer feedBackId) {
        return this.feedBackRepo.findById(feedBackId).orElseThrow(() -> new ResourceNotFoundException("Rendez-vous with ID '" ));
    }

    @Override
    public FeedBack updatedFeedBackById(FeedBack feedBack, Integer feedBackId) {

        FeedBack feedBackToEdit= this.feedBackRepo.findById(feedBackId).get();

        feedBackToEdit.setCommentaire(feedBack.getCommentaire());

        feedBackToEdit.setNote(feedBack.getNote());

        return this.feedBackRepo.saveAndFlush(feedBackToEdit);
    }

    @Override
    public void deleteFeedBack(Integer feedBackId) {
        this.feedBackRepo.deleteById(feedBackId);
    }
}
