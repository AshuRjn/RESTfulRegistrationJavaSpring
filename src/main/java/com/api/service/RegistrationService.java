package com.api.service;


import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repositroy.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

// CONSTRUCTOR BASED OBJECT

    private ModelMapper modelMapper;
    private RegistrationRepository registrationRepository;

    public RegistrationService(ModelMapper modelMapper, RegistrationRepository registrationRepository) {
        this.modelMapper = modelMapper;
        this.registrationRepository = registrationRepository;
    }

// GET/listAll REGISTRATION METHOD
    public List<RegistrationDto> getRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        //we can also use  method reference (this:: mapToDto)
        List<RegistrationDto> dtoReg = registrations.stream().map(s->mapToDto(s))
                .collect(Collectors.toList());
        return dtoReg;
    }
//Get Registration By Id Method
    public RegistrationDto getRegistrationById(
            long id
    ) {
                        /* exception code start from here .or else throw */
        Registration reg = registrationRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found")
        );
        return mapToDto(reg);
    }

// CREATE METHOD
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        //  calling dto maptoentity  method
        Registration reg = mapToEntity(registrationDto);

        //calling maptodto method
         Registration saveEntity = registrationRepository.save(reg);

        RegistrationDto dto = mapToDto(saveEntity);
        return  dto;
    }

// DELETE METHOD
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

// UPDATE METHOD
    public Registration updateRegistration(long id, Registration registration) {

        //finding by id and get all the details from db by .get()
        Registration r = registrationRepository.findById(id).get();

        // here we are get the details and set the details
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration save = registrationRepository.save(r);
        return save;
    }

    // copy dto to entity method


  Registration  mapToEntity(RegistrationDto registrationDto){

     // to reduce the line of code or get or set code using modelmapper library:
      Registration reg = modelMapper.map(registrationDto, Registration.class);

//      Registration reg = new Registration();
//      reg.setName(registrationDto.getName());
//      reg.setMobile(registrationDto.getMobile());
//      reg.setEmail(registrationDto.getEmail());
    return reg;
  }
  // copy entity to dto method
    RegistrationDto mapToDto(Registration registration){
       RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);

//       RegistrationDto dto = new RegistrationDto();
//      dto.setName(registration.getName());
//      dto.setMobile(registration.getMobile());
//      dto.setEmail(registration.getEmail());
      return dto;
  }


}
