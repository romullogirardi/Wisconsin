package com.romullogirardi.wisconsin.view;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.romullogirardi.wisconsin.R;
import com.romullogirardi.wisconsin.model.Manager;

public class MainActivity extends Activity implements OnClickListener{

	//UI ELEMENTS
	private EditText userNameEditText;
	private Button submitUserNameButton;

	//ACTIVITY LIFECYCLE METHODS
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		userNameEditText = (EditText) findViewById(R.id.edit_text_user_name);
		submitUserNameButton = (Button) findViewById(R.id.button_submit_user_name);
		submitUserNameButton.setOnClickListener(this);
	}

	//OVERRIDING OnClickListener METHOD
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.button_submit_user_name:
				String userName = userNameEditText.getText().toString();
				if(!userName.isEmpty()) {
					Manager.getInstance().setUserName(userName);
					Manager.getInstance().setInitialTime(Calendar.getInstance());
					startActivity(new Intent(this, WisconsinActivity.class));
					finish();
				}
				else {
					Toast.makeText(this, getResources().getString(R.string.preencha_o_nome_do_paciente), Toast.LENGTH_LONG).show();
				}
				break;
			default:
				break;
		}
	}
}