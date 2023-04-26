package com.jira.jiraApi.controllers;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jira.jiraApi.LoginRequest;
import com.jira.jiraApi.Models.User;
import com.jira.jiraApi.Services.UserServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class JiraController {
    @GetMapping("/errores")
    public Map<String, Object> erroresJira()
            throws ClientProtocolException, IOException, JSONException {
        String url = "https://test-mesa-ayuda.atlassian.net/rest/api/3/search?jql=project=Test";
        String email = "salvador243gm@gmail.com";
        String apiToken = "ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A";

        // Crear la conexión HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Configurar el método HTTP y las cabeceras
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Basic " + getAuthString(email, apiToken));

        // Obtener la respuesta
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Map<String, Object> dict = new HashMap<String, Object>();
        dict.put("codigo", responseCode);
        dict.put("errores", response.toString());
        return dict;
    }

    @GetMapping("/usuarios")
    public Map<String, Object> usuariosJira() throws ClientProtocolException, IOException {
        String url = "https://test-mesa-ayuda.atlassian.net/rest/api/3/users/search";
        String email = "salvador243gm@gmail.com";
        String apiToken = "ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A";

        // Crear la conexión HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Configurar el método HTTP y las cabeceras
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Basic " + getAuthString(email, apiToken));

        // Obtener la respuesta
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Map<String, Object> dict = new HashMap<String, Object>();
        dict.put("codigo", responseCode);
        dict.put("usuarios", response.toString());
        return dict;
    }

    @GetMapping("/usuario/{accountId}")
    public Map<String, Object> usuarioIndividual(@PathVariable String accountId)
            throws ClientProtocolException, IOException {
        String url = "https://test-mesa-ayuda.atlassian.net/rest/api/3/user?accountId=" + accountId;
        String email = "salvador243gm@gmail.com";
        String apiToken = "ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A";
        // Crear la conexión HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Configurar el método HTTP y las cabeceras
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Basic " + getAuthString(email, apiToken));
        // con.setRequestProperty("accountId", accountId);

        // Obtener la respuesta
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Map<String, Object> dict = new HashMap<String, Object>();
        dict.put("codigo", responseCode);
        dict.put("usuarios", response.toString());
        return dict;
    }

    static String getAuthString(String email, String apiToken) {
        String auth = email + ":" + apiToken;
        return java.util.Base64.getEncoder().encodeToString(auth.getBytes());
    }

    private final String API_URL = "https://test-mesa-ayuda.atlassian.net/rest/api/3/issue";
    private final String USERNAME = "salvador243gm@gmail.com";
    private final String PASSWORD = "ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A";

    @PostMapping("/cargar")
    public ResponseEntity<String> uploadFile2(@RequestParam("id") String id,
            @RequestParam("file") MultipartFile file) throws IOException {
        URL url = new URL("https://test-mesa-ayuda.atlassian.net/rest/api/2/issue/" + id + "/attachments");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Authorization",
                "Basic " + Base64.getEncoder().encodeToString(
                        "salvador243gm@gmail.com:ATATT3xFfGF0PMr8HdwF5_464tWk3k5idRXCn45DmWI74HBNEQQv-ZQDtcwUVu7PKo7e2iNt2K7UR87ijh6kOnu5PDo4fENnqwPjHKRAS9bTIjF89p7kWGOtALSBymMPlLEPw0R7M29MbKhMFDeGqQGsjDZI-9dprGRZzCjM6tjWHiY6oBRo4Rc=1B4AD62A"
                                .getBytes()));

        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("X-Atlassian-Token", "no-check");
        String boundary = "Boundary-" + UUID.randomUUID().toString();
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        try (OutputStream output = conn.getOutputStream()) {
            // agregar parámetro "file"
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getOriginalFilename()
                    + "\"\r\n").getBytes());
            try (InputStream input = file.getInputStream()) {
                input.transferTo(output);
            }
            output.write("\r\n".getBytes());

            // cerrar body
            output.write(("--" + boundary + "--\r\n").getBytes());
        }

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (InputStream input = conn.getInputStream()) {
                byte[] responseBytes = input.readAllBytes();
                String response = new String(responseBytes, StandardCharsets.UTF_8);
            }
        } else {
            System.out.println("Error: " + conn.getResponseCode() + " " + conn.getResponseMessage());
        }
        return null;
    }

    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userServices.login(loginRequest.getCorreoElectronico(),
                loginRequest.getcontrasena());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }
    }
}