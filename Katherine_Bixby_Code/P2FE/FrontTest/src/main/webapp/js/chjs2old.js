var counter = 0;

function handler(event) {
    event.stopPropagation();
    console.log("%s--%s", event.currentTarget, counter++);
}

function drop(event) {
    event.preventDefault();
    var data = event.dataTransfer.getData("text");
    var targId = event.target.parentNode.id;
    var targeting = this.parentNode;
    console.log("parentNode: "+targeting.parentNode.id);
    console.log("What to place: "+data);
    console.log("What to place it before: "+targId);
    document.getElementById(this.id).insertBefore(document.getElementById(data),document.getElementById(targId));
}

function drag(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}


window.onload = function() {
    document.getElementById("chapter1").addEventListener("click", handler, false);
    document.getElementById("chapter2").addEventListener("click", handler, false);
    
    document.getElementById("chapter1").addEventListener("drop", drop, false);
    document.getElementById("chapter2").addEventListener("drop", drop, false);
    
    document.getElementById("chapter1").addEventListener("dragover", allowDrop, false);
    document.getElementById("chapter2").addEventListener("dragover", allowDrop, false);
    
    document.getElementById("chapter1").addEventListener("dragstart", drag, false);
    document.getElementById("chapter2").addEventListener("dragstart", drag, false);
}