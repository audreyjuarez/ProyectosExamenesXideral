<!DOCTYPE html>
<html>

<head>
	<title>Update Mascota</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Veterinaria Luffy</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Mascota</h3>
		
		<form action="MascotaControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="mascotaId" value="${THE_MASCOTA.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre Mascota:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_MASCOTA.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Nombre Dueño:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_MASCOTA.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_MASCOTA.email}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="MascotaControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











