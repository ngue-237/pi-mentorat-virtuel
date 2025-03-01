package com.logonedigital.pi_mentorat_virtuel.services.Mentor;

import com.logonedigital.pi_mentorat_virtuel.entities.Mentor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MentorService {
    Mentor addMentor(Mentor mentor);
    List<Mentor> getAllMentor();
    Mentor getMentorByNom(String nom);
    Page<Mentor> getMentor(int offset, int pageSize);
    Mentor getMentorById(Integer mentorId);
    Mentor updateMentor(Mentor mentor, Integer mentorId);
    void deleteMentor(Integer mentorId);
}
