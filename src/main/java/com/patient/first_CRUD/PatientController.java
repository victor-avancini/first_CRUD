package com.patient.first_CRUD;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private ArrayList<PatientModel> patients = new ArrayList<>();

    @PostMapping
    public PatientModel create(@RequestBody PatientModel payload){
        long nextId = patients.size() + 1;
        payload.setId(nextId);
        patients.add(payload);

        return payload;
    }

    @GetMapping
    public ArrayList<PatientModel> read(){
        return patients;
    }

    @GetMapping("/{patientId}")
    public Optional<PatientModel> retrieve(@PathVariable long patientId) {
        return patients.stream().filter(p -> p.getId().equals(patientId)).findFirst();
    }

    @PutMapping("/{patientId}")
    public Optional<PatientModel> update(@PathVariable long patientId, @RequestBody PatientModel payload) {
        var newPatients = patients.stream().map(p -> {
            if(p.getId().equals(patientId)) {
                payload.setId(p.getId());
                return payload;
            }
            return p;
        });
        patients = new ArrayList<>(newPatients.toList());
        return patients.stream().filter(p -> p.getId().equals(patientId)).findFirst();
    }

    @DeleteMapping("/{patientId}")
    public void delete(@PathVariable long patientId){
        var newPatients = patients.stream().filter(p -> !p.getId().equals(patientId));
        patients = new ArrayList<>(newPatients.toList());
    }
}
