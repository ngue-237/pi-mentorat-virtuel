package com.logonedigital.pi_mentorat_virtuel.service.Rdv;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.RdvMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import com.logonedigital.pi_mentorat_virtuel.repositories.RdvRepo;
import com.logonedigital.pi_mentorat_virtuel.service.FeedBack.FeedBackService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Optional;

@Service
public class RdvServiceImp implements RdvService{
private final RdvRepo rdvRepo;
private final FeedBackService feedBackService;
private final RdvMapper rdvMapper;
    private String visioconference;
    private Date debutdurdv;
    private Date duree;
    private String etat;

    public RdvServiceImp(RdvRepo rdvRepo, FeedBackService feedBackService, RdvMapper rdvMapper) {

        this.rdvRepo = rdvRepo;
        this.feedBackService = feedBackService;
        this.rdvMapper = rdvMapper;
    }


    @Override
    public RdvResDto addRdv(RdvReqDto rdvReqDto) {
      //  Optional<RDV> rdvExist= this.rdvRepo.findRDVByVisioconference(rdvReqDto.getVisioconference());

      //  RdvResDto rdvResDto = this.rdvMapper.fromRDV(this.rdvRepo.save(rdvReqDto));
//        return rdvResDto;
        RDV rdv= this.rdvMapper.fromRdvReqDto(rdvReqDto);

        return RdvMapper.fromRDV(this.rdvRepo.saveAndFlush(rdv));
    }

    @Override
    public Page<RdvResDto> getrdvs(int offset, int pageSize, RDV rdv) {
        return this.rdvRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(customer -> RdvMapper.fromRDV(rdv));
    }

    @Override
    public RDV findRdvByVisioconference(String visioconference) {
        Optional<RDV> rdv = this.rdvRepo.findRDVByVisioconference(visioconference);
        if (visioconference.isEmpty())
            throw new ResourceNotFoundException("rdv not found");
        return rdv.get();
    }

   /* @Override
    public RDV searchrdv(String visioconference, Date debutdurdv, Date duree, String etat) {
       Optional<RDV> rdv=this.rdvRepo.searchrdv(visioconference,debutdurdv,duree,etat);
        this.visioconference = visioconference;
        this.debutdurdv = debutdurdv;
        this.duree = duree;
        this.etat = etat;
        if (rdv.isEmpty())
            throw new ResourceNotFoundException("rdv not found");
        return rdv.get();
       // return rdvRepo.searchrdv( visioconference,debutdurdv,duree,etat);
    }*/

    // public List<RDV> searchrdv(String clientName, LocalDate dateFrom, LocalDate dateTo, String serviceType, String status) {
     //   return rdvRepo.searchrdv(clientName, dateFrom, dateTo, serviceType, status);
    //}

    @Override
    public RDV getRDVById(Integer rdvId) {
        return this.rdvRepo.findById(rdvId).orElseThrow(()-> new ResourceNotFoundException("rdv does not exist")) ;
    }

    @Override
    public RDV updateRDV(RDV rdv, Integer rdvId) {
        Optional<RDV> rdvToEdit= this.rdvRepo.findById(rdvId);
        if (rdvToEdit.isEmpty())
            throw new ResourceNotFoundException("rdv does not exist");
        if (rdv.getDebutduRDV()!=null)
            rdvToEdit.get().setDebutduRDV(rdv.getDebutduRDV());
        if (rdv.getDuree()!=null)
            rdvToEdit.get().setDuree(rdv.getDuree());
        if (rdv.getEtat()!=null)
            rdvToEdit.get().setEtat(rdv.getEtat());
        if (rdv.getVisioconference()!=null)
            rdvToEdit.get().setVisioconference(rdv.getVisioconference());
        return this.rdvRepo.saveAndFlush(rdvToEdit.get());

    }

    @Override
    public void deleteRDV(Integer rdvId) {
        RDV rdv= this.rdvRepo.findById(rdvId)
                .orElseThrow(()-> new ResourceNotFoundException("rdv does not exist"));
        this.rdvRepo.delete(rdv);
    }
}
