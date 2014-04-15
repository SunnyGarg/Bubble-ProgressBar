package com.sunny.bubbleprogressbar;

import java.util.ArrayList;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BubbleProgressBar extends LinearLayout {

	private Context context;
	private ArrayList<TextView> imageHolders;
	private Thread animationThread1, animationThread2, animationThread3;
	private boolean stopped = false;
	int count1, count2, count3 = 0;

	public BubbleProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		prepareLayout();
	}

	public BubbleProgressBar(Context context) {
		super(context);
		this.context = context;
		prepareLayout();
	}

	/**
	 * This is called when you want the dialog to be dismissed
	 */
	public void dismiss() {
		stopped = true;
		setVisibility(View.GONE);
	}

	/**
	 * Loads the layout and sets the initial set of images
	 */
	private void prepareLayout() {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.bubble_progress_layout, null);
		addView(view);

		imageHolders = new ArrayList<TextView>();
		imageHolders.add((TextView) view.findViewById(R.id.view1));
		imageHolders.add((TextView) view.findViewById(R.id.view2));
		imageHolders.add((TextView) view.findViewById(R.id.view3));

		animationThread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
						Message msg = new Message();
						msg.arg1 = 1;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "Progress");

		animationThread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				while (true) {
					try {
						Thread.sleep(500);
						Message msg = new Message();
						msg.arg1 = 2;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "Progress2");

		animationThread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(400);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				while (true) {
					try {
						Thread.sleep(500);
						Message msg = new Message();
						msg.arg1 = 3;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "Progress3");

		animationThread1.start();
		animationThread2.start();
		animationThread3.start();

		setVisibility(View.GONE);

	}

	public boolean isAnimating() {
		if (stopped)
			return true;
		else
			return false;
	}

	public void stopAnimation() {
		stopped = false;
		setVisibility(View.GONE);
	}

	/**
	 * Starts the animation thread
	 */
	public void startAnimation() {
		stopped = true;
		setVisibility(View.VISIBLE);

	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 1) {
				imageHolders.get(0).setVisibility(View.VISIBLE);
				if (count1 == 0) {
					ScaleAnimation zoomin = new ScaleAnimation(0, 1, 0, 1);
					zoomin.setDuration(500);

					imageHolders.get(0).startAnimation(zoomin);
				} else if (count1 == 1) {
					ScaleAnimation zoomout = new ScaleAnimation(1.0f, 0.0f,
							1.0f, 0.0f);
					zoomout.setDuration(1000);
					imageHolders.get(0).startAnimation(zoomout);
				}
				if (count1 <= 1)
					count1++;
				else {
					count1 = 0;
				}
			} else if (msg.arg1 == 2) {
				imageHolders.get(1).setVisibility(View.VISIBLE);
				if (count2 == 0) {
					ScaleAnimation zoomin = new ScaleAnimation(0, 1, 0, 1);
					zoomin.setDuration(500);

					imageHolders.get(1).startAnimation(zoomin);
				} else if (count2 == 1) {
					ScaleAnimation zoomout = new ScaleAnimation(1.0f, 0.0f,
							1.0f, 0.0f);
					zoomout.setDuration(1000);
					imageHolders.get(1).startAnimation(zoomout);
				}
				if (count2 <= 1)
					count2++;
				else {
					count2 = 0;
				}
			} else if (msg.arg1 == 3) {
				imageHolders.get(2).setVisibility(View.VISIBLE);
				if (count3 == 0) {
					ScaleAnimation zoomin = new ScaleAnimation(0, 1, 0, 1);
					zoomin.setDuration(500);

					imageHolders.get(2).startAnimation(zoomin);
				} else if (count3 == 1) {
					ScaleAnimation zoomout = new ScaleAnimation(1.0f, 0.0f,
							1.0f, 0.0f);
					zoomout.setDuration(1000);
					imageHolders.get(2).startAnimation(zoomout);
				}
				if (count3 <= 1)
					count3++;
				else {
					count3 = 0;
				}
			}

			super.handleMessage(msg);
		}

	};

}