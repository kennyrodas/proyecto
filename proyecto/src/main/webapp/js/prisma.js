// Properties
var screenHeight;
var leftbarHeight;
var rightbarHeight;
var resizing = false;
var isIE6 = /MSIE 6./.test(navigator.userAgent);

// Constants
var IMAGE_PATH = "images/";
var ICON_MIN = "min.png";
var ICON_MAX = "max.png";
var ICON_MIN_BAR = "minimizeBtn.png";
var ICON_MAX_BAR = "maximizeBtn.png";
var PANEL_MINIMIZED_HEIGHT = 28;
var PANELS_HEIGHT_DESIGN = 447;


function carga(pagina){
location.href=pagina+".html";
}
function getElementById(id, node, tag){
	if(!node) node = document;
	if(!tag) tag = '*';
	var els = node.getElementsByTagName(tag);
	for(var i=0;i<els.length;i++){
		if(els[i].id == id){
			return els[i];
		}
	}
}
function switchPanel(ref){
	var icon = ref.firstChild;
	var iconSrc = icon.src || icon.style.src;
	iconSrc = iconSrc.split("/").reverse()[0];
	var panel = ref.parentNode;
	while(panel.id != "panel") panel = panel.parentNode;
	var content = getElementById("content", panel, "div");
	
	if(iconSrc == ICON_MIN){ // it's maximized
		if(icon.src){
			icon.src = IMAGE_PATH + ICON_MAX;
		}else{
			icon.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + IMAGE_PATH + ICON_MAX + "', sizingMethod='crop')";
			icon.style.src = IMAGE_PATH + ICON_MAX;
		}
		content.style.display = "none";
		content.$__isOpen = false;
	}else{ // it's minimized
		if(icon.src){
			icon.src = IMAGE_PATH + ICON_MIN;
		}else{
			icon.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + IMAGE_PATH + ICON_MIN + "', sizingMethod='crop')";
			icon.style.src = IMAGE_PATH + ICON_MIN;
		}
		content.style.display = "block";
		content.$__isOpen = true;
	}
	resizeBars();
}
function resizeBars(){
	if(!resizing){
		resizing = true;
		screenHeight = document.documentElement.clientHeight;
		leftbarHeight = (isIE6) ? (screenHeight - 69): ($("leftbar").innerHeight || $("leftbar").clientHeight);
		leftbarHeight -= 4;
		rightbarHeight = (isIE6) ? (screenHeight - 69): ($("rightbar").innerHeight || $("rightbar").clientHeight);
		var leftbarMiniContent = getElementById("content", $("leftbarmini"), "div");

		var leftPanels = getElementsByClass("panelContainer", $("leftbar"), "div");
		var lastOpened;
		var opened = [];
		
		for(var i=0, leftHeights=0;i<leftPanels.length;i++){
			var content = getElementById("content", leftPanels[i], "div");
			if(!content.$__height) content.$__height = content.style.height;
			if(content.$__isOpen == null) content.$__isOpen = true;	
			
			if(content.$__isOpen){
				var h = ( leftbarHeight * parseInt(content.$__height) ) / PANELS_HEIGHT_DESIGN;
				lastOpened = content;
				opened.push(content);
			}else{
				var h = PANEL_MINIMIZED_HEIGHT;
			}
			h = Math.max(PANEL_MINIMIZED_HEIGHT, (Math.round(h) - 36));
			leftHeights += h;
			content.style.height = h + "px";
		}
		if(lastOpened){
			leftHeights -= parseInt(lastOpened.style.height);
			lastOpened.style.height = (leftbarHeight - leftHeights - (opened.length * 36)) + "px";
		}
		
		var rightPanels = getElementsByClass("panelContainer", $("rightbar"), "div");
		lastOpened = null;
		var opened = [];
		for(var i=0, rightHeights=0;i<rightPanels.length;i++){
			var content = getElementById("content", rightPanels[i], "div");
			if(!content.$__height) content.$__height = content.style.height;
			if(content.$__isOpen == null) content.$__isOpen = true;		
			if(content.$__isOpen){
				var h = ( rightbarHeight * parseInt(content.$__height) ) / PANELS_HEIGHT_DESIGN;
				lastOpened = content;
				opened.push(content);
			}else{
				var h = PANEL_MINIMIZED_HEIGHT;
			}
			h = Math.max(PANEL_MINIMIZED_HEIGHT, (Math.round(h) - 36));
			rightHeights += h;
			content.style.height = h + "px";
		}
		if(lastOpened){
			rightHeights -= parseInt(lastOpened.style.height);
			lastOpened.style.height = (rightbarHeight - rightHeights - (opened.length * 36)) + "px";
		}

		// update minimized bar
		leftbarMiniContent.style.height = (rightbarHeight - 36) + "px";
		
		resizing = false;
	}
}
function muestra(nro,plt){
	nu = nro;
	 $("#overlay").css('backgroundColor', "#000000");
	$("#overlay").css('display', "block");
	$("#overlaypanel").css('display', "block");
	$("#overlayalert"+nu).css('display', "block");
	
}
function esconder(nu){
	$("#overlayalert"+nu).css('display', "none");
	if(nu =='1'){
	$("#overlaypanel").css('display', "none");
	$("#overlay").css('display', "none");
	$("#overlay").css('backgroundColor', "");
	}	
}
function validateEmail($email) {
	  var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	  if( !emailReg.test( $email ) ) {
	    return false;
	  } else {
	    return true;
	  }
	}


