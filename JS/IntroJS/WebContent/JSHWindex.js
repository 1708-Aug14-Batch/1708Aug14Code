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

function getPeopleInSales(){
	$('.empName').each(function(){
		if($(this).next().text() == 'Sales'){
			console.log($(this).text());
		}
	})
}

console.log("2. Sales")
getPeopleInSales();

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

// Get Hobbies not skills
function getHobbies(){
	/*
	console.log($('select[name=hobbies] option:selected').text());
	
	$('select[name=hobbies] option:selected').each(function(){
		console.log($(this).text());
		/*
		$.each($(this).children(),function(){
			console.log($(this+'option:selected').text());
			
		})
	})*/
/*
	$('select[name=hobbies]').each(function(){
		$.each($(this).children(),function(){
			console.log(this.attributes.name);
			if(this.attributes.name == "selected"){
				console.log(this);
			}
			$.each(this.attributes,function(){
				if(this.name == "selected"){
					console.log($(this).text());
				}
			})
		})
	})
*/

	$('select[name=hobbies]').each(function(){
		$.each($(this).children(),function(){
			if(this.selected){
				console.log($(this).val());
			}
		})
	})
/*
	$('select[name=hobbies], option[selected=selected]').each(function(){
		console.log($(this).text());
	})
	//console.log($('select[name=hobbies]').text());
*/
}

console.log("4. Hobbies")
getHobbies();

function getCustomAttribute(){
	$('[data-customAttr]').each(function(){
		console.log(this);
		$.each(this.attributes,function(){
			if(this.name=="data-customattr"){
				console.log(this);
			}
		})
	})
}

console.log("5. Custom Attribute")
getCustomAttribute();