/*
JS HOMEWORK
WILL UNDERWOOD
*/

function fib(n) {
	if(n <= 1) return n;
	else return (fib(n - 1) + fib(n - 2));
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

// Bubble Sort
function bubbleSort(numbersText) {
	var tokenizedNumbers = numbersText.split(" ");
	var numbers;
	for (i = 0; i < tokenizedNumbers.length; i++) {
		numbers[i] = parseInt(tokenizedNumbers[i]);
	}
	for (i = 0; i < numbers.length; i++) {
		swapped = false;
		for (j = 1; j < numbers.length - 1; j++) {
			if (numbers[i - 1] > numbers[i]) {
				temp = numbers[i - 1];
				numbers[i - 1] = numbers[i]
				numbers[i] = temp;
				swapped = true;
			}
		}
	}
	return numbers;
}

function runBubbeSort() {
	var display = document.getElementByID("bubbleDisplay");
	var numbers = document.getElementByID("bubbleSort");
	display.innerHTML = bubbleSort(numbers);
}

function reverseString(str) {
	var characters = str.split('');
	var characters = characters.reverse();
	return characters.join();
}

function runReverseString() {
	var display = document.getElementByID("#reverseStringOutput");
	var str = document.getElementByID("#str");
	return reverseStr(str);
}

document.getElementById("#doFib").addEventListener("click", runFib);

/*document.getElementById("inner").addEventListener("click", function(){alert("inner")});
document.getElementById("middle").addEventListener("click", function(){alert("middle")});
document.getElementById("outer").addEventListener("click", function(){alert("outer")});*/

document.getElementByID("doBubbleSort").addEventListener("click", runBubbleSort);

document.getElementByID("#doReverseString").addEventListener("click", runReverseString);
