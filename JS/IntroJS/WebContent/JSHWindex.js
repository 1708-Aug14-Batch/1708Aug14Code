/**
JS HOMEWORK
ANDY ZHENG
*/

// part 2

//1

function getUSA(){
	$('*').each(function(){
		$.each(this.attributes,function(){
			if(this.value=="USA"){
				console.log($("["+this.name+"="+this.value+"]").text());
			}
		})
	})
}

console.log("1. USA")
getUSA();

//2

function getPeopleInSales(){
	$('.empName').each(function(){
		if($(this).next().text() == 'Sales'){
			console.log($(this).text());
		}
	})
}

console.log("2. Sales")
getPeopleInSales();

//3
// Anchor element is a
function getAnchorChildren(){
	$('a').each(function(){
		$.each($(this).children(),function(){
			if($(this).prop('tagName') == 'SPAN'){
				console.log($(this).text());
			}
		})
	})
}

console.log("3. Click Here")
getAnchorChildren();

//4
// Get Hobbies not skills
// Also drop down, 1 selection?????
function getHobbies(){
	$('select[name=hobbies]').each(function(){
		$.each($(this).children(),function(){
			if(this.selected){
				console.log($(this).val());
			}
		})
	})
}

console.log("4. Hobbies")
getHobbies();

//4

function getCustomAttribute(){
	$('[data-customAttr]').each(function(){
		console.log($(this).prop('tagName'));
		$.each(this.attributes,function(){
			if(this.name=="data-customattr"){
				console.log(this.value);
			}
		})
	})
}

console.log("5. Custom Attribute")
getCustomAttribute();

// 6
// ??

var num1;
var num2;

$('#num1').on("keyup",function(){
	num1 = this.value;
	if(isNaN(num1) || isNaN(num2)){
		$('#sum').text("Cannot add");
	}else{
		$('#sum').text(parseInt(num1)+parseInt(num2));
	}
})

$('#num2').on("keyup",function(){
	num2 = this.value;
	if(isNaN(num1) || isNaN(num2)){
		$('#sum').text("Cannot add");
	}else{
		$('#sum').text(parseInt(num1)+parseInt(num2));
	}
})

//7
// can't deselect skill?????
$('[name=skills]').change(function(){
	alert("Are you sure " + $(this).val() + " is one of your skills?");
})

//8
//NOT RADIO BUTTONS ?????

var color = $('[name=colors]').val();
$('[name=colors]').css("background-color", color);
$('[name=colors]').change(function(){
	alert("So you like " + $('[name=colors]').val() + " more than " + color + " now?")
	$('[name=colors]').css("background-color", $('[name=colors]').val());
	color = $('[name=colors]').val();
});

//9

$('.empName').hover(function(){ 
		$(this).fadeTo(1,1);
	},function() {
	    $(this).fadeTo(1,0);
});

//10
var time = new Date($.now());
var hour = time.getHours();
var minutes = time.getMinutes();
var seconds = time.getSeconds();
var ampm;

if(hour > 11){
	ampm = "pm";
}else{
	ampm = "am";
}

if(hour > 12){
	hour = hour-12;
}

if(minutes <= 9){
	minutes = "0" + minutes;
}

if(seconds <= 9){
	seconds = "0" + seconds;
}
var time12 = hour +  ":" + minutes + ":" + seconds + " " + ampm;
$('#currentTime').text(time12); 

//11

$("#helloWorld").click(function(){
	setTimeout(function(){
		var rbg = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
		$('#helloWorld').css("color", rbg);
	},3000)
})

//12

function walkTheDOM(node, func){
    func(node);
    node = node.firstChild;
    while(node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
	}
};

/*
console.log("12. Walk the DOM")
walkTheDOM(document,function(node){
	console.log(node);
})*/