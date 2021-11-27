package com.lab6.service;

import com.lab6.models.Career;
import com.lab6.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class CareerService {

    @Autowired
    public CareerRepository careerRepository;

    public Career addCareer(final Career career) {
        return careerRepository.save(career);
    }

    public Career updateCareer(final Career career) {
        return careerRepository.save(career);
    }

    public List<Career> getCareer() {
        return careerRepository.findAll();
    }

    public Career getCareerId(final Integer id) {
        return careerRepository.findById(id).orElse(null);
    }

    public void deleteCareerById(Integer id){
        careerRepository.deleteById(id);
    }
}
