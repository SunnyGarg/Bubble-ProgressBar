package com.sunny.bubbleprogressbartestproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sunny.bubbleprogressbar.BubbleProgressBar;

public class MainActivity extends Activity {

	Button start, stop;

	BubbleProgressBar bubbleProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bubbleProgressBar = (BubbleProgressBar) findViewById(R.id.bubble_progress_bar);

		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("mmmm start "
						+ bubbleProgressBar.isAnimating());
				if (bubbleProgressBar.isAnimating()) {
					// do nothing
				} else {
					bubbleProgressBar.startAnimation();
					stop.setEnabled(true);
					start.setEnabled(false);
				}
			}
		});

		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("mmmm stop "
						+ bubbleProgressBar.isAnimating());
				if (bubbleProgressBar.isAnimating()) {
					bubbleProgressBar.stopAnimation();
					stop.setEnabled(false);
					start.setEnabled(true);
				} else {
					// do nothing
				}
			}
		});

	}
}
