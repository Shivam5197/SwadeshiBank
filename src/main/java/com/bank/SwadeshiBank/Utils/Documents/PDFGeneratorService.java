package com.bank.SwadeshiBank.Utils.Documents;

import java.util.Map;

public interface PDFGeneratorService {

    public byte[] generateWelcomePDF(String HtmlData , String password);
    public String loadAndFillTemplate(String templatePath, Map<String, String> replacements) throws Exception ;

}
