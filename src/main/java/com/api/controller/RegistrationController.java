package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this will make  api layer
@RestController
// to call the class
@RequestMapping("/api/v1/registration")
public class RegistrationController {

// CONSTRUCTOR BASED OBJECT


    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

// GET METHOD
    // will convert java obj into jason obj and get all tha dta from database
    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistration() {
        List<RegistrationDto> Dtoreg = registrationService.getRegistration();
        return new ResponseEntity<>(Dtoreg, HttpStatus.OK);
    }

 // Finding Registration By Id
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable long id
    ){
        RegistrationDto reg =  registrationService.getRegistrationById(id);
        return  new ResponseEntity<>(reg,HttpStatus.OK);
    }


// CREATE METHOD
    // used to save data in database from jason obj
    // @Request body use to take data from jason obj and put to in Registration obj

    @PostMapping
    // here we changed return type to ? because there is more than one type return type there
    public ResponseEntity<?> createRegistration(
          @Valid @RequestBody RegistrationDto registrationDto,
          // BindingResult -> use to creating obj to store error msg
          BindingResult result
    ) {
        // giving condition if error occurred return this msg if not return next redDto msg
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }
// DELETE METHOD
    // use to delete tha data from db via api
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam Long id
    ) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Registration Deleted", HttpStatus.OK);
    }

// UPDATE METHOD
    //update the record via api in db
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable Long id,
            @RequestBody Registration registration
    ) {
        Registration reg = registrationService.updateRegistration( id,registration);
        return new ResponseEntity<>(reg, HttpStatus.OK);
    }
}
