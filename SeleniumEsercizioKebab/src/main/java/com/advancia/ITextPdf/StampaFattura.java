package com.advancia.ITextPdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.BorderRadius;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

public class StampaFattura {

	public static final String Destination = "src/main/resources/com/advancia/PDF/EsercizioFattura.pdf";

	public static void main(String[] args) throws IOException {

		File file = new File(Destination);
		file.getParentFile().mkdirs();
		new StampaFattura().CreatePdf(Destination);
	}

	private void CreatePdf(String destination) throws IOException {

		// Initialize PDF Writer
		FileOutputStream fos = new FileOutputStream(destination);
		PdfWriter writer = new PdfWriter(fos);

		// Initialize Pdf document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document doc = new Document(pdf);

		// PARAMETERS
		Cell cell;
		DeviceRgb darkBlue = new DeviceRgb(0, 0, 139);
		DeviceRgb cyan = new DeviceRgb(0, 180, 255);
		DeviceRgb gray = new DeviceRgb(200, 200, 200);
		DeviceRgb white = new DeviceRgb(255, 255, 255);
		DeviceRgb yellow = new DeviceRgb(255, 211, 0);

		// HEADER SECTION
		Table headerTable = new Table(UnitValue.createPercentArray(new float[] { 70, 30 })).useAllAvailableWidth();
		// LEFT TABLE CONTENT (Personal Data)
		Table headerPersonalDataTable = new Table(1);
		newNoBorderCellToTable(headerPersonalDataTable, "Mario Rossi Architetto", true, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(headerPersonalDataTable, "Via Dei Gigli 200", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(headerPersonalDataTable, "20100 Milano (MI)", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(headerPersonalDataTable, "02 98765 4321", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(headerPersonalDataTable, "mario.rossi@forfettario.it", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(headerPersonalDataTable, "Partita Iva 12345678910", false, 7, 0, TextAlignment.LEFT)
				.setPaddingTop(15);

		// Add the left table (headerPersonalDataTable) to the first column of the
		// header table
		cell = new Cell().add(headerPersonalDataTable);
		cell.setBorder(Border.NO_BORDER);
		cell.setHorizontalAlignment(HorizontalAlignment.LEFT); // Align to the left
		headerTable.addCell(cell);

		// RIGHT TABLE CONTENT (Logo and Company Info)
		Table headerCompanyDataTable = new Table(1);

		ImageData datalogCompanyLogoImageData = ImageDataFactory
				.create("src/main/resources/com/advancia/Image/DatalogLogo.png");
		Image datalogCompanyLogoImage = new Image(datalogCompanyLogoImageData);

		newNoBorderCellToTable(headerCompanyDataTable, "Esempio Fattura", false, 7, 0, TextAlignment.CENTER);
		newNoBorderCellToTable(headerCompanyDataTable, "elaborato da:", false, 7, 0, TextAlignment.CENTER);
		// Image
		cell = new Cell().add(datalogCompanyLogoImage.setAutoScale(true));
		cell.setBorder(Border.NO_BORDER);
		headerCompanyDataTable.addCell(cell);
		newNoBorderCellToTable(headerCompanyDataTable, "www.datalog.it", false, 7, 0, TextAlignment.CENTER)
				.setUnderline().setFontColor(cyan);

		// Add the company data table to the second column of the header table
		cell = new Cell().add(headerCompanyDataTable);
		cell.setBorder(Border.NO_BORDER);
		cell.setHorizontalAlignment(HorizontalAlignment.RIGHT); // Align to the right
		headerTable.addCell(cell);

		// Add the combined header table to the document
		doc.add(headerTable);

		// BLACK SEPARATING LINE
		Table blackLineTable = new Table(UnitValue.createPercentArray(new float[] { 100 })).useAllAvailableWidth();
		blackLineTable.setBackgroundColor(new DeviceRgb(0, 0, 0));
		cell = new Cell().add(new Paragraph());
		blackLineTable.addCell(cell);
		blackLineTable.setMarginTop(20);
		doc.add(blackLineTable);

		// BODY
		// UPPDER BODY
		Table upperBodyTable = new Table(UnitValue.createPercentArray(new float[] { 70, 30 })).useAllAvailableWidth()
				.setMarginTop(20);
		// Left DataTable
		Table spettLeTable = new Table(1).setBackgroundColor(gray, 0.2f).useAllAvailableWidth();

		newNoBorderCellToTable(spettLeTable, "SPETT.LE", true, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "Bianchini SPA", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "Piazza del Popolo 1", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "22100 Como", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "0331 98 765 4321", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "amministrazione@bianchini-spa.it", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(spettLeTable, "Parita Iva 198765432", false, 7, 0, TextAlignment.LEFT).setPaddingTop(15);
		newNoBorderCellToTable(spettLeTable, "Codice SDI: 0000000", false, 7, 0, TextAlignment.LEFT);
		// Add the SpeetLe table to the first column of the upper body table
		cell = new Cell().add(spettLeTable);
		cell.setBorder(Border.NO_BORDER);
		cell.setHorizontalAlignment(HorizontalAlignment.LEFT); // Align to the right
		upperBodyTable.addCell(cell);

		// RIGHT Fattura Table
		Table fatturaTable = new Table(2).setRelativePosition(0, -20, 0, 0).setMarginLeft(20);
		newNoBorderCellToTable(fatturaTable, "Fattura", false, 20, 0, TextAlignment.LEFT).setFontColor(cyan);
		newNoBorderCellToTable(fatturaTable, "", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(fatturaTable, "NUMERO:", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(fatturaTable, "25", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(fatturaTable, "DATA:", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(fatturaTable, "31/03/2019:", false, 7, 0, TextAlignment.LEFT);
		// Add the Fattura table to the second column of the upper body table
		cell = new Cell().add(fatturaTable);
		cell.setBorder(Border.NO_BORDER);
		cell.setHorizontalAlignment(HorizontalAlignment.RIGHT); // Align to the right
		upperBodyTable.addCell(cell);

		doc.add(upperBodyTable);

		// MIDDLE BODY
		Table middleBodyTable = new Table(1).setMarginTop(20);
		newNoBorderCellToTable(middleBodyTable, "CONDIZIONI DI PAGAMENTO", true, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(middleBodyTable, "Pagamento con Bonifico Bancario", false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(middleBodyTable,
				"Attività svolta per vostro conto per i mesi di Gennaio e febbraio 2019", true, 7, 0,
				TextAlignment.LEFT).setMarginTop(15);
		;
		doc.add(middleBodyTable);

		// LOWER BODY
		Table lowerBodyTable = new Table(UnitValue.createPercentArray(new float[] { 60, 10, 10, 20 }))
				.useAllAvailableWidth().setMarginTop(20);
		newNoBorderCellToTable(lowerBodyTable, "DETTAGLI ATTIVITA'", true, 7, 0, TextAlignment.CENTER)
				.setBackgroundColor(darkBlue).setFontColor(white);
		newNoBorderCellToTable(lowerBodyTable, "Q.TA'", true, 7, 0, TextAlignment.CENTER).setBackgroundColor(darkBlue)
				.setFontColor(white);
		newNoBorderCellToTable(lowerBodyTable, "PREZZO", true, 7, 0, TextAlignment.CENTER).setBackgroundColor(darkBlue)
				.setFontColor(white);
		newNoBorderCellToTable(lowerBodyTable, "IMPORTO", true, 7, 0, TextAlignment.CENTER).setBackgroundColor(darkBlue)
				.setFontColor(white);

		newNoBorderCellToTable(lowerBodyTable, "Progettazione costri uffici direzionali", false, 7, 0,
				TextAlignment.LEFT).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "2,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "250,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "500,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(gray, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));

		newNoBorderCellToTable(lowerBodyTable, "Planimetrie catastali", false, 7, 0, TextAlignment.LEFT)
				.setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "1,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "200,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "200,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(gray, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));

		newNoBorderCellToTable(lowerBodyTable, "sopralluogo di 4 ore a tariffa oraria", false, 7, 0, TextAlignment.LEFT)
				.setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "4,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "50,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "200,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(gray, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));

		newNoBorderCellToTable(lowerBodyTable, "Sconto riservato (come da accordi)", false, 7, 0, TextAlignment.LEFT)
				.setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT).setBackgroundColor(yellow, 0.2f)
				.setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "-100,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(yellow, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));
		newNoBorderCellToTable(lowerBodyTable, "-100,00", false, 7, 0, TextAlignment.RIGHT)
				.setBackgroundColor(gray, 0.2f).setBorderBottom(new SolidBorder(cyan, 1));

		// EmptyROWS
		int cellCounter = 0;
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 4; j++) {

				cellCounter++;
				cell = new Cell();
				if (cellCounter > 1 && cellCounter <= 3)
					cell.setBackgroundColor(yellow, 0.2f);

				if (cellCounter == 4) {
					cell.add(new Paragraph("0,00").setFontSize(7).setTextAlignment(TextAlignment.RIGHT));
					cell.setBackgroundColor(gray, 0.2f);
					cellCounter = 0;
				}
				cell.setBorder(Border.NO_BORDER);
				cell.setBorderBottom(new SolidBorder(cyan, 1));
				lowerBodyTable.addCell(cell);
			}

		newNoBorderCellToTable(lowerBodyTable, "Grazie per averci scelto!", true, 7, 0, TextAlignment.LEFT)
				.setBackgroundColor(yellow, 0.2f);
		newNoBorderCellToTable(lowerBodyTable, "", false, 0, 0, TextAlignment.LEFT).setBackgroundColor(yellow, 0.2f);
		newNoBorderCellToTable(lowerBodyTable, "", false, 0, 0, TextAlignment.LEFT).setBackgroundColor(yellow, 0.2f);
		newNoBorderCellToTable(lowerBodyTable, "", false, 0, 0, TextAlignment.LEFT).setBackgroundColor(gray, 0.2f);

		newNoBorderCellToTable(lowerBodyTable, "SUBTOTALE", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€800,00", false, 7, 0, TextAlignment.RIGHT).setBackgroundColor(gray,
				0.2f);

		newNoBorderCellToTable(lowerBodyTable, "CONTRIBUTO INTEGRATIVO INARCASSA", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "4%", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€32,00", false, 7, 0, TextAlignment.RIGHT).setBackgroundColor(gray,
				0.2f);

		newNoBorderCellToTable(lowerBodyTable, "IMPOSTA DI BOLLO", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€2,00", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€2,00", false, 7, 0, TextAlignment.RIGHT).setBackgroundColor(gray,
				0.2f);

		newNoBorderCellToTable(lowerBodyTable, "ALTRE SPESE", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€0,00", false, 7, 0, TextAlignment.RIGHT).setBackgroundColor(gray,
				0.2f);

		newNoBorderCellToTable(lowerBodyTable, "TOTALE", true, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "", false, 7, 0, TextAlignment.RIGHT);
		newNoBorderCellToTable(lowerBodyTable, "€834,00", true, 7, 0, TextAlignment.RIGHT).setBackgroundColor(gray,
				0.2f);

		doc.add(lowerBodyTable);

		// FOOTER
		
		// COMMENT TABLE
		Table commentTable = new Table(1).setBackgroundColor(gray,0.2f);
		
		cell = new Cell().setBorderTopLeftRadius(new BorderRadius(5)).setBorderTopRightRadius(new BorderRadius(5));	
		cell.add(new Paragraph("NOTE E COMMENTI")).setBold().setFontSize(7).setUnderline();	
		cell.setBorder(Border.NO_BORDER);
		commentTable.addCell(cell);
		
		cell = new Cell().setBackgroundColor(gray,0.2f);	
		cell.add(new Paragraph("NOTE E COMMENTI")).setBold().setFontSize(7).setUnderline();	
		commentTable.addCell(cell);
			
		doc.add(commentTable);

		
		
		// LEGAL NOTES TABLE
		Table legalNotesTable = new Table(1).setBorder(new SolidBorder(1)).setMarginTop(15).setBackgroundColor(gray,
				0.2f);
		newNoBorderCellToTable(legalNotesTable, "NOTE LEGALI", true, 7, 0, TextAlignment.LEFT).setUnderline();
		cell = new Cell().setBorder(Border.NO_BORDER).setPaddingTop(10);
		Paragraph combinedParagraph = new Paragraph()
				.add(new Text("imposta di bollo (identificativo n°) ").setFontSize(7))
				.add(new Text("0123456789 ").setFontSize(7).setBold())
				.add(new Text("assolta sull'originale per importi maggiori di 77,47€").setFontSize(7));
		combinedParagraph.setTextAlignment(TextAlignment.LEFT);
		legalNotesTable.addCell(cell);
		newNoBorderCellToTable(legalNotesTable,
				"operazione effettuata ai sensi dell'articolo 1, commi da 54 a 89, delle Legge n.190/2014 cosi come modificato dalla Legge",
				false, 7, 0, TextAlignment.LEFT);
		newNoBorderCellToTable(legalNotesTable,
				"numero 208/2015 e dalla Legge 145/2018.si richiede la non applicazione della ritenuta alla fonte a titolo d'accorto ai sensi",
				false, 7, 0, TextAlignment.LEFT).setPaddingTop(10);
		doc.add(legalNotesTable);

		// Close document
		doc.close();
		System.out.println("PDF Creato");

	}

	private Cell newNoBorderCellToTable(Table headerPersonalDataTable, String text, boolean isBold, int fontSize,
			int padding, TextAlignment textAlignment) {
		Cell cell;
		cell = new Cell().add(new Paragraph(text));

		if (isBold)
			cell.setBold();

		cell.setFontSize(fontSize);
		cell.setBorder(Border.NO_BORDER);
		cell.setPadding(padding);
		cell.setTextAlignment(textAlignment);
		headerPersonalDataTable.addCell(cell);
		return cell;
	}

	
	private void drawRoundedRectangle(PdfDocument pdfDoc, PdfPage page, float x, float y, float width, float height, float radius, Color color) {
	    PdfCanvas canvas = new PdfCanvas(page);
	    canvas.setFillColor(color);
	    canvas.roundRectangle(x, y, width, height, radius);
	    canvas.fill();
	}
}
