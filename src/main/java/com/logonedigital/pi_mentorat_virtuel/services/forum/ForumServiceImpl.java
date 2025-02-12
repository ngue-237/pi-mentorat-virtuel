package com.logonedigital.pi_mentorat_virtuel.services.forum;

import com.github.slugify.Slugify;
import com.logonedigital.pi_mentorat_virtuel.entities.Forum;
import com.logonedigital.pi_mentorat_virtuel.entities.Sujet;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceExisteException;
import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.repositories.ForumRepo;
import com.logonedigital.pi_mentorat_virtuel.repositories.SujetRepo;
import com.logonedigital.pi_mentorat_virtuel.repositories.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService {
    private final ForumRepo forumRepo;
    private final SujetRepo sujetRepo;
    private final UserRepo userRepo;

    public ForumServiceImpl(ForumRepo forumRepo, SujetRepo sujetRepo, UserRepo userRepo) {
        this.forumRepo = forumRepo;
        this.sujetRepo = sujetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Forum addForum(Forum forum) {
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumExist = this.forumRepo.findByTitle(forum.getTitle());
           if (forumExist.isPresent())
               throw new ResourceExisteException(" Ca existe");
           forum.setSlug(slg.slugify(forum.getTitle()));
           forum.setTitle(forum.getTitle());
           forum.setDescription(forum.getDescription());
           forum.setCreatedBy(forum.getCreatedBy());
           forum.setCreatedAt(new Date());
        //forum.setUser(this.userRepo.save(user));
        return this.forumRepo.save(forum);
    }

    @Override
    public Page<Forum> getForum(int offset, int pageSize) {
        return this.forumRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.forumRepo::save);
    }

    @Override
    public List<Forum> getAllForum() {
        return this.forumRepo.findAll();
    }

    @Override
    public List<Forum> getForumByDescription(String description) {
       List<Forum> forums = forumRepo.fetchByDescription(description);
       if(forums.isEmpty())
           throw new RuntimeException("No forum founds");
        return forums;
    }



    @Override
    public Forum getById(Integer forumId) {
        return this.forumRepo.findById(forumId).get();
    }

    @Override
    public Forum updated(Forum forum, Integer forumId) {
        final Slugify slg = Slugify.builder().build();
        Optional<Forum> forumToEdit = this.forumRepo.findById(forumId);
        if(forumToEdit.isEmpty())
            throw new ResourceNotFoundException("Le nom n'a pas ete trouve");
        if (forum.getTitle() != null){
            forumToEdit.get().setSlug(slg.slugify(forum.getTitle()));
        }
        if (forum.getDescription() != null){
            forumToEdit.get().setDescription(forum.getDescription());
        }
        return this.forumRepo.saveAndFlush(forumToEdit.get());
    }

    @Override
    public void delete(Integer forumId) {
        this.forumRepo.deleteById(forumId);

    }

    @Override
    public Forum liaison(Integer forumId, Integer sujetId) {
        List<Sujet> sujetList = null;
        Forum forum = forumRepo.findById(forumId).get();
        Sujet sujet = sujetRepo.findById(sujetId).get();
        sujetList = forum.getSujetForum();
        sujetList.add(sujet);
        forum.setSujetForum(sujetList);
         return forumRepo.save(forum);
    }
}