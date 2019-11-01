//$(document).ready(function() {
//	setTimeout(function() {
//		getAllspgposts();
//   }, 1000);
//})

function getAllspgposts() {

	$.ajax({
		type : "GET",
		url : "http://"+location.hostname+":9001/spectergramapp/spgposts",
		success : function(data) {
			
			$.each(data, function(index, spgposts) {
//				console.log(spgposts);
				$('#dynamicContent').append(
						"<h4>" + spgposts.heading + "</h4>" +
						'<li >' + spgposts.place
						+ ", " + spgposts.city + ", " + spgposts.date + ", " + spgposts.name + '</li>' +
						
			"<br>"	+		
	  "<div class='btn-group'>" +
	    "<button type='button' class='btn' style='background-color: dimgray; color: red;' data-toggle='modal' data-target='#exampleModalCenter' onclick = 'showModal(" + spgposts.id +")'>View</button>" +
	    "<button type='button' class='btn' style='background-color: dimgray; color: red;' onclick = 'deletePost(" + spgposts.id +")'>Delete</button>" +
	  	"</div>" + "<br>"
				)

			});
		}
	});
}

function showModal(id) {
	console.log(id);
	let request = new XMLHttpRequest();
	request.open("GET", "http://"+location.hostname+":9001/spectergramapp/spgposts/"+id);

	request.onload = function(){
		let data = JSON.parse(request.response);
		updateModalBox(data);		
	}
	request.send();
}

function updateModalBox(information) {
	console.log("hello");
	let id = document.getElementById("editid");
	id.value = information.id;
	let heading = document.getElementById("editheading");
	heading.value = information.heading;
	let place = document.getElementById("editplace");
	place.value = information.place;
	let city = document.getElementById("editcity");
	city.value = information.city;
	let description = document.getElementById("editdescription");
	description.value = information.description;
	let date = document.getElementById("editdate");
	date.value = information.date;
	let name = document.getElementById("editname");
	name.value = information.name;
}

function savePost() {
	var heading = document.getElementById('heading').value;
	var place = document.getElementById('place').value;
	var city = document.getElementById('city').value;
	var description = document.getElementById('description').value;
	var date = document.getElementById('date').value;
	var name = document.getElementById('name').value;
	var spgposts = new Object();
	spgposts.heading = heading;
	spgposts.place = place;
	spgposts.city = city;
	spgposts.description = description;
	spgposts.date = date;
	spgposts.name = name;
	var spgpostsJSON = JSON.stringify(spgposts);
	
	$.ajax({
		type : "POST",
		url : "http://"+location.hostname+":9001/spectergramapp/spgposts",
		contentType : "application/json",
		data : spgpostsJSON,
		success : function(data) {
			console.log(data);
		},
		error : function(data) {
			console.log(data);
		},
		dataType : 'json'
	});
	location.reload();
}

function deletePost(id){
	$.ajax({
		type : "DELETE",
		url : "http://"+location.hostname+":9001/spectergramapp/spgposts/" +id,
		success : function(data) {

	alert("deleted successfully");
	location.reload();

		}
})
}

function updatePost(){
	var id = document.getElementById('editid').value;
	var heading = document.getElementById('editheading').value;
	var place = document.getElementById('editplace').value;
	var city = document.getElementById('editcity').value;
	var description = document.getElementById('editdescription').value;
	var date = document.getElementById('editdate').value;
	var name = document.getElementById('editname').value;
	var spgposts = new Object();
	spgposts.id = id;
	spgposts.heading = heading;
	spgposts.place = place;
	spgposts.city = city;
	spgposts.description = description;
	spgposts.date = date;
	spgposts.name = name;
	var spgpostsJSON = JSON.stringify(spgposts);

	$.ajax({
		type : "PUT",
		url : "http://"+location.hostname+":9001/spectergramapp/spgposts/",
		contentType : "application/json",
		data : spgpostsJSON,
		success : function(data) {
			console.log(data);
		},
		error : function(data) {
			console.log(data);
		},
		dataType : 'json'
	});
	location.reload();
}