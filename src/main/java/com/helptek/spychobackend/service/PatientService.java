package com.helptek.spychobackend.service;


import com.helptek.spychobackend.service.dto.PatientDTO;

public interface PatientService {

    PatientDTO creerCompte(PatientDTO request);

    PatientDTO modifierCompte(PatientDTO request, Long idPatient) ;

    PatientDTO listerPatient(Long idPatient) ;

}
