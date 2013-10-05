<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/inc.header.jsp"%>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<li><a href="#" class="dropdown-toggle"> <i
		class="icon-desktop"></i> <span>Detalles del Proyecto</span> <b
		class="arrow icon-angle-right"></b>
</a> <!-- BEGIN Submenu -->
	<ul class="submenu">
		<li><a
			href="detalles_proyecto.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Informaci&oacute;n</a></li>
		<li><a
			href="arbol.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Actividades</a></li>
		<li><a
			href="ingresodirecto.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Ingreso
				Directo</a></li>
		<li><a
			href="participantes.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Ficha
				de Participantes</a></li>
		<li><a
			href="reportes.htm<c:out value="?id=${model.proyecto.proyectoId}"/>">Reporte</a></li>

	</ul> <!-- END Submenu --></li>
</ul>
<!-- END Navlist -->
</div>
<!-- END Sidebar -->
</div>
<!-- BEGIN Content -->
<div id="main-content">
	<div class="row"></div>
</div>
<%@ include file="/WEB-INF/views/inc.footer.jsp"%>
