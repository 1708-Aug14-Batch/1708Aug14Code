/**
 * 
 */
//1. Fibonacci Define function: fib(n) Return the nth number in the fibonacci sequence.
function fib(n){
	if(n<=1)return n;
	else return (fib(n-1)+fib(n-2));
}

function runFib(){
	var display =document.getElementById("fibDisplay");
	var n=document.getElementById("fib").value;
	display.innerHTML=fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);

//2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort algorithm to sort the array.

function bubble(numArray){
	var temp;
	for(i=0; i<numArray.length; i++){
		for(j=i; j<numArray.length; j++){
			if(numArray[i]>numArrya[j]){
				temp=numArray[i];
				numArray[i]=numArray[j];
				numArray[j]=temp;
			}
		}
	}
	return numArray;
}

function bubbleToText(numArray){
	var str="";
	for(i=0; i<numArray.length; i++){
		str=str+","+numArray[i];
	}
	return str;
}

function runBubble(){
	var display = document.getElementById("bubbleDisplay");
	var num= document.getElementById("bubble");
	var numArray=new Array(num.length);
	for(i=0; i<num.length; i++){
		numArray[i]=num.charAt(i).value;
	}
	display.innerHTML=bubbleToText(bubble(numArray));
}

document.getElementById("doBubble").addEventListener("click", runBubble);


//Q3. Reverse a string without using a temporary variable.
function rev(str){
	var reverse="";
	for (i = 0; i < str.length; i++) {
		reverse=reverse+str.charAt(str.length-1-i);
	}
	return reverse;
}

function runReverse(){
	var display =document.getElementById("reverseDisplay");
	var str=document.getElementById("reverse").value;
	display.innerHTML=rev(str);
}

document.getElementById("doReverse").addEventListener("click", runReverse);

//Q4. Write a program to compute N factorial.
function fact(n){
	var fct=0;
	for (i=0; i<=n; i++){
		fct=fct+n*(n-1);
	}
	return fct;
}

function runFact(){
	var display=document.getElementById("facDispaly");
	var n=document.getElementById("fac").value;
	display.innerHTML=fact(n);
}

document.getElementById("doFac").addEventListener("click", runFact);

//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.
function sub(str,n){
	var subStr="";
	for(i=0; i<n; i++){
		subStr=subStr+str.charAt(i);
	}
	return subStr;
}

function runSub(){
	var display=document.getElementById("subDispaly");
	var str=document.getElementById("sub1").value;
	var n=document.getElementById("sub2").value;
	display.innerHTML=sub(str,n);
}

document.getElementById("doSub").addEventListener("click", runSub);

//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
function isEven(n){
	var result="this number is odd";
	for(i=0; i<n; i++){
		if(i*2==n){
			result="this number is even";
			return result;
		}
	}
	return result;
}

function runEven(){
	var display=document.getElementById("evenDispaly");
	var n=document.getElementById("even").value;
	display.innerHTML=isEven(n);
}

document.getElementById("doEven").addEventListener("click", runEven);

//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
