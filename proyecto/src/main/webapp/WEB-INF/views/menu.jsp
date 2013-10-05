<%@page import="com.kenny.app.domain.Usuario"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%-- 
 <% HttpSession session=request.getSession();
       Usuario usu=(Usuario)session.getAttribute("usuario"); 
       if(usu != null){
    %>  --%>
<!-- BEGIN Navbar -->
<div id="navbar" class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<!-- BEGIN Brand -->
			<a href="#" class="brand"> <small> <i
					class="icon-desktop"></i> GID Sistema de Monitoreo de Proyectos
			</small>
			</a>
			<!-- END Brand -->

			<!-- BEGIN Responsive Sidebar Collapse -->
			<a href="#" class="btn-navbar collapsed" data-toggle="collapse"
				data-target=".nav-collapse"> <i class="icon-reorder"></i>
			</a>
			<!-- END Responsive Sidebar Collapse -->

			<!-- BEGIN Navbar Buttons -->
			<ul class="nav flaty-nav pull-right">
				<!-- BEGIN Button User -->
				<li class="user-profile"><a data-toggle="dropdown" href="#"
					class="user-menu dropdown-toggle"> <img class="nav-user-photo"
						src="img/demo/avatar/avatar1.jpg" alt="Penny's Photo" /> <span
						class="hidden-phone" id="user_info"> <%--   <%= usu.getNombre()%>  --%>
					</span> <i class="icon-caret-down"></i>
				</a> <!-- BEGIN User Dropdown -->
					<ul class="dropdown-menu dropdown-navbar" id="user_menu">
						<li><a href="#"> <i class="icon-cog"></i> Account
								Settings
						</a></li>

						<li><a href="#"> <i class="icon-user"></i> Edit Profile
						</a></li>

						<li class="divider visible-phone"></li>

						<li class="visible-phone"><a href="#"> <i
								class="icon-tasks"></i> Tasks <span class="badge badge-warning">4</span>
						</a></li>
						<li class="visible-phone"><a href="#"> <i
								class="icon-bell-alt"></i> Notifications <span
								class="badge badge-important">8</span>
						</a></li>
						<li class="visible-phone"><a href="#"> <i
								class="icon-envelope"></i> Messages <span
								class="badge badge-success">5</span>
						</a></li>

						<li class="divider"></li>

						<li><a href="salir.htm"> <i class="icon-off"></i> Logout
						</a></li>
					</ul> <!-- BEGIN User Dropdown --></li>
				<!-- END Button User -->
			</ul>
			<!-- END Navbar Buttons -->
		</div>
		<!--/.container-fluid-->
	</div>
	<!--/.navbar-inner-->
</div>
<!-- END Navbar -->
<!-- BEGIN Container -->
<div class="container-fluid" id="main-container">
	<!-- BEGIN Sidebar -->
	<div id="sidebar" class="nav-collapse">
		<!-- BEGIN Navlist -->
		<ul class="nav nav-list">
			<li><a href="usuarios.htm"> <i class="icon-file"></i> <span>Mis
						usuarios</span>
			</a></li>
			<li><a href="inicio.htm"> <i class="icon-tasks"></i> <span>Mis
						Proyectos</span>
			</a></li>
			<li><a href="#"> <i class="icon-envelope"></i> <span>Mensajeria</span>
			</a></li>
			<%--                     <% if(usu.getPadreId() == 0){ %>
 --%>
			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-desktop"></i> <span>Acceso Directo</span> <b
					class="arrow icon-angle-right"></b>
			</a> <!-- BEGIN Submenu -->
				<ul class="submenu">
					<li><a href="nuevoproyecto.htm">Crear nuevo proyecto</a></li>
					<li><a href="nuevousuario.htm">Nuevo Usuario</a></li>
				</ul> <!-- END Submenu --></li>
			<%-- <% } %>
                    
                <% } %> --%>
			<!--             </div> -->