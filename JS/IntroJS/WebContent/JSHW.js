/**
JS HOMEWORK
ANDY ZHENG
*/

// part 1

//1
function fib(n) {
	if(n<=1) return n;
	else return(fib(n-1) + fib(n-2));
}

$('#one').on('click',function(){
	$('#oneout').text(fib($('#onein').val()));
})

//2
function bubbleSort(numArray){
	var array = JSON.parse("[" + numArray + "]");
	for(var x = 0; x < array.length; x++){
		for(var y = 0; y < array.length-1; y++){
			if(array[y] > array[y+1]){
				var temp = array[y];
				array[y] = array[y+1];
				array[y+1] = temp;
			}
		}
	}
	return array;
}

$('#two').on('click',function(){
	$('#twoout').text(bubbleSort($('#twoin').val()));
})

//3
function reverseStr(someStr){
	return someStr.split("").reverse().join("");
}

$('#three').on('click',function(){
	$('#threeout').text(reverseStr($('#threein').val()));
})

//4
function factorial(someNum){
	var temp = 1;
	while(someNum > 0){
		temp = temp * someNum;
		someNum -= 1;
	}
	return temp;
}

$('#four').on('click',function(){
	$('#fourout').text(factorial($('#fourin').val()));
})

//5
function substring(someStr, length, offset){
	if(someStr.length == false){
		alert("No String");
	}
	else if(length == false){
		alert("No Length");
	}
	else if(offset == false){
		alert("No Offset");
	}
	else if(someStr.length < parseInt(offset)){
		alert("String is too short or offset is too large");
	}
	else if(someStr.length < (parseInt(offset) + parseInt(length))){
		alert("String is too short, offset is too large, or length is too large");
	}
	else{
		return someStr.substr(parseInt(offset),parseInt(length));
	}
}

$('#five').on('click',function(){
	$('#fiveout').text(substring($('#fivein1').val(),$('#fivein2').val(),$('#fivein3').val()));
})

//6
function isEven(someNum){
	if(someNum == (Math.floor(someNum/2)*2)){
		return "true";
	}else{
		return "odd";
	}
}

$('#six').on('click',function(){
	$('#sixout').text(isEven($('#sixin').val()));
})

//7
function isPalindrome(someStr){
	var temp = someStr.split("");
	var begin = 0;
	var end = someStr.length-1;
	for(var x = 0; x < Math.floor(someStr.length/2); x++){
		if(temp[begin] !== temp[end]){
			return false;
		}
		begin += 1;
		end -= 1;
	}
	return true;
}

$('#seven').on('click',function(){
	$('#sevenout').text(isPalindrome($('#sevenin').val()));
})

//8
function printShape(shape, height, character){
	var temp = shape;
	switch(temp){
		case "Square":
		for(var x = 0; x < parseInt(height); x++){
			console.log(Array(parseInt(height)+1).join(character) + "\n");
		}
		break;
		case "Triangle":
		for(var x = 1; x < parseInt(height)+2; x++){
				console.log(Array(x).join(character));
		}
		break;
		case "Diamond":
		for(var x = 1; x < parseInt(height)-1; x+= 2){
			var tempString = "";
			var tempSpace = parseInt(height) - x;
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			for(var z = 0; z < x; z++){
				tempString += character;
			}
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			console.log(tempString);
		}

		var tempStringM = "";
		for(var x = 0; x < parseInt(height); x++){
			tempStringM += character;
		}
		console.log(tempStringM);

		for(var x = parseInt(height)-1; x > 1; x-= 2){
			var tempString = "";
			var tempSpace = parseInt(height) - x;
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			for(var z = 0; z < x-1; z++){
				tempString += character;
			}
			for(var z = 0; z < tempSpace/2; z++){
				tempString += " ";
			}
			console.log(tempString);
		}
		break;
	}
}

$('#eight').on('click',function(){
	$('#eightout').text(printShape($('#eightin1').val(),$('#eightin2').val(),$('#eightin3').val()));
})

//9
function traverseObject(someObj){
	var temp;
	for(var props in someObj){
		temp = someObj[props];
		console.log(props, temp)
	}
}

$('#nine').on('click',function(){
	$('#nineout').text(traverseObject($('#ninein')));
})

//10
function deleteElement(someArr){
	var array = JSON.parse("[" + someArr + "]");
	var string = "";
	string += "Length: " + array.length;
	console.log(string);
	delete array[2];
	string += "         Array: " + array;
	string += "         Length: " + array.length;
	return string
}

$('#ten').on('click',function(){
	$('#tenout').text(deleteElement($('#tenin').val()));
})

//11
function spliceElement(someArr){
	var array = JSON.parse("[" + someArr + "]");
	var string = "";
	string += "Length: " + array.length;
	console.log(string);
	array.splice(2,1);
	string += "         Array: " + array;
	string += "         Length: " + array.length;
	return string

}

$('#eleven').on('click',function(){
	$('#elevenout').text(spliceElement($('#elevenin').val()));
})

$('#twelve').on('click',function(){
	function person(name, age){
		this.name = name;
		this.age = age;
	}
	var person = new person($('#twelvein1').val(),$('#twelvein2').val())
	$('#twelveout').text(person);
})

$('#thirteen').on('click',function(){
	var person = {name:$('#thirteenin1').val(),age:$('#thirteenin2').val()}
	$('#thirteenout').text(person);
})