package org.poo.geomago.celda;

public class Celda {
	private int x;
	private int y;
	private CeldaState mState;
	private CeldaView view;
	
	public Celda(int x, int y, CeldaState InitialState) {
		this.x = x;
		this.y = y;
		mState = InitialState;
		view = new CeldaView(this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public CeldaState getmState() {
		return mState;
	}

	public void setmState(CeldaState mState) {
		this.mState = mState;
	}

	public CeldaView getView() {
		return view;
	}

	public void setView(CeldaView view) {
		this.view = view;
	}

}
