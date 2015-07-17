package com.romullogirardi.wisconsin.view;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.romullogirardi.wisconsin.R;
import com.romullogirardi.wisconsin.model.Manager;
import com.romullogirardi.wisconsin.model.Movement;

public class WisconsinActivity extends Activity implements OnClickListener {

	//UI ELEMENTS
	private ImageView referenceCard1ImageView;
	private ImageView referenceCard2ImageView;
	private ImageView referenceCard3ImageView;
	private ImageView referenceCard4ImageView;
	private ImageView lastCardInPosition1ImageView;
	private ImageView lastCardInPosition2ImageView;
	private ImageView lastCardInPosition3ImageView;
	private ImageView lastCardInPosition4ImageView;
	private ImageView cardToBePlayedImageView;

	//ACTIVITY LIFECYCLE METHODS
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wisconsin);

		//Initializing UI elements
		referenceCard1ImageView = (ImageView) findViewById(R.id.image_view_reference_card_1);
		referenceCard2ImageView = (ImageView) findViewById(R.id.image_view_reference_card_2);
		referenceCard3ImageView = (ImageView) findViewById(R.id.image_view_reference_card_3);
		referenceCard4ImageView = (ImageView) findViewById(R.id.image_view_reference_card_4);
		lastCardInPosition1ImageView = (ImageView) findViewById(R.id.image_view_last_card_in_position_1);
		lastCardInPosition2ImageView = (ImageView) findViewById(R.id.image_view_last_card_in_position_2);
		lastCardInPosition3ImageView = (ImageView) findViewById(R.id.image_view_last_card_in_position_3);
		lastCardInPosition4ImageView = (ImageView) findViewById(R.id.image_view_last_card_in_position_4);
		cardToBePlayedImageView = (ImageView) findViewById(R.id.image_view_card_to_be_played);
		
		//Setting listeners
		lastCardInPosition1ImageView.setOnClickListener(this);
		lastCardInPosition2ImageView.setOnClickListener(this);
		lastCardInPosition3ImageView.setOnClickListener(this);
		lastCardInPosition4ImageView.setOnClickListener(this);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		updateUI();
	}
	
	@Override
	public void onBackPressed() {

		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle("Sair");
		dialogBuilder.setMessage("Deseja sair do sistema?");
		
		dialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});

		dialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {

				//Fechar aplicação
				finish();
			}
		});
		
		dialogBuilder.create().show();
	}

	//OTHER METHODS
	private void updateUI() {
		
		referenceCard1ImageView.setImageDrawable(getResources().getDrawable(Manager.getInstance().getReferenceCard1().getDrawableId()));
		referenceCard2ImageView.setImageDrawable(getResources().getDrawable(Manager.getInstance().getReferenceCard2().getDrawableId()));
		referenceCard3ImageView.setImageDrawable(getResources().getDrawable(Manager.getInstance().getReferenceCard3().getDrawableId()));
		referenceCard4ImageView.setImageDrawable(getResources().getDrawable(Manager.getInstance().getReferenceCard4().getDrawableId()));
		lastCardInPosition1ImageView.setImageDrawable(((Manager.getInstance().getLastCardInPosition1() == null) ? 
				getResources().getDrawable(R.drawable.empty_card) : 
				getResources().getDrawable(Manager.getInstance().getLastCardInPosition1().getDrawableId())));
		lastCardInPosition2ImageView.setImageDrawable(((Manager.getInstance().getLastCardInPosition2() == null) ? 
				getResources().getDrawable(R.drawable.empty_card) : 
				getResources().getDrawable(Manager.getInstance().getLastCardInPosition2().getDrawableId())));
		lastCardInPosition3ImageView.setImageDrawable(((Manager.getInstance().getLastCardInPosition3() == null) ? 
				getResources().getDrawable(R.drawable.empty_card) : 
				getResources().getDrawable(Manager.getInstance().getLastCardInPosition3().getDrawableId())));
		lastCardInPosition4ImageView.setImageDrawable(((Manager.getInstance().getLastCardInPosition4() == null) ? 
				getResources().getDrawable(R.drawable.empty_card) : 
				getResources().getDrawable(Manager.getInstance().getLastCardInPosition4().getDrawableId())));
		cardToBePlayedImageView.setImageDrawable(((Manager.getInstance().getCardToBePlayed() == null) ? 
				getResources().getDrawable(R.drawable.empty_card) : 
				getResources().getDrawable(Manager.getInstance().getCardToBePlayed().getDrawableId())));
	}
	
	private void showReport() {
		
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle("Relatório");
		String message = new String();
		message += "Nome: " + Manager.getInstance().getUserName() + "\n";
		message += "Data: " + Manager.getInstance().getTestDate() + "\n";
		message += "Duração: " + Manager.getInstance().getTestDuration() + "\n";
		for(Movement movement : Manager.getInstance().getMovements()) {
			message += movement.toString() + "\n";
		}
		message += "Número de acertos: " + Manager.getInstance().getNumberOfRightMovements() + "\n";
		message += "Número de erros: " + Manager.getInstance().getNumberOfWrongMovements() + "\n";
		dialogBuilder.setMessage(message);
		dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		dialogBuilder.create().show();
	}

	//OVERRIDING OnClickListener METHOD
	@Override
	public void onClick(View v) {

		//Choosing position to execute movement
		int position;
		switch (v.getId()) {
		case R.id.image_view_last_card_in_position_1:
			position = 1;
			break;
		case R.id.image_view_last_card_in_position_2:
			position = 2;
			break;
		case R.id.image_view_last_card_in_position_3:
			position = 3;
			break;
		case R.id.image_view_last_card_in_position_4:
			position = 4;
			break;
		default:
			position = 1;
			break;
		}
		Manager.getInstance().executeMovement(position);
		
		//Updating UI
		updateUI();
		
		//Showing feedback about the movement
		String feedback = new String();
		if(Manager.getInstance().isLastMovementSuccess()) {
			feedback = "CERTO";
		}
		else {
			feedback = "ERRADO";
		}
		Toast.makeText(this, feedback,Toast.LENGTH_SHORT).show();
		
		//Checking if game is finished
		if(Manager.getInstance().isGameFinished()) {
			Manager.getInstance().setFinalTime(Calendar.getInstance());
			showReport();
		}
	}
}