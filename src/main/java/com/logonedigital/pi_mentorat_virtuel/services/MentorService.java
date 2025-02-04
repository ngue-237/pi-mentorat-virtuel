package com.logonedigital.pi_mentorat_virtuel.services;

import com.logonedigital.pi_mentorat_virtuel.entities.Mentor;

import java.util.List;

public interface MentorService {
    Mentor addMentor(Mentor mentor);
    List<Mentor> getAllMentor();
    Mentor getMentorById(Integer mentorId);
    Mentor updateMentor(Mentor mentor, Integer mentorId);
    void deleteMentor(Integer mentorId);
}
