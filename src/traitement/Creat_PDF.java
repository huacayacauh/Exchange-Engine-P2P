package traitement;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

/**
 * class permet de generer un contrat sous format PDF
 */

public class Creat_PDF {

	public static final String RESULT = "../XML_engine/src/PDF/Contrat.pdf";
	public static Paragraph addTitle(){
		Font fontbold = FontFactory.getFont("Times-Roman", 40, Font.BOLD);
		Paragraph p = new Paragraph("Contrat d'échange ", fontbold);
		p.setSpacingAfter(20);
		p.setAlignment(1);
		return p;
	}
	public void createPdf(String filename,String per1,String per2
			,String per3,
			String obj1,String obj2,String obj3,String clause,String mode,
			String montant,String personne,String taxe,
			String date)
					throws IOException, DocumentException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		document.add(addTitle());
		document.add(Chunk.NEWLINE);


		Chunk CONNECT = new Chunk(
				new LineSeparator(0.5f, 95, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER, 3.5f));
		LineSeparator UNDERLINE =
				new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
		@SuppressWarnings("deprecation")
		Chunk tab1 = new Chunk(new VerticalPositionMark(), 200, true);

		@SuppressWarnings("deprecation")
		Chunk tab3 = new Chunk(new DottedLineSeparator(), 450, true);
		Paragraph p = new Paragraph("Personnes concernées :");
		p.add(CONNECT);
		p.add(UNDERLINE);
		document.add(p);


		p = new Paragraph(per1);
		p.add(new Chunk(tab1));
		p.add(new Chunk(tab3));

		
		document.add(p);
		p = new Paragraph(per2);
		p.add(new Chunk(tab1));
		p.add(new Chunk(tab3));


		document.add(p);
		if(per3.equals(""))
			per3="Inconnu";
		p = new Paragraph(per3);
		p.add(new Chunk(tab1));
		p.add(new Chunk(tab3));
		
		document.add(p);
		document.add(Chunk.NEWLINE);

		Paragraph p1 = new Paragraph("objet concernées :");

		p1.add(CONNECT);
		p1.add(UNDERLINE);
		document.add(p1);
		p1 = new Paragraph(obj1);
		p1.add(new Chunk(tab1));

		
		document.add(p1);
		p1= new Paragraph(obj2);
		p1.add(new Chunk(tab1));
		document.add(p1);
		if(obj3.equals(""))
			obj3="Inconnu";
		p1 = new Paragraph(obj3);
		p1.add(new Chunk(tab1));

		document.add(p1);
		document.add(Chunk.NEWLINE);
		Paragraph p3 = new Paragraph("Clause de rupture :");
		p3.add(CONNECT);
		p3.add(UNDERLINE);
		document.add(p3);
		p3 = new Paragraph(clause);
		p3.add(new Chunk(tab1));
		document.add(p3);

		document.add(Chunk.NEWLINE);

		Paragraph p4 = new Paragraph("Mode de résolution :");

		p4.add(CONNECT);
		p4.add(UNDERLINE);
		document.add(p4);
		p4 = new Paragraph(mode);
		p4.add(new Chunk(tab1));
		document.add(p4);

		document.add(Chunk.NEWLINE);
		Paragraph p6 = new Paragraph("Montant de la taxe :");
		p6.add(CONNECT);
		p6.add(UNDERLINE);
		document.add(p6);
		p6 = new Paragraph(montant);
		p6.add(new Chunk(tab1));
		document.add(p6);
		document.add(Chunk.NEWLINE);


		Paragraph p7 = new Paragraph("Taxe due a  :");
		p7.add(CONNECT);
		p7.add(UNDERLINE);
		document.add(p7);
		p7 = new Paragraph(taxe);
		p7.add(new Chunk(tab1));
		document.add(p7);
		document.add(Chunk.NEWLINE);
		
		
		Paragraph p8 = new Paragraph("Date limite de réception :");
		p8.add(CONNECT);
		p8.add(UNDERLINE);
		document.add(p8);
		p8= new Paragraph(date);
		p8.add(new Chunk(tab1));
		document.add(p8);
		document.add(Chunk.NEWLINE);

		document.add(new Paragraph("Accusé de réception des informations\n Signature des consommateurs: ."));

		document.close();

	}


}