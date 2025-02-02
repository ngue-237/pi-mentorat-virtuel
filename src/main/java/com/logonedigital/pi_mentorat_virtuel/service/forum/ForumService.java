package com.logonedigital.pi_mentorat_virtuel.service.forum;

import com.logonedigital.pi_mentorat_virtuel.entities.Forum;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ForumService {
    Forum addForum(Forum forum);
    Page<Forum> getForum(int offset, int pageSize);
    List<Forum> getAllForum();
    List<Forum> getForumByDescription(String description);
    Forum getById(Integer forumId);
    Forum updated(Forum forum, Integer forumId);
    void delete(Integer forumId);
    Forum liaison(Integer forumId, Integer sujetId);
}
