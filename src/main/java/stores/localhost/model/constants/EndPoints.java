package stores.localhost.model.constants;

public class EndPoints {
    /**
     * This is Endpoints of Product api
     */
    public static final String GET_ALL_PRODUCT = "/products";
    public static final String CREATE_PRODUCT = "/products";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/products/{productId}";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{productId}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{productId}";
    /**
     * This is Endpoints of store api
     */
    public static final String GET_ALL_STORE = "/stores";
    public static final String CREATE_STORE = "/stores";
    public static final String GET_SINGLE_STORE_BY_ID = "/stores/{storesId}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storesId}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storesId}";
    /**
     * This is Endpoints of services api
     */
    public static final String GET_SERVICES_ALL_ = "/services";
    public static final String CREATE_SERVICES = "/services";
    public static final String GET_SINGLE_SERVICES_BY_ID = "/services/{servicesId}";
    public static final String UPDATE_SERVICES_BY_ID = "/services/{servicesId}";
    public static final String DELETE_SERVICES_BY_ID = "/services/{servicesId}";

    /**
     * This is Endpoints of categories api
     */
    public static final String GET_CATEGORIES_ALL = "/categories";
    public static final String CREATE_CATEGORIES = "/categories";
    public static final String GET_SINGLE_CATEGORIES_BY_ID = "/categories/{categoriesid}";
    public static final String UPDATE_CATEGORIES_BY_ID = "/categories/{categoriesid}";
    public static final String DELETE_CATEGORIES_BY_ID = "/categories/{categoriesid}";

    /**
     * This is Endpoints of UTILITIES api
     */
    public static final String GET_UTILITIES_HEALTHCHECK = "/Healthcheck";
    public static final String GET_UTILITIES_VERSION = "/version";
}


