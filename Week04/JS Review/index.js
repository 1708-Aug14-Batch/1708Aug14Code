
var counter = 0;

function handler(event) {
	event.stopPropagation();
	console.log("%s--%s", event.currentTarget, counter++);
}

function drop(event) {
	event.preventDefault();
	var data = event.dataTransfer.getData("text");
	event.target.insertBefore(document.getElementById(data), event.target.firstChild);
}

function drag(event) {
	event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
	event.preventDefault();
}

window.onload = function() {
	document.getElementById("outer").addEventListener("click", handler, false);
	document.getElementById("inner").addEventListener("click", handler, false);
	document.getElementById("innermost").addEventListener("click", handler, false);
	
	document.getElementById("outer").addEventListener("drop", drop, false);
	document.getElementById("inner").addEventListener("drop", drop, false);
	document.getElementById("innermost").addEventListener("drop", drop, false);
	
	document.getElementById("outer").addEventListener("dragover", allowDrop, false);
	document.getElementById("inner").addEventListener("dragover", allowDrop, false);
	document.getElementById("innermost").addEventListener("dragover", allowDrop, false);
	
	document.getElementById("outer").addEventListener("dragstart", drag, false);
	document.getElementById("inner").addEventListener("dragstart", drag, false);
	document.getElementById("innermost").addEventListener("dragstart", drag, false);
}