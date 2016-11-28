var currPage = 0;
var maxPages = 0;
var sentRequest = 0;
function getFilterData() {
    return {
        page : currPage,
        perPage : 30,
        prodName : $("#name").val(),
        expiryBefore : $("#expiryDate").val(),
        minQuantity : $("#quantity").val(),
        maxPrice : $("#price").val(),
        providerName : $("#provider").val(),
        depName : $("#department").val(),
        withBarCode : $("#barcode").val(),
    };
};


function getData(filter) {
    if(!sentRequest) {
        sentRequest = true;
        $.ajax({
            url: config.API_URL + "/products",
            type: "GET",
            dataType: "json",
            data: filter,
            success: function (data) {
                currPage = data.page;
                maxPages = data.maxPages;

                if(currPage == 0){
                    $('#productsTableBody tr:not(.trNoHover)').remove();
                }

                $.each(data.products, function (index) {
                    appendProductToTable(data.products[index])
                });
                sentRequest = false;
            }
        });
    }
}

$(document).ready(function() {
    getData(getFilterData());
    initAutoComplete();

    $(window).scroll(function() {
        if(currPage>=maxPages) return;

        if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
            var filter = getFilterData();
            filter.page += 1;
            getData(filter);
        }
    });

    $(".productFilter").keyup(function() {
        var filter = getFilterData();
        filter.page = 0;
        getData(filter);
    });
});


function onClickAddProduct(){
    var product = {
        name: $("#name").val(),
        expiryDate: $("#expiryDate").val(),
        quantity: $("#quantity").val(),
        price: $("#price").val(),
        provider: $("#provider").val(),
        department: $("#department").val(),
        barcode: $("#barcode").val(),
    };

    addProduct(product);
}

function addProduct(product){
    $.ajax({
        method: 'POST',
        data: JSON.stringify(product),
        url: config.API_URL + '/products',
        contentType: 'application/json',
        success: function (response) {
            window.location.href ="index.html";
        }
    });
}

function appendProductToTable(product){
    var tr = $('<tr>');
    tr.append('<td>' + product.id + '</td>');
    tr.append('<td>' + product.name + '</td>');
    tr.append('<td>' + product.expiryDate + '</td>');
    tr.append('<td>' + product.quantity + '</td>');
    tr.append('<td>' + product.price + '</td>');
    tr.append('<td>' + product.provider + '</td>');
    tr.append('<td>' + product.department + '</td>');
    tr.append('<td>' + product.barcode + '</td>');
    tr.append('</tr>');
    $('#productsTableBody').append(tr);
}

function initAutoComplete() {
    $.get({
        url: config.API_URL + "/products/auto",
        dataType: "json",
        success: function (data) {
            $("#name").autocomplete({
                source: data.productNames
            });
            $("#provider").autocomplete({
                source: data.providerNames
            });
            $("#department").autocomplete({
                source: data.departmentNames
            });
            $("#barcode").autocomplete({
                source: data.barcodes
            });
        }
    });
}