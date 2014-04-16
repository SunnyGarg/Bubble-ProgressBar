Bubble-ProgressBar
==================


SDK designed for use with Android devices and simulators. Requires Android 2.3 or later.

Bored with traditional Progress Bars !!

Don't worry we have a great solution for you. 

Now get the stylished Bubble Progress Bar in just 2 easy steps.


Step 1 -> 

Add the below code into yourxml layout file.

<com.sunny.bubbleprogressbar.BubbleProgressBar
android:id="@+id/bubble_progress_bar"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_centerInParent="true"
android:layout_gravity="center_vertical|center_horizontal"
android:layout_marginTop="20dp"
android:gravity="center_horizontal|center_vertical"
android:visibility="visible" />


Step 2 -> 

Get the XML element reference by 

bubbleProgressBar = (BubbleProgressBar) findViewById(R.id.bubble_progress_bar);

    1. Start the progress ->

        bubbleProgressBar.startAnimation();

    
    2. Stop the progress ->

        bubbleProgressBar.stopAnimation();

   
    3. Check if the progress is started or stopped

        bubbleProgressBar.isAnimating() -> returns true if already started otherwise return false..
