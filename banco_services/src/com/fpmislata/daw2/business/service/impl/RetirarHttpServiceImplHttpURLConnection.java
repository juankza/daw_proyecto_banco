package com.fpmislata.daw2.business.service.impl;

import com.fpmislata.daw2.business.domain.Extraccion;
import com.fpmislata.daw2.business.service.RetirarHttpService;
import com.fpmislata.daw2.core.exception.BusinessException;
import com.fpmislata.daw2.core.exception.BusinessMessage;
import com.fpmislata.daw2.core.json.JSONTransformer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;

public class RetirarHttpServiceImplHttpURLConnection implements RetirarHttpService {

    @Autowired
    JSONTransformer jsonTransformer;

    @Override
    public void retirar(String url, Extraccion extraccion) throws BusinessException {

        // StringBuilder stringBuilder = new StringBuilder();
        String requestBody = jsonTransformer.toJSON(extraccion);
        try {
            URL requestedUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) requestedUrl.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("charset", "utf-8");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(requestBody.getBytes("UTF-8"));
            outputStream.close();
            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                throw new BusinessException(new BusinessMessage("Petición retirada", "No se ha realizado correctamente."));
            }
        } catch (MalformedURLException ex) {
            throw new BusinessException(new BusinessMessage("URL Banco Central", "Está mal formada."));
        } catch (IOException ex) {

        }
    }

}
