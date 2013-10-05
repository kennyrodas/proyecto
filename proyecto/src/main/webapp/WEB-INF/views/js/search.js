// funcitoncom - Mayo 2007

var ACTION_FULLSCREEN = '1';
var ACTION_PANEL = '2';
var ACTION_SEARCH = '3';
var ACTION_NORESULT = '4';
var SESSION_ERROR = '5';
var ACTION_MAININFO = '6';
var SINIESTRO_SALUTIA = '7';
var PERFIL_SOAT = '8';

/* VARIABLES PARA ACCESO A WEB DE PROCURACIONES */
var svns = "http://schemas.xmlsoap.org/soap/envelope/";
//var wsdl_uri = "http://extranet.legall.com.pe/services/ProcServInt.php";
//var wsdl_uri = "http://extranet.legall.com.pe/ProcuracionesNuevo/services/ProcServInt.php";
var wsdl_uri = "http://10.0.0.176/fuentes_integrado/ProcuracionesNuevo/services/ProcServInt.php";
var wsdl_namespace = "urn:ProcServInt";
var pending = false;
/* FIN DE ACCESO A VARIABLES PARA ACCESO A WEB DE PROCURACIONES */

var ajaxHandlers = {
	onCreate: function(){
		showPreloader();
		pending = true;
	},	
	onComplete: function(){
		hidePreloader();
		pending = false;
	}
}

function showPreloader(){
	$("overlay").style.display = "block";
	$("preloader").style.display = "block";
	hideSelectBoxes();
}

function hidePreloader(){
	$("preloader").style.display = "none";
}	

Ajax.Responders.register(ajaxHandlers);

function sendAlert(message){
	$("overlay").style.display = "block";
	$("overlayalert").style.display = "block";
	$("alertmessage").innerHTML = message;
	hideSelectBoxes();
}

function hideAlert(){
	$("overlay").style.display = "none";
	$("alertmessage").inneHTML = "";
	$("overlayalert").style.display = "";
	showSelectBoxes();
}

function showSelectBoxes(){
	var selects = document.getElementsByTagName("select");
	for(var x=0;x<selects.length;x++){
		selects[x].style.visibility = "visible";
	}
}

function hideSelectBoxes(){
	var selects = document.getElementsByTagName("select");
	for(var x=0;x<selects.length;x++){
		selects[x].style.visibility = "hidden";
	}
}

function init(){
	Event.observe("searchTypes", 'change', onSearchTypeChanged, false);
}

function onSearchTypeChanged(e){
	var value = Number($("searchTypes").value);
	var labels = ["Ingrese la placa a buscar:",
			 		"Ingrese el numero PVS a buscar:",
					"Ingrese el siniestro a buscar:",
			 		"Ingrese el motor a buscar:",
				  	"Ingrese el asegurado a buscar:",
				  	"Ingrese la p&oacute;liza a buscar:",
				  	"Ingrese el rango de fechas a buscar:"];
	var label = labels[(value - 1)] || "";
	$("searchLabel").innerHTML = label;
	$("searchTerm").style.display = (label != "" && value != 7) ? "block": "none";
	$("searchDateTerm").style.display = (value == 7) ? "block": "none";
	$("searchTerm").value = $("dateOne").value = $("dateTwo").value = "";
	//alert(value);
}

function doSearch(){
	var value = Number($F("searchTypes"));
	var searchTerm = $F("searchTerm");
	var dateOne = $F("dateOne");
	var dateOneA = dateOne.split("-");
	var dateOneV = new Date(dateOneA[0], dateOneA[1], dateOne[2]);
	var dateTwo = $F("dateTwo");
	var dateTwoA = dateTwo.split("-");
	var dateTwoA = new Date(dateTwoA[0], dateTwoA[1], dateTwoA[2]);
	var tipo = $("searchTypes").selectedIndex + 1;	
	
	if(value == -1){
		//sendAlert("Debe seleccionar una opci&oacute;n de b&uacute;squeda");
		alert("Debe seleccionar una opcion de busqueda");
	}else if(!searchTerm.length && (!dateOne.length || !dateTwo.length)){
		//sendAlert("Por favor ingrese una b&uacute;squeda");
		alert("Por favor ingrese una busqueda");
	}else if(dateOneV.getTime() > dateTwoA.getTime()){
		//sendAlert("La primera fecha debe ser menor a la segunda");
		alert("La primera fecha debe ser menor a la segunda");
	}else{
		if((perfil==3 || perfil==1) || (tipo==5 || tipo==7)){ // Perfil Soat, Evento y (Asegurado y Fechas de Vehicular)
			form = $("search");
			params = {method: 'post',
					 postBody:Form.serialize(form)+"&fname=BuscaEvento&token="+__32x1+"&pag=1",
					 onSuccess: onSuccess,
					 onFailure: onFailure};
			new Ajax.Request("services.php", params);
		}else if(perfil==2){    //Perfil vehicular todas las busquedas menos (Asegurado y Fechas)
			soapCall('searchEvent', {authtoken: __32x1, value: searchTerm, fec1: dateOne, fec2: dateTwo, type: tipo});
		}
	}
}

function launchConsole(evento,tipo,placa){
	//alert('entro a mi launchconsole. Evento :'+evento+' tipo : '+tipo);
	hideFloatingPanel();
	params = {method: 'post',
				 postBody:"searchTerm="+evento+"&fname=verEvento&token="+__32x1+"&tipo="+tipo+"&placa="+placa,
				 onSuccess: onSuccess,
				 onFailure: onFailure};
	new Ajax.Request("services.php", params);
	hideSelectBoxes();
}


function hideSearchResults(){
	$("searchTypes").selectedIndex = 0;
	if($("searchTerm")) $("searchTerm").disabled = false;
	if($("send")) $("send").disabled = false;
	onSearchTypeChanged();
	hideFloatingPanel();
	showSelectBoxes();
}

/* .mm. modificado 10 Ago 07 */

function hideFloatingPanel(){
	$("overlay").style.display = "none";
	$("overlaypanel").style.display = "none";
	$("overlaysearchpanel").style.display = "none";
	//$("maininfo").style.display = "none"; 
	var daContent = getElementById("content", $("overlaypanel"), "div");
	daContent.innerHTML = "";
	//showSelectBoxes();
}

function onSuccess(req){
	json = eval("("+req.responseText+")");
	//alert(json.type);
	//alert(json.tpl);
	var type = json.type + '';
	var searchContainer = $("search");
	var consoleContainer = $("console");
	if(type == ACTION_SEARCH){
		launchSearchPanel(json.tpl);
	}else if(type == ACTION_FULLSCREEN){
		searchContainer.style.display = "none";
		consoleContainer.style.display = "block";
		$("overlay").style.display = "none";
		consoleContainer.innerHTML = json.tpl;
		initConsole();		
		Event.observe(window, 'resize', resizeBars, false);
	}else if(type == ACTION_NORESULT){
		//sendAlert(tpl);
		alert(json.tpl);
		$("preloader").style.display = "none";
		if($("console").innerHTML.length > 0){
			$("overlay").style.display = "none";		
			$("console").style.display = 'block';
		}
		else if($("overlaysearchpanel").innerHTML.length > 0){
			$("overlay").style.display = "block";		
			$("overlaysearchpanel").style.display = 'block';
		}
		else{ 
			$("overlay").style.display = "none";		
			showSelectBoxes();
		}
	}else if(type == ACTION_PANEL){
		launchPanelContent(json.title, json.tpl);
	}else if(type == SESSION_ERROR){
		alert('Error de Sesion, por favor inicie sesion nuevamente.');
		window.location.reload();
	}else if(type == ACTION_MAININFO){
		//alert("vino json.type= "+json.type);
		consoleContainer.style.display = "none";
		launch_maininfo(json.tpl);
	}else	if(type == SINIESTRO_SALUTIA){
		//alert("entro a salutia");
		$("rightbar_sa").innerHTML = json.tpl;
		$("overlay").style.display = "none";
		$("overlaypanel").style.display = "none";
	}else if(type == PERFIL_SOAT){
		$("overlay").style.display = "none";
		$("overlaypanel").style.display = "none";
		$("console").innerHTML = json.evento;
		$("console").style.display = 'block';
		$("overlaysearchpanel").innerHTML = json.tpl;
		initConsole();		
	}else{
		alert("Error en la recepcion de datos");
		$("overlay").style.display = "none";
		$("preloader").style.display = "none";
	}
}

function launchSearchPanel(tpl){
	$("overlay").style.display = "block";
	$("overlaysearchpanel").style.display = "block";
	var daContent = $("overlaysearchpanel");
	daContent.innerHTML = tpl;
	if($("searchTerm")) $("searchTerm").disabled = true;
	if($("send")) $("send").disabled = true;
}

function launchPanel(tpl){
	$("overlay").style.display = "block";
	$("overlaypanel").style.display = "block";
	var daContent = getElementById("content", $("overlaypanel"), "div");
	daContent.innerHTML = tpl;
	//if(fixPNG) fixPNG();
}

function launchPanelContent(title, ref){
	var tpl;
	if(typeof(ref) != "string"){
		var parent = ref.parentNode;
		while(parent.id != "panel") parent = parent.parentNode;
		var content = getElementById("content", parent, "div");
		tpl = content.innerHTML;
	}else{
		tpl = ref;
	}
	var titlecontainer = getElementById("paneltitle", $("overlaypanel"), "div");
	titlecontainer.innerHTML = title;
	launchPanel(tpl);
}

function nodeValue(xmlTag){
	var content;
	if(xmlTag.firstChild.textContent && xmlTag.normalize){
		xmlTag.normalize(xmlTag.firstChild);
		content = xmlTag.firstChild.textContent;
	}else if(xmlTag.firstChild.nodeValue){
		content = xmlTag.firstChild.nodeValue;
	}else{
		content = null;
	}
	return content;
}

function onFailure(e){
	sendAlert("Error: "+e.status+" "+e.statusText);
	hideSelectBoxes();
}

function escapeSoapParams(params){
	if(typeof(params) != "object"){
		return params.toString().replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
	}
	var res = "";
	for(var i in params) res += "<" + i + ">" + escapeSoapParams(params[i]) + "</" + i + ">";
	return res;
}

Event.observe(window, 'load', init, false);

/******  .mm. funciones agregadas 9 Ago 2007 ******/

function verReporte(reporte){
	params = {method: 'post',
				 postBody:"searchTerm="+reporte+"&fname=verReporte&token="+__32x1,
				 onSuccess: onSuccess,
				 onFailure: onFailure};
	new Ajax.Request("services.php", params);
		
}

function verResultadosBusqueda(){
	if( $("overlaysearchpanel").innerHTML.length > 0){
		$("overlay").style.display = "block";
		$("overlaysearchpanel").style.display = "block";
		if($("searchTerm")) $("searchTerm").disabled = true;
		if($("send")) $("send").disabled = true;
		$("console").style.display = "none";
		$("maininfo").style.display = "none";
	} else {
		window.location = "";
	}
}

/* INICIO ACCESO A WEB PROCURACIONES */
function soapCall(function_name, params){
	if(!pending){
		var soapBody = '<?xml version="1.0" encoding="utf-8"?><s:Envelope xmlns:s="'+svns+'"'+
					   ' xmlns:n="'+wsdl_namespace+'">'+
					   '<s:Body><n:'+function_name+'>'
							+ escapeSoapParams(params)
							+ '</n:'+function_name+'></s:Body>'+
					   '</s:Envelope>';
		params = {method: 'post', contentType: "text/xml", postBody: soapBody, onSuccess: Callback, onFailure: onFailure};
		new Ajax.Request(wsdl_uri, params);
	}
}

/* el OnSuccess de procuraciones */
function Callback(req, json){
	//alert("entro a CallBack");
	//alert(req.responseText);
	var searchContainer = $("search");
	var consoleContainer = $("console");
	var type = Number(nodeValue(req.responseXML.documentElement.getElementsByTagName("type")[0]));
 	//alert("type: "+type);
	type = type + '';
	var tpl = nodeValue(req.responseXML.documentElement.getElementsByTagName("tpl")[0]);
	if(type == ACTION_FULLSCREEN){
		launch_maininfo(tpl);
		hideFloatingPanel();
		$("console").style.display = "none";
	}else	if(type == ACTION_PANEL){ 
		var title = nodeValue(req.responseXML.documentElement.getElementsByTagName("title")[0]);
		launchPanelContent(title,tpl);
	}else	if(type == SESSION_ERROR){
		alert("Error de Sesion, vuelva a iniciar Sesion por favor.");
		window.location.reload();
	}else	if(type == ACTION_NORESULT){
		//sendAlert(tpl);
		alert(tpl);
		$("preloader").style.display = "none";
		if($("console").innerHTML.length > 0){
			$("overlay").style.display = "none";		
			$("console").style.display = 'block';
		}
		else if($("overlaysearchpanel").innerHTML.length > 0){
			$("overlay").style.display = "block";		
			$("overlaysearchpanel").style.display = 'block';
		}
		else{ 
			$("overlay").style.display = "none";		
			showSelectBoxes();
		}
	}else{
		alert("Error en la recepcion de datos");
		$("overlay").style.display = "none";
		$("preloader").style.display = "none";
	}
}
/* FIN DE ACCESO A WEB DE PROCURACIONES */

/* FUNCION QUE DECIDE SI CONSULTA A SALUTIA O A PROCURACIONES */
function show_maininfo(siniestro,flag,tipo){
	hideFloatingPanel();
	if(flag=='1'){ //PROCURACIONES --
		soapCall('viewEvent', {authtoken: __32x1, id_siniestro: siniestro, type: tipo});
	}else if(flag=='2'){ //SALUTIA
		params = {method: 'post',
					 postBody:"siniestro="+siniestro+"&fname=BuscaSiniestro&token="+__32x1+"&tipo="+tipo,
					 onSuccess: onSuccess,
					 onFailure: onFailure};
		new Ajax.Request("services.php", params);
	}
	hideSelectBoxes("console");
}

function launch_maininfo(tpl){
	$("maininfo").style.display = "block";
	$("maininfo").innerHTML = tpl;
	$("overlay").style.display = "none";
	$("overlaypanel").style.display = "none";
}

function regresoEvento(){
	$("maininfo").innerHTML = "";
	$("overlay").style.display = "none";
	$("maininfo").style.display = "none";
	$("console").style.display = "block";
}

function BuscaInformeSal(informe,flag){
	params = {method: 'post',
				 postBody:"informe="+informe+"&fname=BuscaInformeSal&token="+__32x1+"&flag="+flag,
				 onSuccess: onSuccess,
				 onFailure: onFailure};
	new Ajax.Request("services.php", params);
}