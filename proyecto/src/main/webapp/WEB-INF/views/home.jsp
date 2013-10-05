<%@page import="com.kenny.app.domain.Usuario"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<p>
		<c:out value="${usersess}" />
		<%-- 
    <% HttpSession session=request.getSession();
       Usuario usu=(Usuario)session.getAttribute("usuario"); 
    %>
    <%= usu.getNombre()%> --%>
	</p>
	<h3>Usuarios</h3>

	<table>
		<tr>
			<th>id</th>
			<th>usuario</th>
			<th>clave</th>
			<th>usuariotipo</th>
			<th>nombre</th>
			<th>apellido</th>
			<th>razonsoc</th>
			<th>emptipo</th>
			<th>empsector</th>
			<th>emprepresent</th>
			<th>doctipo</th>
			<th>docnum</th>
			<th>pais</th>
			<th>telefono</th>
			<th>correo</th>
			<th>trabdir</th>
			<th>trabcargo</th>
		</tr>
		<c:forEach items="${requestScope.usuarios}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.usuario}" /></td>
				<td><c:out value="${user.clave}" /></td>
				<td><c:out value="${user.usuariotipo}" /></td>
				<td><c:out value="${user.nombre}" /></td>
				<td><c:out value="${user.apellido}" /></td>
				<td><c:out value="${user.razonsoc}" /></td>
				<td><c:out value="${user.emptipo}" /></td>
				<td><c:out value="${user.empsector}" /></td>
				<td><c:out value="${user.emprepresent}" /></td>
				<td><c:out value="${user.doctipo}" /></td>
				<td><c:out value="${user.docnum}" /></td>
				<td><c:out value="${user.pais}" /></td>
				<td><c:out value="${user.telefono}" /></td>
				<td><c:out value="${user.correo}" /></td>
				<td><c:out value="${user.trabdir}" /></td>
				<td><c:out value="${user.trabcargo}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="<c:url value="registrarusuario.htm"/>">Registrar Usuario</a>
	<br>
	<a href="<c:url value="salir.htm"/>">Salir</a>
</body>
</html>