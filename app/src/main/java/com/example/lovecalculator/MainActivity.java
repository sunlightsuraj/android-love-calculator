package com.example.lovecalculator;

import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String ss = "";

	// int a;

	private int calcvalue(char str) {
		int i, f = 0, n = 0;

		for (i = 0; i < ss.length(); i++) {
			if (ss.charAt(i) == str) {
				f += 1;
				break;
			}
		}
		ss = ss + str;
		if (f == 0) {
			i = str;
			n = i % 2 + i % 10 + i % 8;
			if (i % 16 < 10) {
				n += i % 16;
			}

		}
		return (n);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button calcbutton = (Button) findViewById(R.id.button1);
		final EditText name1 = (EditText) findViewById(R.id.name1);
		final EditText name2 = (EditText) findViewById(R.id.name2);
		final TextView result=(TextView) findViewById(R.id.textView2);
		

		calcbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String s1 = name1.getText().toString();
				String s2 = name2.getText().toString();
				if (!s1.isEmpty() && !s2.isEmpty()) {
					String st;
					int i, v, s = 0;
					int r;
					s1 = s1.toUpperCase(Locale.getDefault());
					s2 = s2.toUpperCase(Locale.getDefault());

					for (i = 0; i < s1.length(); i++) {
						if (s1.charAt(i) == ' ') {
							// v = calcvalue(s1.charAt(i));
							// s += v;
							break;
						}
						v = calcvalue(s1.charAt(i));
						s += v;
					}

					for (i = 0; i < s2.length(); i++) {
						if (s2.charAt(i) == ' ') {
							// v = calcvalue(s2.charAt(i));
							// s += v;
							break;
						}
						v = calcvalue(s2.charAt(i));
						s += v;
					}
					ss = "";
					r = (int) (Math.random() * 10);
					if (r != 0)
						s += r;
					else
						s -= 5;
					if (s > 100) {
						i = s % 100;
						s -= i * 2;
					}
					if (s <= 90)
						s += 9;
					else if (s <= 95)
						s += 4;
					if (s < 5 && s > 0) {
						s += 10;
					}
					if (s <= 0) {
						s = r * 2;
					}
					st = String.valueOf(s);
					result.setText(s1+"+"+s2+"="+st);
					/*Toast.makeText(getApplicationContext(), st,
							Toast.LENGTH_LONG).show();*/
				} else {
					Toast.makeText(getApplicationContext(), "No Input",
							Toast.LENGTH_LONG).show();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Function to calculate ascii value

}
