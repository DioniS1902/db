package com.lab6.service;

import com.lab6.models.MedicStatus;
import com.lab6.repository.MedicStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class MedicStatusService {

    @Autowired
    public MedicStatusRepository medicStatusRepository;

    public MedicStatus addMedicStatus(final MedicStatus medicStatus) {
        return medicStatusRepository.save(medicStatus);
    }

    public MedicStatus updateMedicStatus(final MedicStatus medicStatus) {
        return medicStatusRepository.save(medicStatus);
    }

    public List<MedicStatus> getMedicStatus() {
        return medicStatusRepository.findAll();
    }

    public MedicStatus getMedicStatusId(final Integer id) {
        return medicStatusRepository.findById(id).orElse(null);
    }

    public void deleteMedicStatusById(Integer id){
        medicStatusRepository.deleteById(id);
    }
}
