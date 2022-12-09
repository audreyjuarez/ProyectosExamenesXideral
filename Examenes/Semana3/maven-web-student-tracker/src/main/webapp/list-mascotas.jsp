<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Veterinaria Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Veterinaria Luffy</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Mascota -->
			
			<input type="button" value="Add Mascota" 
				   onclick="window.location.href='add-mascota-form.html'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre Mascota</th>
					<th>Nombre Dueño</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempMascota" items="${LISTA_MASCOTAS}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="MascotaControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="mascotaId" value="${tempMascota.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="MascotaControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="mascotaId" value="${tempMascota.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempMascota.firstName} </td>
						<td> ${tempMascota.lastName} </td>
						<td> ${tempMascota.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this mascota?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








