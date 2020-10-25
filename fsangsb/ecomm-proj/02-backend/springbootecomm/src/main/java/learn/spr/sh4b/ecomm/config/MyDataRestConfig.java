package learn.spr.sh4b.ecomm.config;

import learn.spr.sh4b.ecomm.entity.Product;
import learn.spr.sh4b.ecomm.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private final HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        disableHttpMethods(config, Product.class);
        disableHttpMethods(config, ProductCategory.class);
    }

    private void disableHttpMethods(RepositoryRestConfiguration config, Class<?> domainType) {
        config.getExposureConfiguration()
                .forDomainType(domainType)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
