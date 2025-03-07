package com.logonedigital.pi_mentorat_virtuel.services.FeedBack;

import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;

import java.util.List;

public interface FeedBackService { FeedBack addFeedBack(FeedBack feedBack);
    List<FeedBack> getFeedBack();
    FeedBack findFeedBackByCommentaire(String commentaire);
    FeedBack getFeedBackById(Integer feedBackId);
    FeedBack updatedFeedBackById(FeedBack feedBack, Integer feedBackId);
    void deleteFeedBack(Integer feedBackId);
}
