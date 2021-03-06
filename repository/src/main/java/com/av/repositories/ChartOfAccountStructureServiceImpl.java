package com.av.repositories;

import com.av.data.services.ChartOfAccountStructureService;
import com.av.domain.accounting.ChartOfAccountStructure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
@Transactional
public class ChartOfAccountStructureServiceImpl implements ChartOfAccountStructureService {
    @PersistenceContext
    private EntityManager emf;

    @Override
    @CacheEvict(cacheNames = "chartOfAccountStructure"  )
    public ChartOfAccountStructure save(ChartOfAccountStructure chartOfAccountStructure) {
        if (chartOfAccountStructure.getId() == 0) {
            emf.persist(chartOfAccountStructure);
        } else {
            emf.merge(chartOfAccountStructure);
        }
        return chartOfAccountStructure;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "chartOfAccountStructure")
    public ObservableList<ChartOfAccountStructure> getAll() {
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<ChartOfAccountStructure> cq = cb.createQuery(ChartOfAccountStructure.class);
        Root<ChartOfAccountStructure> rootEntry = cq.from(ChartOfAccountStructure.class);
        CriteriaQuery<ChartOfAccountStructure> all = cq.select(rootEntry);
        TypedQuery<ChartOfAccountStructure> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList(allQuery.getResultList());

    }

    @Override
    @CacheEvict (cacheNames = "chartOfAccountStructure"  , allEntries = true)
    public void remove(ChartOfAccountStructure chartOfAccountStructure) {
        emf.remove(chartOfAccountStructure);
    }
}
