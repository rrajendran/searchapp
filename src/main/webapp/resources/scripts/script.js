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
						$.each(data, function(i, json) {
							$("#result").append(json.firstName).append("=>" + json.lastName).append("</br>");
						});
						
					}
				},
				error : function(xhr, status) {
					console.log("Sorry, there was a problem!");
				} 
			});
		}
		
	});
});