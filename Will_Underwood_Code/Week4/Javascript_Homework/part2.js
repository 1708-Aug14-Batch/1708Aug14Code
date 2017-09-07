
/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.*/
(function getUSA(){
  var usa = document.querySelector('[data-customAttr="USA"]');
  console.log(usa.innerHTML);
})();

/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.*/
(function getPeopleInSales() {
  var table = document.querySelector('#employees');
  for (var i = 0, row; row = table.rows[i]; i++) {
    for (var j = 0, col; col = row.cells[j]; j++) {
      if(col.innerHTML == 'Sales') {
        console.log(row.cells[j - 1].innerHTML);
      }
    }
  }
})();

/*3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>*/
(function getAnchorChildren() {
  for (var i = 0, anchor; anchor = document.anchors[i]; i++) {
    if (anchor.innerHTML.indexOf('<span>') != -1) {
      
    }
  }
})();