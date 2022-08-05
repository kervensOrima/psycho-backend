package com.helptek.spychobackend.service.patientserviceimpl;

import com.helptek.spychobackend.model.Patient;
import com.helptek.spychobackend.repository.PatientRepository;
import com.helptek.spychobackend.service.PatientService;
import com.helptek.spychobackend.service.dto.PatientDTO;
import com.helptek.spychobackend.service.exceptions.AgeInvalideException;
import com.helptek.spychobackend.service.exceptions.ObjectNotFoundException;
import com.helptek.spychobackend.utilities.DateManipulationService;
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
        ;
        // verifier que le patient a plus de 5 ans par exemple
        // on appelle la fonction checkAge qui prend en argument l'age et le critère (metier) puis
        // on appelle la fonction calculer age qui calcule l'age de la personne
        // au cas l'age est plus petit que le critère accepter on élève une exception
        if( ! DateManipulationService.checkAge(DateManipulationService.calculAge(request.getDate_naissance()) , 10 )){
            throw new AgeInvalideException("L'age du patient du doit etre superieure au critère demandé");
        }

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
