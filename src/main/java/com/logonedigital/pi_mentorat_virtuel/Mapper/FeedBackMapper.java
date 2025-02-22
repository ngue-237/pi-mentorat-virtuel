package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.*;
import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import com.logonedigital.pi_mentorat_virtuel.entities.Location;
import com.logonedigital.pi_mentorat_virtuel.entities.Mentore;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
@Configuration
@Mapper(componentModel = "spring")
public interface FeedBackMapper {
    FeedBack fromFeedBackReqDTO(FeedBackReqDTO feedBackReqDTO);

}
