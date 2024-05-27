package me.fixeddev.basededatos;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@RepositoryRestController
public class RestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {

        entityManager.getMetamodel().getEntities().forEach(entityType -> {
            Class<?> javaType = entityType.getJavaType();
            config.exposeIdsFor(javaType);
        });

    }
}
