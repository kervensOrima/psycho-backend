package com.helptek.spychobackend.web.restcontroller;

import com.helptek.spychobackend.service.dto.PatientDTO;
import com.helptek.spychobackend.service.patientserviceimpl.PatientServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(path = "psycho-backend/patients/")
@AllArgsConstructor
@RestController
@CrossOrigin(originPatterns = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PatientRestController  {

    PatientServiceImpl patientService ;

    @PostMapping(path = "")
    public ResponseEntity<PatientDTO> creerCompte(@Valid @RequestBody(required = true) PatientDTO request) {
        return new ResponseEntity<PatientDTO>( this.patientService.creerCompte(request) , HttpStatus.CREATED );
    }

    @PatchMapping(path = "{idPatient}")
    public ResponseEntity<PatientDTO> modifierCompte(@Valid @RequestBody(required = true)  PatientDTO request,@PathVariable(name = "idPatient", required = true) Long idPatient) {
        return new ResponseEntity<PatientDTO>( this.patientService.modifierCompte(request, idPatient), HttpStatus.ACCEPTED );
    }

    @GetMapping(path = "{idPatient}")
    public ResponseEntity<PatientDTO> listerPatient(@PathVariable(name = "idPatient", required = true) Long idPatient) {
        return new ResponseEntity<PatientDTO>( this.patientService.listerPatient(idPatient) , HttpStatus.OK );
    }
}
