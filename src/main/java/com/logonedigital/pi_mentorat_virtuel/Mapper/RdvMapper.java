package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.FeedBackReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.RdvResDto;
import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import com.logonedigital.pi_mentorat_virtuel.entities.RDV;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;
@Mapper(componentModel = "spring")
@Configuration
public interface RdvMapper {

    RDV fromRdvReqDto(RdvReqDto rdvReqDto);
FeedBack fromFeedBackReqDTO(FeedBackReqDTO feedBackReqDTO);

    @Mapping(source = "feedBack", target = "feedBackResDTO")
   static RdvResDto fromRDV(RDV rdv) {
       // return new RdvResDto();
        return null;
    }
}
