$(document).ready(function() {
 
	 
	$("#search").on("keyup", function() {
		$("#result").empty();
		if(this.value != ""){
			$.ajax({
				url : "/searchapp/spring/search/" + this.value,
				data : {},
				type : "GET",
				dataType : "json",
				success : function(data) {
					if(data != null){
						$.each(data.agencies, function(i, json) {
							console.log(json);
							$("#result").append(json.name).append("=>" + json.emailId).append("</br>");
						});
						
					}
				},
				error : function(xhr, status) {
					console.log("Sorry, there was a problem!");
				} 
			});
		}
		
	});
	
	
	var oTable = $('#agencyTable').dataTable( {
		"bProcessing": true,
		"sAjaxSource": "/searchapp/spring/listAgencies/",
		"aoColumns": [
						{ "mData": "id" },
						{ "mData": "name" },
						{ "mData": "emailId" }
					]
	} );
	
});