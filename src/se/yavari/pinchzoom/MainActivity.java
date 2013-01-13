package se.yavari.pinchzoom;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView scaleGesture;
	ScaleGestureDetector scaleGestureDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        scaleGesture = (TextView)findViewById(R.id.article);
        scaleGesture.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        scaleGestureDetector = new ScaleGestureDetector(this, new simpleOnScaleGestureListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev){
	    super.dispatchTouchEvent(ev);    
	    return scaleGestureDetector.onTouchEvent(ev); 
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		scaleGestureDetector.onTouchEvent(event);
		Log.d("TYPE", "TouchEvent");
		return true;
	}

	public class simpleOnScaleGestureListener extends
			SimpleOnScaleGestureListener {

		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			// TODO Auto-generated method stub
			float size = scaleGesture.getTextSize();
			Log.d("TextSizeStart", String.valueOf(size));
			
			float factor = detector.getScaleFactor();
			Log.d("Factor", String.valueOf(factor));
			
			
			float product = size*factor;
			Log.d("TextSize", String.valueOf(product));
			scaleGesture.setTextSize(TypedValue.COMPLEX_UNIT_PX, product);
			
			size = scaleGesture.getTextSize();
			Log.d("TextSizeEnd", String.valueOf(size));
			return true;
		}


	}

}
