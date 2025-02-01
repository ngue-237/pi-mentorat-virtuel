package com.logonedigital.pi_mentorat_virtuel.service.Location;

import com.logonedigital.pi_mentorat_virtuel.Exception.ResourceNotFoundException;
import com.logonedigital.pi_mentorat_virtuel.Mapper.MentoreMapper;
import com.logonedigital.pi_mentorat_virtuel.dto.LocationReqDTO;
import com.logonedigital.pi_mentorat_virtuel.dto.LocationRespDTO;
import com.logonedigital.pi_mentorat_virtuel.entities.Location;
import com.logonedigital.pi_mentorat_virtuel.repositories.LocationRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;
    private final MentoreMapper mentoreMapper;


    @Autowired
    public LocationServiceImpl(LocationRepo locationRepo, MentoreMapper mentoreMapper){
        this.locationRepo = locationRepo;
        this.mentoreMapper = mentoreMapper;
    }

    public LocationRespDTO addLocation(@Valid LocationReqDTO locationReqDTO) {
        Location location = this.mentoreMapper.fromLocationReqDTO(locationReqDTO);
        location.setCreatedAt(new Date());
        location.setStatus(true);
        return this.mentoreMapper.fromLocation(this.locationRepo.save(location)) ;
    }

    @Override
    public List<Location> getLocations() {
        return this.locationRepo.findAll();
    }

    @Override
    public Page<LocationRespDTO> getLocations(int offset, int pageSize) {
        return this.locationRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.mentoreMapper::fromLocation);
    }

    @Override
    public Location getLocationById(Integer locationId) {

        return this.locationRepo.findById(locationId).orElseThrow(
                ()-> new ResourceNotFoundException("Location not found !")
        );
    }

    @Override
    public Location updateLocation(Location location, Integer locationId) {
        //Recherche
        Optional<Location> locationToEdit = this.locationRepo.findById(locationId);
        if (locationToEdit.isEmpty())
            throw new ResourceNotFoundException("Location not found !");
        //Modidier les informations
        if (location.getTown() != null)
            locationToEdit.get().setTown(location.getTown());
        if (location.getStreet() != null)
            locationToEdit.get().setStreet(location.getStreet());
        if (location.getPostalCode() != null)
            locationToEdit.get().setPostalCode(location.getPostalCode());
        locationToEdit.get().setUpdatedAt(new Date());
        //Sauvegarder les modifications
        return this.locationRepo.saveAndFlush(locationToEdit.get());
    }

    @Override
    public void deleteLocation(Integer locationId) {
        Location location = this.locationRepo.findById(locationId)
                .orElseThrow(()->new ResourceNotFoundException("Location not found"));
        this.locationRepo.delete(location);
    }
}
