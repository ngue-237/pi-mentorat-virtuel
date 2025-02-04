package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Mentor;
import com.logonedigital.pi_mentorat_virtuel.services.MentorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }
    @PostMapping(path = "mentor/add")
    @ResponseBody
    public ResponseEntity<Mentor> addMentor(@Valid @RequestBody Mentor mentor){
        return ResponseEntity
                .ok(this.mentorService.addMentor(mentor));


    }
    @GetMapping(path = "mentor/get_all mentor")
    public ResponseEntity<List<Mentor>>getAllMentor(){
        return ResponseEntity
                .ok(this.mentorService.getAllMentor());
    }
    @PutMapping(path = "mentor/update_by_id/{mentorId}")
    public ResponseEntity<Mentor> updateMentorById(@RequestBody Mentor mentor, @PathVariable Integer mentorId){
        return ResponseEntity
                .ok(this.mentorService.getMentorById(mentorId));
    }
    @DeleteMapping(path = "mentor/delete_by_id/{mentorId}")
    public ResponseEntity<String> deleteMentorById(@PathVariable Integer mentor){
       this.mentorService.deleteMentor(mentor);
       return ResponseEntity
               .ok("le mentor à été supprimer");
    }
}
