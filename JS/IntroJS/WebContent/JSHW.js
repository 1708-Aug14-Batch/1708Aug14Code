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

}

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

}

//9
function traverseObject(someObj){

}

//10
function deleteElement(someArr){

}

//11
function spliceElement(someArr){

}