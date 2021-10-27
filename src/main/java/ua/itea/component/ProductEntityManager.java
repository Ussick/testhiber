package ua.itea.component;


import ua.itea.model.ProductEntity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class ProductEntityManager {
    private EntityManager em =
            Persistence.createEntityManagerFactory("market").createEntityManager();

    public ProductEntity getProductById(int id) {
        return em.find(ProductEntity.class, id);
    }


    public List<ProductEntity> getProducts() {
        List<ProductEntity> productEntityList = em.createNamedQuery("getAllProducts").getResultList();
        return productEntityList;
    }

    public List<ProductEntity> getProductsByCategoryId(int categoryId) {
        List<ProductEntity> productEntityList = em.createNamedQuery("getProductsByCategory").
                setParameter("id", categoryId).getResultList();
        return productEntityList;
    }
}
