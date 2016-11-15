function getData() {
	$.ajax({
		url: config.API_URL + "/products",
		type: "GET",
		dataType: "json",
		success: function(data) {
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append('<td>' + data[index].id + '</td>');
				tr.append('<td>' + data[index].name + '</td>');
				tr.append('<td>' + data[index].expiryDate + '</td>');
				tr.append('<td>' + data[index].quantity + '</td>');
				tr.append('<td>' + data[index].price + '</td>');
				tr.append('<td>' + data[index].provider + '</td>');
				tr.append('<td>' + data[index].department + '</td>');
				tr.append('<td>' + data[index].barcode + '</td>');
				tr.append('</tr>');
				$('#productsTable').append(tr);
			});
		}
	});


$(document).ready(function() {
    getData();
});