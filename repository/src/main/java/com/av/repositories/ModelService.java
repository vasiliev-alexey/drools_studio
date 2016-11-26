package com.av.repositories;

import com.av.domain.Model;
import org.springframework.data.repository.Repository;

/**
 * Created by alexey on 25.11.16.
 */
public interface ModelService {

    Model Save(Model model);

}
