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
	var tokenizedNumbers = numbersText.split(' ');
	var numbers = Array(tokenizedNumbers.length);
	for (i = 0; i < tokenizedNumbers.length; i++) {
		numbers[i] = parseInt(tokenizedNumbers[i]);
	}
	for (i = 0; i < numbers.length; i++) {
		swapped = false;
		for (j = 1; j < numbers.length - 1; j++) {
			if (numbers[i - 1] > numbers[i]) {
				temp = numbers[i - 1];
				numbers[i - 1] = numbers[i];
				numbers[i] = temp;
				swapped = true;
			}
		}
	}
	return numbers;
}

function runBubbleSort() {
	var display = document.getElementById("bubbleDisplay");
	var numbers = document.getElementById("bubbleSort").value;
	display.innerHTML = bubbleSort(numbers);
}

function reverseString(str) {
	var characters = str.split("");
	characters = characters.reverse();
	return characters.join("");
}

function runReverseString() {
	var display = document.getElementById("reverseStringOutput");
	var str = document.getElementById("str").value;
	display.value = reverseString(str);
}

function getFactorial() {
  var input = $('#inputFactorial').val();
    result = 1;
    for (i = input; i > 0; i--) {
      result *=  i ;
    }
  $('#outputFactorial').val(result);
}

function substring(someStr, length, offset) {
  if (offset > length - 1) {
    alert('Offset too big!');
    return;
  }
  if (length > someStr.length) {
    alert('Length too big!');
    return;
  }
  var chars = someStr.toString().split('');
  var result = new Array(length);
  for (i = 0; i < length; i++) {
    result[i] = chars[i + offset];
  }
  return result.join();
}

function runSubstring() {
  var string = $('#inputString').val();
  var length = $('#inputLength').val();
  var offset = $('#inputOffset').val();
  var sub = substring(string, length, offset);
  $('#outputSubstring').val(sub);
}

function isEven() {
  var num = $('#inputNumber').val();
  $('#outputEven').val(!(num & 1));
}

function isPalindrome() {
  var word = $('#inputPalindrome').val();
  var wordChars = word.split('');
  var reversedWord = wordChars.reverse().join('');
  $('#outputPalindrome').val(word == reversedWord); 
}

function printShape() {
  var shape = $('#inputShapeName').val();
  var height = $('#inputHeight').val();
  var char = $('#inputChar').val();
  switch(shape) {
    case "Triangle":
      var triangle = new Array();
      for(i = 0; i < height; i++) {
        triangle[i] = new Array(i + 2).join(char);
        console.log(triangle[i]);
      }
      break;
    case "Square":
      var output = "";
      for (i = 0; i < height; i++) {
        for (j = 0; j < height; j++) {
          output += char;
        }
        output += "\n";
      }
      console.log(output);
      break;
    case "Diamond":
      var diamond = "";
      for (i = 1; i <= height; i += 2) {
        for (j = height; j >= i; j -= 2) {
          diamond += " ";
        }
        for (k = 1; k <= i; k++) {
          diamond += char;
        }
        diamond += "\n";
      }
      for (i = 1; i <= height; i += 2) {
        for (j = 1; j <= i; j += 2) {
            diamond += " ";
        }
        for (k = height; k >= i; k--) {
            diamond += char;
        }
        diamond += "\n";
    }
      console.log(diamond);
      break;
  }
}

function traverseObject() {
  var obj = {
    num1: 100,
    num2: 200
  };
  for (var prop in obj) {
    var output = "";
    output += prop + " = " + obj[prop];
    console.log(output);
  }
}

function deleteElement() {
  var arr = [8, 6, 7, 5, 3, 0, 9];
  console.log("Length = " + arr.length);
  arr[2] = undefined;
  console.log("Length = " + arr.length);
}

function spliceElement() {
  var arr = [8, 6, 7, 5, 3, 0, 9];
  console.log("Length = " + arr.length);
  arr.splice(2, 1);
  console.log("Length = " + arr.length);
}

function Person(name, age) {
  var john = {
    n: name,
    a: age
  }
  return john;
}

function getPerson(name, age) {
  var john = {
    n: name,
    a: age
  }
  return john;
}



document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("doBubbleSort").addEventListener("click", runBubbleSort);

document.getElementById("doReverseString").addEventListener("click", runReverseString);

document.getElementById("btnFactorial").addEventListener("click", getFactorial);

document.getElementById("btnSubstring").addEventListener("click", runSubstring);

document.getElementById("btnEven").addEventListener("click", isEven);

document.getElementById("btnPalindrome").addEventListener("click", isPalindrome);

document.getElementById("btnShape").addEventListener("click", printShape);

document.getElementById("btnTraverse").addEventListener("click", traverseObject);

document.getElementById("btnDelete").addEventListener("click", deleteElement);

document.getElementById("btnSplice").addEventListener("click", spliceElement);