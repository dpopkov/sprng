package learn.spr.sh4b.ecomm.config;

import learn.spr.sh4b.ecomm.entity.Country;
import learn.spr.sh4b.ecomm.entity.Product;
import learn.spr.sh4b.ecomm.entity.ProductCategory;
import learn.spr.sh4b.ecomm.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private final HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        disableHttpMethods(config, Product.class);
        disableHttpMethods(config, ProductCategory.class);
        disableHttpMethods(config, Country.class);
        disableHttpMethods(config, State.class);

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //- get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //- create an array of the entity types
        List<Class<?>> entityClasses = new ArrayList<>();

        //- get the entity types for the entities
        for (EntityType<?> et : entities) {
            entityClasses.add(et.getJavaType());
        }

        //- expose the entity ids for the array of entity/domain types
        Class<?>[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

    private void disableHttpMethods(RepositoryRestConfiguration config, Class<?> domainType) {
        config.getExposureConfiguration()
                .forDomainType(domainType)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
