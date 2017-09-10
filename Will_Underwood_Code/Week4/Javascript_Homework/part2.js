
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
      console.log(document.getElementByName("span").contents());
    }
  }
})();

/*4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.*/
(function getHobbies() {
  var checked = $('select.skills').map(function() {
    return this.value;
  }).get();
  console.log(checked);
})();

/*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.*/
(function getCustomAttribute() {
  var elements = $('[data-customAttr]');
  for (i = 0; i < elements.length; i++) {
    console.log(elements[i]);
  } 
})();

/*6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>
Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "
Cannot add" in the <span> element*/
$(document).ready(function add() {
  var num1 = 0;
  var num2 = 0;
  var sum;
  $('#num1').change(function() {
    num1 = $('#num1').val;
    sum = num1 + num2;
    $('#sum').html(sum);
  });
  $('#num2').change(function() {
    num2 = $('#num2').val;
    sum = num1 + num2;
    $('#sum').html(sum);
  });
});

/*7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.*/
$('select[name=skills]').on('change', function() {
  alert("Are you sure " + this.value + " is one of your skills?");
});

/*8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor*/
var prev = 'yellow';
$('select[name=colors]').on('change', function() {
  alert("So you like " + this.value + " more than " + prev + " now?");
  $(this).css('background-color', this.value);
  prev = this.value;
});

/*9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.*/
var hidden = false;
$('.empName').hover(function() {
  if (hidden) {
    hidden = false;
    $(this).fadeIn(500);
  }
  if (!hidden) {
    hidden = true;
    $(this).fadeOut(500);
  }
});

/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.*/
$('#currentTime').load(setTimeout(function() {
  var date = new Date();
  var hours = date.getHours();
  var period = "AM";
  if (hours > 12) {
    hours -= 12;
    period = "PM";
  }
  var currentTime = hours + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + period;
  $('#currentTime').html(currentTime);
}, 500));

/*11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.*/
$('#helloWorld').click(
  setTimeout(function() {
    var colors = ["red", "orange", "yellow", "green", "blue", "purple"];
    var randomColor = colors[Math.floor(Math.random() * colors.length)];
    $(this).css("color", randomColor);
  }, 3000)
);

/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).*/
function walkTheDOM(node, func) {
  func(node);
    node = node.firstChild;
    while (node) {
        walk(node, func);
        node = node.nextSibling;
    }
}
(walkTheDOM(document.body, function() {
  if(node.nodeType == 1) {
    console.log(node);
  }
}))();