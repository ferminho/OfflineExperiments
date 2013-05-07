package com.gloria.offlineexperiments;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ExerciseActivity extends Activity{

	private TouchImageView imgTouchable;


	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise);

		imgTouchable = (TouchImageView) findViewById(R.id.touchImageView1);
		imgTouchable.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.sol2));
		imgTouchable.setMaxZoom(4f); //change the max level of zoom, default is 3f
	}

	public void showPinPosition(View view) {
		ZoomablePinView pin = imgTouchable.getPin();
		if (pin != null) {
			PointF pinPos = pin.getPositionInPixels();
			Toast.makeText(this, "pin position: " + pinPos.x + ", " + pinPos.y, Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(this, "no pin selected", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void removePin (View view) {
		imgTouchable.removePin();
	}

	public void increase (View view) {
		imgTouchable.increasePin();
	}
	
	public void decrease (View view) {
		imgTouchable.decreasePin();
	}
}
