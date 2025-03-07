package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.FeedBack.FeedBackReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Rdv.RdvReqDto;
import com.logonedigital.pi_mentorat_virtuel.dto.Rdv.RdvResDto;
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
    default RdvResDto fromRDV(RDV rdv) {
        return null;
    }
}
