function getData() {
	$.ajax({
		url: config.API_URL + "/products",
		type: "GET",
		dataType: "json",
		success: function (data) {
			console.log(data);
			$.each(data, function (index) {
                appendProductToTable(data[index])
			});
		}
	});
}

$(document).ready(function() {
    getData();
});


function onClickAddProduct(){
    // $("#addProduct").toggleClass("visible");
    // $("#addProduct").toggleClass("hidden");

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
    // $.ajax({
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'application/json'
    //     },
    //     url: config.API_URL + "/products",
    //     type: "POST",
    //     dataType: "json",
    //     data:JSON.stringify(product),
    //     contentType: "application/json",
    //     success: function (resultData) {
    //         console.log("success");
    //         appendProductToTable(product);
    //     }
    // });
    $.ajax({
        method: 'POST',
        data: JSON.stringify(product),
        url: config.API_URL + '/products',
        contentType: 'application/json',
        success: function (response) {
            appendProductToTable(response)
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