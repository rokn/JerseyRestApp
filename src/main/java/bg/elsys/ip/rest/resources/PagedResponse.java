package bg.elsys.ip.rest.resources;

import bg.elsys.ip.rest.models.Product;

import java.util.List;

/**
 * Created by rokner on 11/28/16.
 */
public class PagedResponse {
    private List<Product> products;
    private int page;
    private int maxPages;

    public PagedResponse(List<Product> products, int page, int maxPages) {
        this.products = products;
        this.page = page;
        this.maxPages = maxPages;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }
}
