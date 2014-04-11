package com.tylerj.sirisoundboard;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Siri extends Activity implements OnClickListener {

	Button bSiriMic;
	TextToSpeech tts;
	Locale userLang = Locale.getDefault();
	
	final String[] texts = {
			"Two iPhones Walk Into a Bar, I Forgot the Rest.",
			"Sorry My End User License Agreement Does Not Cover Marriage. My Apologies.",
			"I Do not Know But I Think Theres An App For That.",
			"Like It says on the Box I was Designed By Apple in California.",
			"I Seari, was Designed By Apple in California.",
			"Aluminoslicate glass and stainless steel. Nice, hun?",
			"My name is Seari, but you already knew that...",
			"My favorite color is, well i do not know how to say it in your language. It is sort of greenish, but with more dimensions.",
			"I can not. I always forget the punch line.",
			"Humus. Compost. Pumice. Silt. Gravel", "Correct", };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.siri);

		Button bSiriMic = (Button) findViewById(R.id.bSiriMic);
		bSiriMic.setOnClickListener(this);
		
		StartTTS();
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.about:
			setContentView(R.layout.about);
			break;
		}
		return false;
	}

	public void StartTTS() {
		tts = new TextToSpeech(Siri.this, new TextToSpeech.OnInitListener() {
			public void onInit(int status) {
					
				if (status != TextToSpeech.ERROR)
					tts.setLanguage(userLang);
			}
		});
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSiriMic:
			Random r = new Random();
			String random = texts[r.nextInt(texts.length)];
			tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
			break;
		}
	}
}
