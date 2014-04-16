<h1> Android Bubble Progress Bar SDK</h1>

Bored with traditional Progress Bars !! Don't worry we have a great solution for you.

Now Get the stylished Progress Bar in just 2 easy steps.

<h1> SDK Android Version Compatibility</h1>

SDK designed for use with Android devices and simulators. Requires Android 2.3 or later.

<h1> How to use this SDK</h1>

Step 1 ->

  Add the below code into yourxml layout file.
  
   com.sunny.bubbleprogressbar.BubbleProgressBar
        android:id="@+id/bubble_progress_bar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_gravity="center_vertical|center_horizontal"
        android:layout_marginTop="20dp"
        android:gravity="center_horizontal|center_vertical"
        android:visibility="visible" >
    com.sunny.bubbleprogressbar.BubbleProgressBar
    


<br>
Step 2 ->

  Get the xml element reference by <br>
  <br>bubbleProgressBar = (BubbleProgressBar) findViewById(R.id.bubble_progress_bar);
  
  
  1. Start the progress ->
  
  bubbleProgressBar.startAnimation();
  
  
  2. Stop the progress ->
  
  bubbleProgressBar.stopAnimation();<br>
  
  
  3. Check if the progress is started or stopped
  
  bubbleProgressBar.isAnimating() -> returns true if already started otherwise return false.

  
