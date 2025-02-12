package com.logonedigital.pi_mentorat_virtuel.services.Location;

import com.logonedigital.pi_mentorat_virtuel.dto.LocationReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.LocationRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Location;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {
    LocationRespDTO addLocation(@Valid LocationReqDTO locationReqDTO);
    List<Location> getLocations();
    Page<LocationRespDTO> getLocations(int offset, int pageSize);
    Location getLocationById(Integer locationId);
    Location updateLocation(Location location , Integer locationId);
    void deleteLocation(Integer locationId);
}
