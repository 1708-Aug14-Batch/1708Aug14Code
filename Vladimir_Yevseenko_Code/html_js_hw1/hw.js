
function fibonacci(n) {
	if (n < 0)
		return -1;
	else if (n == 0)
		return 0;
	else if (n == 1)
		return 1;
	var i;
	var pprev, prev, cur;
	pprev = 0;
	prev = 1;
	for (i=2; i<=n; i++) {
		cur = pprev + prev;
		pprev = prev;
		prev = cur;
	}
	return cur;
}

$('#fibBtn').on('click', function() {
	var n = $('#fibIn').val();
	var res = fibonacci(n);
	if (res == -1)
		$('#fibOut').text('Enter a number >= 0');
	else
		$('#fibOut').text(res);
});




function bubbleSort(arr) {
	var flag, i, j;
	for (i=0; i<arr.length-1; i++) {
		flag = false;
		for (j=0; j<arr.length-i-1; j++) {
			if (arr[j] > arr[j+1]) {
				var temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				flag = true;
			}
		}
		if (!flag)
			return;
	}
}

$('#bubbleSortBtn').on('click', function() {
	var arr = $('#bubbleSortIn').val().split(' ');
	for (var i=0; i<arr.length; i++)
		arr[i] = parseInt(arr[i]);
	console.log(arr);
	bubbleSort(arr);
	console.log(arr);
	$('#bubbleSortOut').text(arr.join(' '));
});



$('#reverseStrBtn').on('click', function() {
	var str = $('#reverseStrIn').val();
	console.log(str);
	console.log(str.split('').reverse().join(''));
	$('#reverseStrOut').text($('#reverseStrIn').val().split('').reverse().join(''));
});



/* used iterative factorial just because recursive factorial is bad */
function factorial(n) {
	var res = 1;
	if (n < 0)
		return -1;
	else if (n <= 1)
		return 1;
	for (var i=2; i<=n; i++)
		res *= i;
	return res;
}


$('#factorialBtn').on('click', function() {
	var n = $('#factorialIn').val();
	var res = factorial(n);
	if (res == -1)
		$('#factorialOut').text('Enter a number >= 0');
	else
		$('#factorialOut').text(res);
});



function substring(str, offset, len) {
	return str.slice(offset, offset+len+1);
}


$('#substringBtn').on('click', function() {
	$('#substringOut').text(substring($('#substringStrIn').val(), parseInt($('#substringOffsetIn').val()), parseInt($('#substringLenIn').val())));
});





function isEven(n) {
	return !(n & 1);
}

$('#isEvenBtn').on('click', function() {
	var n = $('#isEvenIn').val();
	if (isEven(n))
		$('#isEvenOut').text('Even');
	else
		$('#isEvenOut').text('Odd');
});





function isPalindrome(str) {
	var low, high;
	for (low=0, high=str.length-1; low < high; low++, high--)
		if (str.charAt(low) != str.charAt(high))
			return false;
	return true;
}


$('#palindromeBtn').on('click', function() {
	var str = $('#palindromeIn').val();
	if (isPalindrome(str))
		$('#palindromeOut').text(str + ' is a palindrome');
	else
		$('#palindromeOut').text(str + ' is not a palindrome');
});






function printShape(shape, h, c) {
	switch(shape) {
		case 'triangle': printTriangle(h, c); break;
		case 'square': printSquare(h, c); break;
		case 'diamond': printDiamond(h, c); break;
	}
}

function printTriangle(h, c) {
	var res = '';
	for (var i=0; i<h; i++) {
		for (var j=0; j<=i; j++)
			res += c;
		res += '\n';
	}
	console.log(res);
}

function printSquare(h, c) {
	var res = '';
	for (var i=0; i<h; i++) {
		for (var j=0; j<h; j++)
			res += c;
		res += '\n';
	}
	console.log(res);
}


function printDiamond(h, c) {
	var res = '';
	var i, j, ho2;
	ho2 = Math.floor(h/2);
	for (i=0; i<ho2; i++) {
		for (j=0; j < ho2 - i; j++)
			res += ' ';
		
		for (j=0; j < i*2 + 1; j++)
			res += c;
		
		for (j=0; j < ho2 - i; j++)
			res += ' ';
		res += '\n';
	}
	
	for (i=ho2; i>=0; i--) {
		for (j=0; j < ho2 - i; j++)
			res += ' ';
		
		for (j=0; j < i*2 + 1; j++)
			res += c;
		
		for (j=0; j < ho2 - i; j++)
			res += ' ';
		res += '\n';
	}
	console.log(res);
}


$('#shapesBtn').on('click', function() {
	var h = $('#shapesHeight').val();
 	if ($('#shape     sTriangle').is(':checked'))
		printShape('triangle', h, c);
	else if ($('#shapesSquare').is(':checked'))
		printShape('square', h, c);
	else
		printShape('diamond', h, c);
});




function traverseObject(obj) {
	for (var prop in obj)
		if (obj.hasOwnProperty(prop))
			console.log(prop + ': ' + obj[prop]);
}

var obj = { property1: 'value1', property2: 'value2', property3: 'value3' };
traverseObject(obj);


function deleteElement(arr) {
	console.log(arr.length);
	delete(arr[2]);
	console.log(arr.length);
}

var arr1 = [0, 1, 2, 3, 4, 5];
deleteElement(arr1);


function spliceElement(arr) {
	console.log(arr.length);
	arr.splice(2, 1);
	console.log(arr.length);
}

var arr2 = [0, 1, 2, 3, 4, 5];
spliceElement(arr2);


function person(name, age) {
	this.name = name;
	this.age = age;
}

var john1 = new person('john', 30);
console.log(john1);


function getPerson(name, age) {
	return { name: name, age: age };
}

var john2 = getPerson('john', 30);
console.log(john2);

