package com.hw.week01.q11.accessor;

import java.util.ArrayList;

import com.hw.week01.q11.accessme.AccessMe;

public class Accessor {
	
	private AccessMe accessMe;
	
	public Accessor() {
		this.accessMe = new AccessMe();
	}
	
	public ArrayList<Float> access() {
		ArrayList<Float> accessedFloats = new ArrayList<Float>();
		accessedFloats.add(this.accessMe.getValue1());
		accessedFloats.add(this.accessMe.getValue2());
		return accessedFloats;
	}

}
