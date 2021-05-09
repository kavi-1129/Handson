
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

public class ProductMain {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("example-unit");

    public static void main(String[] args) {
        try {
            persistProducts();
            
            //using like
            findProductByName();

        } finally {
            entityManagerFactory.close();
        }
    }

    public static void persistProducts() {
        Product product1 = Product.create(1,"Laptop","Alexa built in");
        Product product2 = Product.create(2,"Phone","Fast charging");
        
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        
        em.getTransaction().commit();
        em.close();
    }

    private static void findProductByName() {

    	EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Metamodel m = entityManager.getMetamodel();
        EntityType<Product> Product_ = m.entity(Product.class);
        Root<Product> product = query.from(Product.class);
        query.select(product)
             .where(criteriaBuilder.like(product.get(Product_.getName()),"lap%"));
        entityManager.createQuery(query).getResultList().forEach(System.out::println);
        entityManager.close();
    }

}