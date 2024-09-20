package com.advancia.ITextPdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.TextChunk;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.ILeafElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.text.Chunk;

public class UserListToPdf {

	public static final String Destination = "src/main/resources/com/advancia/PDF/BillTest.pdf";

	public static void main(String[] args) throws IOException {

		File file = new File(Destination);
		file.getParentFile().mkdirs();
		new UserListToPdf().CreatePdf(Destination);
	}

	void CreatePdf(String destination) throws IOException {

		// Initialize PDF Writer
		FileOutputStream fos = new FileOutputStream(destination);
		PdfWriter writer = new PdfWriter(fos);

		// Initialize Pdf document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document document = new Document(pdf);

		// TITLE SECTION
		document.add(new Paragraph("fattura\n").setFontSize(40).setBold());

		// FROM SECTION
		document.add(new Paragraph("DA").setFontSize(20));
		document.add(new Paragraph("Quirino Fiorentiono\n" + "Via alfredo Fusco 108\n" + "26100 Cava Tigozzi (CR)"))
				.setFontSize(15);

		// BILL DATA SECTION ToDo:RemoveBorder
		document.add(new Table(new float[] { 1, 1 })
				.addCell(new Paragraph("FATTURA #").setFontSize(15)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("IT-001").setFontSize(10)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("DATA DI FATTURA").setFontSize(15)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("29/01/2019").setFontSize(10)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("P.O.#").setFontSize(15)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("1630/2019").setFontSize(10)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("DATA DI SCADENZA").setFontSize(15)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("20/01/2019").setFontSize(10)).setBorder(Border.NO_BORDER)
				.setHorizontalAlignment(HorizontalAlignment.RIGHT)
				.setRelativePosition(0, -100, 0, 0));

		// FATTURARE TABLE SECTION
		document.add(new Table(new float[] {1})
				.addCell(new Paragraph("FATTURARE").setFontSize(15)).setBorder(null)			
				.addCell(new Paragraph("Angelo Muzio").setFontSize(10)).setBorder(null)								
				.addCell(new Paragraph("Via Piave, 887").setFontSize(10)).setBorder(null)
				.addCell(new Paragraph("00187 Roma (RM)").setFontSize(10)).setBorder(null)
				.setRelativePosition(0, -70, 0, 0).setBorder(null));
				
		// INVIARE TABLE SECTION
		document.add(new Table(new float[] {1})
				.addCell(new Paragraph("INVIARE A").setFontSize(15)).setBorder(null)			
				.addCell(new Paragraph("Angelo Muzio").setFontSize(10)).setBorder(null)			
				.addCell(new Paragraph("Via Piccinni 375").setFontSize(10)).setBorder(null)				
				.addCell(new Paragraph("82030 Torello (BN)").setFontSize(10)).setBorder(null)
				.setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setRelativePosition(0, -156, 0, 0).setBorder(null));

		
		//DETAILS TABLE SECTION
		document.add(new Table(new float[] {1,8,4,2})
				.addCell(new Paragraph("QTA'").setFontSize(15).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER))	
				.addCell(new Paragraph("DESCRIZIONE").setFontSize(15).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))			
				.addCell(new Paragraph("PREZZO PER UNITA'").setFontSize(15).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))							
				.addCell(new Paragraph("VALORE").setFontSize(15).setBorder(new SolidBorder(1)).setBorderLeft(Border.NO_BORDER))
				.addCell(new Paragraph("1'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER))
				.addCell(new Paragraph("Grande caffettiera d'argeto").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))			
				.addCell(new Paragraph("100.00'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))						
				.addCell(new Paragraph("100.00").setFontSize(10).setBorder(new SolidBorder(1)).setBorderLeft(Border.NO_BORDER))
				.addCell(new Paragraph("2'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER))		
				.addCell(new Paragraph("Quattro formaggi panzerotti").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))			
				.addCell(new Paragraph("12.00'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))							
				.addCell(new Paragraph("24.00").setFontSize(10).setBorder(new SolidBorder(1)).setBorderLeft(Border.NO_BORDER))
				.addCell(new Paragraph("3'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER))
				.addCell(new Paragraph("Scarpe in pelle").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))			
				.addCell(new Paragraph("5.00'").setFontSize(10).setBorder(new SolidBorder(1)).setBorderRight(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER))							
				.addCell(new Paragraph("15.00").setFontSize(10).setBorder(new SolidBorder(1)).setBorderLeft(Border.NO_BORDER))
				.setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setRelativePosition(0, -120, 0, 0).setBorder(null));
				
		// SUBTOTAL IVA SECTION
		document.add(new Table(new float[] {3,1})
				.addCell(new Paragraph("Subtotale").setFontSize(10)).setBorder(Border.NO_BORDER)			
				.addCell(new Paragraph("139.00").setFontSize(10)).setBorder(Border.NO_BORDER)
				.addCell(new Paragraph("IVA 22.0%").setFontSize(10)).setBorder(Border.NO_BORDER)			
				.addCell(new Paragraph("30.58").setFontSize(10)).setBorder(Border.NO_BORDER)
				.setHorizontalAlignment(HorizontalAlignment.RIGHT)
				.setRelativePosition(0, -100, 0, 0).setBorder(null));
		
		// TOTAL SECTION
		document.add(new Table(new float[] {1,1})
				.addCell(new Paragraph("TOTALE			").setFontSize(20).setBold().setBorder(new SolidBorder(3)).setBorderRight(Border.NO_BORDER))		
				.addCell(new Paragraph("169.58").setFontSize(20).setBold().setBorder(new SolidBorder(3)).setBorderLeft(Border.NO_BORDER))
				.setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setRelativePosition(0, -80, 0, 0));
		
		
		
		//TERMS AND CONDITIONS SECTION
		document.add(new Table(new float[] {1})
				.addCell(new Paragraph("TERMINI E CONDIZIONI").setFontSize(15).setBorder(Border.NO_BORDER))		
				.addCell(new Paragraph("Il pagamento è dovuto entro 15 giorni").setFontSize(10).setBorder(Border.NO_BORDER))
				.addCell(new Paragraph("Associazione Bancaria Italiana").setFontSize(10).setBorder(Border.NO_BORDER))
				.addCell(new Paragraph("IBAN: IT2 1234 5678 9012 34").setFontSize(10).setBorder(Border.NO_BORDER))
				.addCell(new Paragraph("SWIFT/BIC: ABCDITR1XXX").setFontSize(10).setBorder(Border.NO_BORDER))
				.setHorizontalAlignment(HorizontalAlignment.LEFT)
				.setRelativePosition(0, -50, 0, 0));
		
		//SIGNATURE SECTION
				ImageData imgData = ImageDataFactory.create("src/main/resources/com/advancia/Image/FirmaFattura.png");
				Image img = new Image(imgData);
				img.setAutoScale(false);
				img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
				img.setPageNumber(0);
				img.setRelativePosition(0, 0, 0, 0);
				document.add(img);
				
				
		// Close document
		document.close();
		System.out.println("PDF Created");
	}
}
