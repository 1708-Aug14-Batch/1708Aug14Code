package com.revature.q15;

/*
 * Simple implementor of the Arithmetical interface
 */
public class NumberContainer implements Arithmetical<NumberContainer> {
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;
	
	
	public NumberContainer(short s, int i, long l, float f, double d) {
		this.s = s;
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
	}
	
	public short getS() {
		return s;
	}

	public int getI() {
		return i;
	}

	public long getL() {
		return l;
	}

	public float getF() {
		return f;
	}

	public double getD() {
		return d;
	}
	
	@Override
	public NumberContainer add(NumberContainer t) {
		return new NumberContainer((short) (this.s + t.s),
				   this.i + t.i,
				   this.l + t.l,
				   this.f + t.f,
				   this.d + t.d);
	}

	@Override
	public NumberContainer subtract(NumberContainer t) {
		return new NumberContainer((short) (this.s - t.s),
				   this.i - t.i,
				   this.l - t.l,
				   this.f - t.f,
				   this.d - t.d);
	}
	
	@Override
	public NumberContainer multiply(NumberContainer t) {
		return new NumberContainer((short) (this.s * t.s),
				   this.i * t.i,
				   this.l * t.l,
				   this.f * t.f,
				   this.d * t.d);	}
	
	@Override
	public NumberContainer divide(NumberContainer t) {
		return new NumberContainer((short) (this.s / t.s),
				   this.i / t.i,
				   this.l / t.l,
				   this.f / t.f,
				   this.d / t.d);
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NumberContainer))
			return false;
		NumberContainer nc = (NumberContainer) o;
		return this.s == nc.s && this.i == nc.i && this.l == nc.l && this.f == nc.f && this.d == nc.d;
	}
	
	@Override
	public int hashCode() {
		return ((Double)(s + i + l + f + Math.pow(d, 2))).hashCode();
	}
}
