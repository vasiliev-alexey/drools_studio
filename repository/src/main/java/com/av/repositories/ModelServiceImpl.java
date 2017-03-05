package com.av.repositories;

import com.av.data.services.ModelService;
import com.av.domain.settings.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by vasiliev-alexey on 26.11.16.
 */


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ModelServiceImpl extends AbstracrService<Model> implements ModelService  {

    @PersistenceContext
    private EntityManager emf;



    @Override
    public void remove(Model model) {

        emf.remove(model);
    }
}
