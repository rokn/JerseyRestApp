package bg.elsys.ip.rest.resources;

import bg.elsys.ip.rest.models.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rokner on 11/27/16.
 */
public class ProductFilter {
    private Integer page;
    private Integer perPage;
    private String prodName;
    private Integer minQuantity;
    private Float maxPrice;
    private String providerName;
    private String department;
    private String barcode;

    public ProductFilter(Integer page, Integer perPage, String prodName, Integer minQuantity, Float maxPrice, String providerName, String department, String barcode) {
        this.page = page;
        this.perPage = perPage;
        this.prodName = prodName;
        this.minQuantity = minQuantity;
        this.maxPrice = maxPrice;
        this.providerName = providerName;
        this.department = department;
        this.barcode = barcode;
    }

    public PagedResponse filterProducts(List<Product> products) {
        int previousItems = (page-1) * perPage;
        List<Product> result = products.stream()
                .filter(product -> stringFilter(prodName, product.getName()))
                .filter(product -> minQuantity == null || product.getQuantity() >= minQuantity)
                .filter(product -> maxPrice == null || product.getPrice() <= maxPrice)
                .filter(product -> stringFilter(providerName, product.getProvider()))
                .filter(product -> stringFilter(department, product.getDepartment()))
                .filter(product -> stringFilter(barcode, product.getBarcode()))
                .collect(Collectors.toList());
        int maxPages = result.size() / perPage;
        result = result.stream().skip(previousItems).limit(perPage).collect(Collectors.toList());

        return new PagedResponse(result, page, maxPages);
    }

    private boolean stringFilter(String wanted, String original) {
        return wanted == null || "".equals(wanted) || original.toLowerCase().contains(wanted.toLowerCase());
    }

}
