package com.cisco.fib;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FibActivity extends Activity {
	TextView textOut;
	EditText editN;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editN = (EditText)findViewById(R.id.edit_n);
        textOut = (TextView)findViewById(R.id.text_out);
    }
    
    public void onClick(View v) {
    		long n = Long.parseLong( editN.getText().toString() );
    		
    		// Java Recursive
    		long start = System.currentTimeMillis();
    		long fibJ = FibLib.fibJ(n);
    		long timeJ = System.currentTimeMillis() - start;
    		textOut.append( String.format("\nfibJ(%d)=%d (%d ms)", n, fibJ, timeJ) );
    		
    		// Native Recursive
    		start = System.currentTimeMillis();
    		long fibN = FibLib.fibN(n);
    		long timeN = System.currentTimeMillis() - start;
    		textOut.append( String.format("\nfibN(%d)=%d (%d ms)", n, fibN, timeN) );
    		
    		// Java Iterative
    		start = System.nanoTime();
    		long fibJI = FibLib.fibJI(n);
    		long timeJI = System.nanoTime() - start;
    		textOut.append( String.format("\nfibJI(%d)=%d (%d ns)", n, fibJI, timeJI) );
    		
    		// Native Iterative
    		start = System.nanoTime();
    		long fibNI = FibLib.fibNI(n);
    		long timeNI = System.nanoTime() - start;
    		textOut.append( String.format("\nfibNI(%d)=%d (%d ns)", n, fibNI, timeNI) );
    }
}