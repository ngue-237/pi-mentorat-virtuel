package com.logonedigital.pi_mentorat_virtuel.services.Rdv;

import com.logonedigital.pi_mentorat_virtuel.exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.RdvMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.Rdv.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.Rdv.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import com.logonedigital.pi_mentorat_virtuel.repositories.RdvRepo;
import com.logonedigital.pi_mentorat_virtuel.services.FeedBack.FeedBackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RdvServiceImp implements RdvService{
private final RdvRepo rdvRepo;
private final FeedBackService feedBackService;
private final RdvMapper rdvMapper;
    public RdvServiceImp(RdvRepo rdvRepo, FeedBackService feedBackService, RdvMapper rdvMapper) {

        this.rdvRepo = rdvRepo;
        this.feedBackService = feedBackService;
        this.rdvMapper = rdvMapper;
    }


    @Override
    public RdvResDto addRdv(RdvReqDto rdvReqDto) {
     RDV rdv= this.rdvMapper.fromRdvReqDto(rdvReqDto);;
        FeedBack feedBack= this.rdvMapper.fromFeedBackReqDTO(rdvReqDto.getFeedBackReqDTO);
        return this.rdvMapper.fromRDV(this.rdvRepo.save(rdv));
    }

    @Override
    public Page<RdvResDto> getrdvs(int offset, int pageSize, RDV rdv) {
        return this.rdvRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(customer -> this.rdvMapper.fromRDV(rdv));
    }

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
