package com.logonedigital.pi_mentorat_virtuel.Mapper;

import com.logonedigital.pi_mentorat_virtuel.dto.Location.LocationReqDTO;

import com.logonedigital.pi_mentorat_virtuel.dto.Location.LocationRespDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Mentore.MentoreReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.Mentore.MentoreRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Location;
import com.logonedigital.pi_mentorat_virtuel.entities.Mentore;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;


@Mapper(componentModel = "spring")
@Configuration
public interface MentoreMapper {
    Mentore fromMentoreReqDTO(MentoreReqDTO mentoreReqDTO);
    Location fromLocationReqDTO(LocationReqDTO locationReqDTO);

    MentoreRespDTO fromMentore(Mentore mentore);
    LocationRespDTO fromLocation(Location location);

}
