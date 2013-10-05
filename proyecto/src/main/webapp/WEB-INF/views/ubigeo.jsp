<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="control-group">
	<label class="control-label">Region:</label>
	<div class="controls">
		<select name="region_id" id="region_id" onChange="loadUbigeo()"
			class="span6">
			<option value="0">Todas</option>
			<c:forEach items="${model.regiones}" var="region">
				<option value="<c:out value="${region.regionId}"/>"><c:out
						value="${region.nombre}" /></option>
			</c:forEach>
		</select>
	</div>
</div>
<c:if test="${not empty model.provincias}">
	<div class="control-group">
		<label class="control-label">Provincia:</label>
		<div class="controls">
			<select name="provincia_id" id="provincia_id" onChange="loadUbigeo()"
				class="span6">
				<option value="0">Todas</option>
				<c:forEach items="${model.provincias}" var="prov">
					<option value="<c:out value="${prov.provinciaId}" />"><c:out
							value="${prov.nombre}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
</c:if>
<c:if test="${not empty model.distritos}">
	<div class="control-group">
		<label class="control-label">Distritos:</label>
		<div class="controls">
			<select name="distrito_id" id="distrito_id" onChange="loadUbigeo()"
				class="span6">
				<option value="0">Todas</option>
				<c:forEach items="${model.distritos}" var="distrito">
					<option value="<c:out value="${distrito.distritoId}"/>"><c:out
							value="${distrito.nombre}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
</c:if>
<c:if test="${not empty model.comunidades}">
	<div class="control-group">
		<label class="control-label">Comunidades:</label>
		<div class="controls">
			<select name="comunidad_id" id="comunidad_id" multiple="multiple"
				class="span6">
				<option value="0">Todas</option>
				<c:forEach items="${model.comunidades}" var="comunidad">
					<option value="<c:out value="${comunidad.comunidadId}"/>"><c:out
							value="${comunidad.nombre}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
</c:if>
<div class="control-group">
	<input type="button" value="agregar" name="agregarRegion"
		onClick="agregarUbigeo();" class="btn btn-primary" />
</div>