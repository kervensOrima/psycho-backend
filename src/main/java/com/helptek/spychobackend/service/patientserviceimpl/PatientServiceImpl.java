package com.helptek.spychobackend.service.patientserviceimpl;

import com.helptek.spychobackend.model.Patient;
import com.helptek.spychobackend.repository.PatientRepository;
import com.helptek.spychobackend.service.PatientService;
import com.helptek.spychobackend.service.dto.PatientDTO;
import com.helptek.spychobackend.service.exceptions.ObjectNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientServiceImpl implements PatientService {

    ModelMapper modelMapper ;

    PatientRepository patientRepository ;

    @Override
    public PatientDTO creerCompte(PatientDTO request) {
        log.info("save patient");
        Patient patient = this.modelMapper.map(request , Patient.class ) ;
        return this.modelMapper.map( this.patientRepository.save(patient) , PatientDTO.class );
    }

    @Override
    public PatientDTO modifierCompte(PatientDTO request, Long idPatient) {
        log.info("update patient info");
        this.listerPatient(idPatient) ;
        Patient patient = this.modelMapper.map(request, Patient.class );
        return this.modelMapper.map(this.patientRepository.save(patient), PatientDTO.class);
    }

    @Override
    public PatientDTO listerPatient(Long idPatient) {
        log.info("find patient by id");
        return this.modelMapper.map(this.patientRepository.findById(idPatient)
                        .orElseThrow(() -> new ObjectNotFoundException("Le patient ayant pour id " + idPatient + " est introuvable!")), PatientDTO.class);
    }

}
