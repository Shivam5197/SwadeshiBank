package com.bank.SwadeshiBank.Utils.Documents;

import com.bank.SwadeshiBank.Utils.Mails.MailserviceImpl;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

@Service
public class PDFGeneratorServiceImpl implements PDFGeneratorService {


        private static final Logger LOGGER = LogManager.getLogger(PDFGeneratorServiceImpl.class);

        // This is the Util implementation for the PDF generation We can create any Kind of Document in the PDF format to send it to the user to maintain the confidentiality of the data
	
	public byte[] generateWelcomePDF(String HtmlData , String password){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter writer = new PdfWriter(outputStream , new WriterProperties().setStandardEncryption(
                    password.getBytes(),password.getBytes(),EncryptionConstants.ALLOW_PRINTING,
                    EncryptionConstants.ENCRYPTION_AES_128));

            PdfDocument pdfDocument = new PdfDocument(writer);
            //     LOGGER.info("This is HTML date" + HtmlData);
            HtmlConverter.convertToPdf(HtmlData, pdfDocument,null);

            pdfDocument.close();


        LOGGER.info("Returning : " + outputStream.toByteArray());
        return outputStream.toByteArray();
    }

    //templates/DocumentTemplets/WelcomePDF.html
        // Maps the content from the Html page with the Actual user data
        public String loadAndFillTemplate(String templatePath, Map<String, String> replacements) throws Exception {
                // Load the template file as a string
                File templateFile = new File(templatePath);
                String content = new String(Files.readAllBytes(templateFile.toPath()), StandardCharsets.UTF_8);

                // Replace placeholders with actual data
                for (Map.Entry<String, String> entry : replacements.entrySet()) {
                        content = content.replace("{{" + entry.getKey() + "}}", entry.getValue());
                }
                return content;
        }



}
