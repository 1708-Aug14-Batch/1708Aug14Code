var counter = 0;

function handler(event) {
    event.stopPropagation();
    console.log("%s--%s", event.currentTarget, counter++);
}

function drop(event) {
    event.preventDefault();
    var data = event.dataTransfer.getData("text");
    var targId = event.target.id;
    console.log("Parent Node: (dgebi)"+this.id+" New Node: (dgebi)"+data+" Reference Node: (dgebi)"+targId);
    document.getElementById(this.id).insertBefore(document.getElementById(data),document.getElementById(targId));
}

function drag(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}


window.onload = function() {
    document.getElementById("sidebarlocations").addEventListener("click", handler, false);
    document.getElementById("ch1locations").addEventListener("click", handler, false);
    document.getElementById("ch2locations").addEventListener("click", handler, false);
    
    document.getElementById("sidebarlocations").addEventListener("drop", drop, false);
    document.getElementById("ch1locations").addEventListener("drop", drop, false);
    document.getElementById("ch2locations").addEventListener("drop", drop, false);
    
    document.getElementById("sidebarlocations").addEventListener("dragover", allowDrop, false);
    document.getElementById("ch1locations").addEventListener("dragover", allowDrop, false);
    document.getElementById("ch2locations").addEventListener("dragover", allowDrop, false);
    
    document.getElementById("sidebarlocations").addEventListener("dragstart", drag, false);
    document.getElementById("ch1locations").addEventListener("dragstart", drag, false);
    document.getElementById("ch2locations").addEventListener("dragstart", drag, false);
}