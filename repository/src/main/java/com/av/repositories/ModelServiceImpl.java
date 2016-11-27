package com.av.repositories;

import com.av.domain.Model;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vasiliev.Alexey on 26.11.16.
 */

@Service(value = "modelService")
@Repository
@Transactional
public class ModelServiceImpl implements ModelService {

    @PersistenceContext
    private EntityManager emf;

    @Override


    public Model Save(Model model) {


        if(model.getId() == null) {
            emf.persist(model);
        } else  {
            emf.merge(model);
        }
        return model;


    }
}
