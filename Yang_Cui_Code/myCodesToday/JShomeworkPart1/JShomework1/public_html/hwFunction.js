/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

/*function sort(numArray){
	var temp;
	for(i=0; i<numArray.length; i++){
		for(j=i; j<numArray.length; j++){
			if(Number(numArray[i])>Number(numArrya[j])){
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
		str=str+numArray[i].toString();
	}
	return str;
}

function runBubble(){
	var display = document.getElementById("bubbleDisplay");
	
	//display.innerHTML="test";
	//console.log(bubbleToText(sortArray));
	
	var str= document.getElementById("bubble").value;  // JS naming has implications
	//display.innerHTML=str;
	var numArray=new Array(str.length);
	//display.innerHTML="test";
	//display.innerHTML=numArray.length;
	for(i=0; i<str.length; i++){
		numArray[i]=str.charAt(i);
		//display.innerHTML=numArray[i];
	}
	//display.innerHTML="test";
	var sortArray=sort(numArray); //<---
	display.innerHTML=sortArray[1];
	//display.innerHTML="test";
	//display.innerHTML=bubbleToText(sortArray);
}

document.getElementById("doBubble").addEventListener("click", runBubble);*/

function sort(str){
	var numArray=new Array(str.length);
	for(i=0; i<str.length; i++){
		numArray[i]=str.charAt(i);
	}
	for(i=0; i<numArray.length; i++){
		for(j=i; j<numArray.length; j++){
			if(numArray[i]>numArray[j]){
				temp=numArray[i];
				numArray[i]=numArray[j];
				numArray[j]=temp;
			}
		}
	}
	var numOrder=numArray.join();
	return numOrder;
}

function runBubble(){
	var display = document.getElementById("bubbleDisplay");
	var str= document.getElementById("bubble").value;  // JS naming has implications
	display.innerHTML=sort(str);
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
	//display.innerHTML=str;
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

//7. Palindrome Define function isPalindrome(someStr) Return true if someStr is a palindrome, otherwise return false

function palindrome(str){
	var charArray=new Array(str.length);
	var result="Is a Palindrome";
	for(i=0; i<str.length; i++){
		charArray[i]=str.charAt(i);
	}
	for(i=0; i<=charArray.length/2; i++){
		if(charArray.length>=i){
			if(charArray[i].localeCompare(charArray[charArray.length-1-i])==0);
			else{
				result="Is not a Palindrome";
				return result;
			}
		}
		return result;
	}
	return result;
}

function runPalindrome(){
	var display=document.getElementById("pDisplay");
	var str=document.getElementById("pald").value;
	//display.innerHTML="something";
	display.innerHTML=palindrome(str);
}

document.getElementById("doPald").addEventListener("click", runPalindrome);

/*
 * 8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
 */

function printShape(shape, height, character){
    var char=character.charAt(0);
    var draw="";
    switch(shape){
    case "Square":{
        for(i=0; i<=height; i++){
            for(j=0; j<=height; j++){
                draw=draw+char;
            }
            draw=draw+"<br>";
        }
    }break;
    case "Triangle":{
        for(i=0; i<=height; i++){
            for(j=0; j<=i; j++){
                draw=draw+char;
            }
            draw=draw+"<br>";
        }
    }break;
    case "Diamond":{
        //var drawDiamond=new Array(height);
        /*for(i=0; i<=height; i++){
            for(j=0; j<=height; j++){
                drawDiamond[j]=char;
            }
            if(i<=height/2+1){
                for(j=i; j<=0; j--){
                    drawDiamond[j]=" ";
                    drawDiamond[height-j-i]=" ";
                }
            }else{
                for(j=0; j<=i; j++){
                    drawDiamond[j]=" ";
                    drawDiamond[height-j-i]=" ";
                }
            }
            for(j=0; j<drawDiamond.length; j++){
                draw=draw+drawDiamond[j];
            }
            draw=draw+"<br>";
            //draw=draw+drawDiamond.join()+"<br>";
        }*/
        
        /*for(i=0; i<=height; i++){
            if(i<=height/2+1){
                var bar1=0;
                var brick1=1;
                for(j=0; j<=height/2+bar1; j++){
                    drawDiamond[j]=" "
                    bar1++;
                }
                for(j=height/2+bar1; j<=height/2+bar1-brick1; j--){
                    drawDiamond[j]=char;
                    brick1+=2;
                }
            }else{
                var bar2=0;
                var brick2=1;
                for(j=0; j<=height/2-bar2; j++){
                    drawDiamond[j]=" "
                    bar2++;
                }
                for(j=height/2-bar2; j<=height/2-bar2-brick2; j--){
                    drawDiamond[j]=char;
                    brick2-=2;
                }
            }
            for(j=0; j<drawDiamond.length; j++){
                draw=draw+drawDiamond[j];
            }
            draw=draw+"<br>";
        }*/
        var bar=height/2+1;
        var brick=0;
        for(i=0; i<=height; i++){
            if(i<=height/2-1){
                var drawDiamond=new Array(bar);
                for(j=0; j<drawDiamond.length; j++){
                    drawDiamond[j]="_";
                }
                for(j=drawDiamond.length; j>drawDiamond.length-brick; j--){
                    drawDiamond[j]=char;
                }
                bar++;
                brick+=2;
            }else{
                var drawDiamond=new Array(bar);
                for(j=0; j<drawDiamond.length; j++){
                    drawDiamond[j]="_";
                }
                for(j=drawDiamond.length; j>drawDiamond.length-brick; j--){
                    drawDiamond[j]=char;
                }
                bar--;
                brick-=2;
            }
            for(j=0; j<drawDiamond.length; j++){
                draw=draw+drawDiamond[j];
            }
            draw=draw+"<br>";
        }
    }break;
    default:break;
    }
    return draw;
}

function runShape(){
    var display=document.getElementById("shapeDisplay");
    var shape=document.getElementById("shape").value;
    var height=document.getElementById("height").value;
    var char=document.getElementById("char").value;
    display.innerHTML=printShape(shape, height, char);
}

document.getElementById("doShape").addEventListener("click", runShape);

//9. Object literal Define function traverseObject(someObj) Print every property and it's value.
function accessObj(obj){
    var str="";
    str=obj.thing1+" "+obj.thing2+" "+obj.thing3;
    return str;
}

function runObj(){
    var display=document.getElementById("objDisplay");
    var a=document.getElementById("a").value;
    var b=document.getElementById("b").value;
    var c=document.getElementById("c").value;
    var randomObj={thing1:a, thing2:b, thing3:c};
    display.innerHTML=accessObj(randomObj);
}

document.getElementById("button").addEventListener("click", runObj);

//10. Delete Element Define function deleteElement(someArr) Print length Delete the third element in the array.
//    Print length The lengths should be the same.

function deleteElement(someArr, index){
    var str="";
    delete someArr[index];
    str=someArr.join();
    return str;
}

function runDeleteElement(){
    var display=document.getElementById("deleteDisplay");
    var str= document.getElementById("elements").value;
    var index=document.getElementById("index").value;
    
    var someArr=new Array(str.length);
    for(i=0; i<someArr.length; i++){
        someArr[i]=str.charAt(i);
    }
    
    display.innerHTML=deleteElement(someArr,index);
}

document.getElementById("delete").addEventListener("click", runDeleteElement);


//11. Splice Element Define function spliceElement(someArr) Print length Splice the third element in the array.
//    Print length The lengths should be one less than the original length.
function spliceElemet(someArr, index){
    var str="";
    someArr.splice(index,index);
    str=someArr.join();
    return str;
}

function runSpliceElement(){
    var display=document.getElementById("spliceDisplay");
    var str= document.getElementById("someElements").value;
    var index=document.getElementById("anIndex").value;
    
    var someArr=new Array(str.length);
    for(i=0; i<someArr.length; i++){
        someArr[i]=str.charAt(i);
    }
    display.innerHTML=deleteElement(someArr,index);
}

document.getElementById("splice").addEventListener("click", runSpliceElement);


//12. Defining an object using a constructor Define a function Person(name, age) 
//    The following line should set a Person object to the variable john:
//    var john = new Person("John", 30);

function Person(name, age){
    /*var str="";
    var john = new Person(name, age);
    str="name: "+john.name+"<br>"+"age: "+john.age;
    return str;*/
    this.name=name;
    this.age=age;
}

function runPerson(){
    var display=document.getElementById("personDisplay");
    var name=document.getElementById("name").value;
    var age=document.getElementById("age").value;
    var john = new Person(name, age);
    var str="name: "+john.name+"<br>"+"age: "+john.age;
    //display.innerHTML=Person(name,age);
    display.innerHTML=str;
}

document.getElementById("person").addEventListener("click", runPerson);

//13. Defining an object using an object literal Define function getPerson(name, age)
//    The following line should set a Person object to the variable john:
//    var john = getPerson("John", 30);

function Person(name, age){
    this.name=name;
    this.age=age;
}

function getPerson(name, age){
    return _.findKey(Person, {'name':name,'age':age });
}

function runGetPerson(){
    var display=document.getElementById("getDisplay");
    var john = new Person("john", 30);
    display.innerHTML=getPerson("john",30);
}

document.getElementById("find").addEventListener("click", runGetPerson);