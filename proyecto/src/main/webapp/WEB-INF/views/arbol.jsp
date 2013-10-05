<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/css.jsp"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
<title>Dynatree - Example</title>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<link href="js/dynatree/skin/ui.dynatree.css" rel="stylesheet"
	type="text/css">
<script src="js/dynatree/jquery.dynatree.js" type="text/javascript"></script>
<link href="js/dynatree/contextmenu/jquery.contextMenu.css"
	rel="stylesheet" type="text/css">

<!-- Start_Exclude: This block is not part of the sample code -->
<!-- End_Exclude -->

<style type="text/css">
ul.dynatree-container {
	overflow: scroll;
	position: relative;
	width: 900px;
	height: 250px;
	white-space: normal;
	*/
}

;
span.dynatree-title {
	white-space: normal;
}

a.metas {
	color: green;
	text-decoration: none;
	font: bold 11px "Lucida Grande", "Trebuchet MS", Verdana, Helvetica,
		sans-serif;
}
</style>

<script type="text/javascript">
var clipboardNode = null;
var pasteMode = null;

function copyPaste(action, node) {
  switch( action ) {
  case "cut":
  case "copy":
    clipboardNode = node;
    pasteMode = action;
    break;
  case "paste":
    if( !clipboardNode ) {
      alert("Clipoard is empty.");
      break;
    }
    if( pasteMode == "cut" ) {
      // Cut mode: check for recursion and remove source
      var isRecursive = false;
      var cb = clipboardNode.toDict(true, function(dict){
        // If one of the source nodes is the target, we must not move
        if( dict.key == node.data.key )
          isRecursive = true;
      });
      if( isRecursive ) {
        alert("Cannot move a node to a sub node.");
        return;
      }
      node.addChild(cb);
      clipboardNode.remove();
    } else {
      // Copy mode: prevent duplicate keys:
      var cb = clipboardNode.toDict(true, function(dict){
        dict.title = "Copy of " + dict.title;
        delete dict.key; // Remove key, so a new one will be created
      });
      node.addChild(cb);
    }
    clipboardNode = pasteMode = null;
    break;
  default:
    alert("Unhandled clipboard action '" + action + "'");
  }
};

//--- Contextmenu helper --------------------------------------------------
function bindContextMenu(span) {
	var tipo = span.className ;
	//alert(tipo.search("dynatree-folder"));
	if(tipo.search("dynatree-folder") != -1){
		$(span).contextMenu({menu: "myMenu"}, function(action, el, pos) {
		    // The event was bound to the <span> tag, but the node object
		    // is stored in the parent <li> tag
		    var node = $.ui.dynatree.getNode(el);
		    switch( action ) {
		    case "cut":
		    case "copy":
		    case "paste":
		      copyPaste(action, node);
		      break;
		    default:
		      alert("Todo: appply action '" + action + "' to node " + node);
		    }
		  });
	}else{
		$(span).contextMenu({menu: "myMenu2"}, function(action, el, pos) {
		    // The event was bound to the <span> tag, but the node object
		    // is stored in the parent <li> tag
		    var node = $.ui.dynatree.getNode(el);
		    switch( action ) {
		    case "cut":
		    case "copy":
		    case "paste":
		      copyPaste(action, node);
		      break;
		    default:
		      alert("Todo: appply action '" + action + "' to node " + node);
		    }
		  });
	}
  // Add context menu to this node:
  
};

var data1 = [
 {"title": "Item 1"},
 {"title": "Folder 2", "isFolder": true, "key": "folder2",
     "children": [
         {"title": "Sub-item 2.1"},
			{"title": "Sub-item 2.2"}
			]
     },
	{"title": "Folder 3", "isFolder": true, "key": "folder3",
	    "children": [
		    {"title": "Sub-item 3.1"},
		    {"title": "Sub-item 3.2"}
		    ]
		},
	{"title": "Item 5"}
];
var data2 = [ {"title": "SubItem 1", "isLazy": true }, 	{"title": "SubFolder 2", "isFolder": true, "isLazy": true } ];
var json;


$(function(){
	 $(document).on("click",'.metas', function(){
		// $("#metas").load(this.href).dialog({modal:true}); 
		 $("#agregar").dialog({modal:true, width: 600}); 
		  });
	$.ajax({
	    type: "POST",
	    url: "/proyecto/getNodes.htm",	    
	    success: function(response){
	    	json= jQuery.parseJSON(response);
	    },
	    error: function(e){
		    alert('Error: ' + e.type);

	    }
	  });
	
});
function Agrega(){
	 var rootNode = $("#tree").dynatree("getTree").getNodeByKey("2");
	 var childNode = rootNode.addChild({
	        title: "Nueva",
	        tooltip: "This child node was added programmatically.",
	        isFolder: false
	    });

}
function cargarjson(){
	$("#tree").dynatree({
		noLink: true,
		children:json,		
		onLazyRead: function(node){
			// Mockup a slow reqeuest ...
			node.appendAjax({
				url: "sample-data1.json",
				debugLazyDelay: 750 // don't do this in production code
			});
		},
		onClick: function(node, event) {
			if( $(".contextMenu:visible").length > 0 ){
		          $(".contextMenu").hide();
//		          return false;
		        }

	    },
	    onCreate: function(node, span){
	        bindContextMenu(span);
	    },

		dnd: {
			onDragStart: function(node) {
				/** This function MUST be defined to enable dragging for the tree.
				 *  Return false to cancel dragging of node.
				 */
				return true;
			},
			onDragStop: function(node) {
				// This function is optional.
				//alert(node);
			},
			autoExpandMS: 1000,
			preventVoidMoves: true, // Prevent dropping nodes 'before self', etc.
			onDragEnter: function(node, sourceNode) {
				/** sourceNode may be null for non-dynatree droppables.
				 *  Return false to disallow dropping on node. In this case
				 *  onDragOver and onDragLeave are not called.
				 *  Return 'over', 'before, 	or 'after' to force a hitMode.
				 *  Return ['before', 'after'] to restrict available hitModes.
				 *  Any other return value will calc the hitMode from the cursor position.
				 */
				//logMsg("tree.onDragEnter(%o, %o)", node, sourceNode);
				return true;
			},
			onDragOver: function(node, sourceNode, hitMode) {
				/** Return false to disallow dropping this node.
				 *
				 */
				//logMsg("tree.onDragOver(%o, %o, %o)", node, sourceNode, hitMode);
				// Prevent dropping a parent below it's own child
				if(node.isDescendantOf(sourceNode)){
					return false;
				}
				// Prohibit creating childs in non-folders (only sorting allowed)
				if( !node.data.isFolder && hitMode === "over" ){
					return "after";
				}
			},
			onDrop: function(node, sourceNode, hitMode, ui, draggable) {
				/** This function MUST be defined to enable dropping of items on
				 * the tree.
				 */
				//logMsg("tree.onDrop(%o, %o, %s)", node, sourceNode, hitMode);
				sourceNode.move(node, hitMode);
				// expand the drop target
//				sourceNode.expand(true);
			},
			onDragLeave: function(node, sourceNode) {
				/** Always called if onDragEnter was called.
				 */
				//logMsg("tree.onDragLeave(%o, %o)", node, sourceNode);
			}
		}
	});
}
</script>
</head>

<body>
	<!-- Definition of context menu -->
	<ul id="myMenu" class="contextMenu">
		<li class="edit"><a href="#edit">Edit</a></li>
		<li class="cut separator"><a href="#cut">Cut</a></li>
		<li class="copy"><a href="#copy">Copy</a></li>
		<li class="paste"><a href="#paste">Paste</a></li>
		<li class="delete"><a href="#delete">Delete</a></li>
		<li class="quit separator"><a href="#quit">Quit</a></li>
	</ul>
	<ul id="myMenu2" class="contextMenu">
		<li class="edit"><a href="#edit">Edit2</a></li>
		<li class="cut separator"><a href="#cut">Cut2</a></li>
		<li class="copy"><a href="#copy">Copy2</a></li>
		<li class="paste"><a href="#paste">Paste2</a></li>
		<li class="delete"><a href="#delete">Delete2</a></li>
		<li class="quit separator"><a href="#quit">Quit2</a></li>
	</ul>

	<div id="metas"></div>
	<input type="hidden" value="1" name="id">
	<input type="button" name="probar" onclick="cargarjson()" value="R1" />
	<div id="tree"></div>
	<div id="agregar" style="display: none">
		<table>
			<tbody>
				<tr>
					<td width="80"><span class="texto">Código:</span></td>
					<td width="90"><input class="campotexto" id="codigo" size="10"
						maxlength="10" tabindex="1" value="1.1.12" readonly="" type="text"></td>
					<td width="80"><span class="texto">Nombre:</span></td>
					<td><input id="nombre" class="campotexto" size="50"
						maxlength="350" tabindex="2" type="text"></td>
				</tr>
				<tr>
					<td colspan="3"><span class="texto">Ingresa indicadores
							a este nivel:</span></td>
					<td><select id="esactividad" class="campolista"
						style="WIDTH: 80px" tabindex="1">
							<option value="0" selected="">Elija...</option>
							<option value="1">Si</option>
							<option value="2">No</option>
					</select></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>