$(document).ready(function() {
 
	 
	$("#search").on("keyup", function() {
		$("#result").empty();
		$.ajax({
			url : "/searchapp/spring/search/" + this.value,
			data : {},
			type : "GET",
			dataType : "json",
			success : function(data) {
				if(data != null){
					$.each(data, function(i, json) {
						$("#result").append(json.name).append("</br>");
					});
					
				}
			},
			error : function(xhr, status) {
				console.log("Sorry, there was a problem!");
			} 
		});
	});
});