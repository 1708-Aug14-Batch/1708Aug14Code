package com.revature.stream;

import java.util.ArrayList;
import java.util.List;

public class Streams {
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.stream().flatMap(l -> l.stream());
	}
}
