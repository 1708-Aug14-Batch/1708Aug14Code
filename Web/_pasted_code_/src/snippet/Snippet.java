package snippet;

public class Snippet {
	function substring(someStr, length, offset){
		if((offset+length) > someStr.length){
	        alert("This substring is not contained within the string. Please choose a shorter length or smaller beginning index");
		}
		else{
		n=someStr[offset];
		for(i=offset;i< length;i++){
			n = n.concat(someStr[i+1]);
		}
		return n;
		}
		
	}
}

