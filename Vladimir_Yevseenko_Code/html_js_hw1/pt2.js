/*
	1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.

*/


function getUSA() {
	domWalk(document.body);
}

function domWalk(node) {
	node = node.firstChild;
	while (node) {
		if (node.innerHTML.includes("USA"))
			console.log(node.innerHTML);
		domWalk(node);
		node = node.nextSibling;
	}
}


window.onload(function() {
		getUSA();
});