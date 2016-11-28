package bg.elsys.ip.rest.models;

import java.util.List;

/**
 * Created by rokner on 11/28/16.
 */
public class AutoCompleter {
    private List<String> productNames;
    private List<String> providerNames;
    private List<String> departmentNames;
    private List<String> barcodes;

    public AutoCompleter(List<String> productNames, List<String> providerNames, List<String> departmentNames, List<String> barcodes) {
        this.productNames = productNames;
        this.providerNames = providerNames;
        this.departmentNames = departmentNames;
        this.barcodes = barcodes;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public List<String> getProviderNames() {
        return providerNames;
    }

    public List<String> getDepartmentNames() {
        return departmentNames;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }
}
