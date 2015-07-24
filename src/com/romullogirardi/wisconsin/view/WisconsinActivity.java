package com.romullogirardi.wisconsin.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.romullogirardi.wisconsin.R;
import com.romullogirardi.wisconsin.model.Constants;
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
	
	//SOUND ELEMENTS
	SoundPool mSoundPool;
	int rightSoundID;
	int wrongSoundID;
	int gameFinishedSoundID;

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
	protected void onStart() {
		super.onStart();
		
		//Initializing sound elements
		mSoundPool  = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		rightSoundID = mSoundPool.load(this, R.raw.certo, 1);
		wrongSoundID = mSoundPool.load(this, R.raw.errado, 1);
		gameFinishedSoundID = mSoundPool.load(this, R.raw.teste_finalizado, 1);
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
		
		//Showing feedback and playing sound about the movement
		String feedback;
		int soundID;
		if(Manager.getInstance().isLastMovementSuccess()) {
			feedback = "CERTO";
			soundID = rightSoundID;
		}
		else {
			feedback = "ERRADO";
			soundID = wrongSoundID;
		}
		Toast.makeText(this, feedback,Toast.LENGTH_SHORT).show();
		mSoundPool.play(soundID, 1f, 1f, 0, 0, 1f);
		
		//Checking if game is finished
		if(Manager.getInstance().isGameFinished()) {
			Manager.getInstance().setFinalTime(Calendar.getInstance());
			mSoundPool.play(gameFinishedSoundID, 1f, 1f, 0, 0, 1f);
			showPDFReport();
		}
	}
	
	//SHOWING PDF REPORT
	private void showPDFReport() {
		String pdfReportPath = createPdfReport();
		showPdfFile(pdfReportPath);
		finish();
	}
	
	@SuppressWarnings("deprecation")
	private String createPdfReport() {
        
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();

         try {
        	 	String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                File dir = new File(path);
                if(!dir.exists())
                    dir.mkdirs();

                String fileName = Constants.PDF_FILE_NAME + new Date().toGMTString() + ".pdf";
                File file = new File(dir, fileName);
                
                FileOutputStream fOut = new FileOutputStream(file);

                PdfWriter.getInstance(document, fOut);

                //open the document
                document.open();

                Paragraph title = new Paragraph("RELATÓRIO - TESTE DE WISCONSIN");
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));

                document.add(new Paragraph("Nome: " + Manager.getInstance().getUserName()));
                document.add(new Paragraph("Data: " + Manager.getInstance().getTestDate()));
                document.add(new Paragraph("Duração: " + Manager.getInstance().getTestDuration()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));

    			PdfPTable table = new PdfPTable(6);
    			table.setTotalWidth(6 * 88);
    			table.setLockedWidth(true);
    			table.addCell(createCell("Movimento"));
    			table.addCell(createCell("Estratégia corrente"));
    			table.addCell(createCell("Resultado"));
    			table.addCell(createCell("Mesma cor"));
    			table.addCell(createCell("Mesma forma"));
    			table.addCell(createCell("Mesmo número"));

        		for(int index = 0; index < Manager.getInstance().getMovements().size(); index++) {
        			
        			Movement movement = Manager.getInstance().getMovements().get(index);
        			table.addCell(createCell(String.valueOf(index + 1)));
        			table.addCell(createCell(movement.getCurrentStrategy().toString()));
        			table.addCell(createCell((movement.isSuccess()) ? "CERTO" : "ERRADO"));
        			table.addCell(createCell((movement.isColorSuccess()) ? "X" : ""));
        			table.addCell(createCell((movement.isShapeSuccess()) ? "X" : ""));
        			table.addCell(createCell((movement.isNumberSuccess()) ? "X" : ""));
        		}
    			document.add(table);

                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
        		document.add(new Paragraph("Número de acertos: " + Manager.getInstance().getNumberOfRightMovements()));
        		document.add(new Paragraph("Número de erros: " + Manager.getInstance().getNumberOfWrongMovements()));
                
                return path + "/" + fileName;
         } catch (DocumentException de) {
                 Log.e("PDFCreator", "DocumentException:" + de);
         } catch (IOException e) {
                 Log.e("PDFCreator", "ioException:" + e);
         } 
         finally {
        	 document.close();
         }
         return null;
    }
	
	private PdfPCell createCell(String text) {
		PdfPCell cell = new PdfPCell(new Phrase(text));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		return cell;
	}
	
	public void showPdfFile(String pdfPath) {
		File file = new File(pdfPath);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(intent);
	}
}