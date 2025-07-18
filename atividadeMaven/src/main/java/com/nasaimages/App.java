// mvn compile
// mvn exec:java
package com.nasaimages;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
  public static void downloadImage(String imageUrl, String folderName, String fileName)
      throws IOException, InterruptedException {

    // Cria o caminho da pasta onde as imagens serão criadas e verifica se ela existe, se não cria a
    // pasta
    Path folderPath = Paths.get(folderName);
    if (!Files.exists(folderPath)) {
      Files.createDirectories(folderPath);
    }

    // Cria o caminho da imagem com o caminho da pasta e verifica se ela existe, se existir informa
    // que a imagem já está criada
    Path imagePath = folderPath.resolve(fileName);
    if (Files.exists(imagePath)) {
      throw new IOException(
          "Erro: a imagem \"" + fileName + "\" já existe em \"" + folderName + "\"");
    }

    HttpClient client = HttpClient.newHttpClient();
    // Faz o request da imagem
    HttpRequest imageRequest = HttpRequest.newBuilder().uri(URI.create(imageUrl)).build();
    // Pega a resposta do request no formato de bytes
    HttpResponse<InputStream> imageResponse =
        client.send(imageRequest, HttpResponse.BodyHandlers.ofInputStream());

    // Verifica o tipo de arquivo é realmente uma imagem, se não for o conteúdo não é baixado
    String contentType = imageResponse.headers().firstValue("Content-Type").orElse("");
    if (!contentType.startsWith("image/")) {
      throw new IOException("O conteúdo não é uma imagem: " + contentType);
    }

    // Cria o in que recebe os dados da imagem em byte e o out que abre o arquivo no caminho para
    // ser preenchido
    try (InputStream in = imageResponse.body();
        FileOutputStream out = new FileOutputStream(imagePath.toFile())) {
      // Cria o buffer para armazenar blocos de 4096 bytes (4 KB) no arquivo por vez
      byte[] buffer = new byte[4096];
      // Grava o número de bytes lidos e gravados no buffer
      int bytesRead;

      // Armazena de pouco em pouco os bytes da imagen no arquivo de modo que, quando acabar os
      // bytes a serem gravados na imagem, o byteReads fica -1 e sai do loop, terminando de gravar
      // a imagem.
      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
      }

      // Depois do loop a imagem é criada
      System.out.println("Imagem salva como: " + fileName);
    }
  }

  public static void main(String[] args) {
    String apiKey = "DEMO_KEY";
    String url = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String json = response.body();

      JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

      String title = jsonObject.get("title").getAsString();
      String explanation = jsonObject.get("explanation").getAsString();
      String imageUrl = jsonObject.get("url").getAsString();

      System.out.println("Título: " + title);
      System.out.println("Descrição: " + explanation);
      System.out.println("Imagem do dia: " + imageUrl);

      // Pega a data do dia que a imagem é disponibilizada
      String date = jsonObject.get("date").getAsString(); // ex: "2025-06-07"
      // Cria o nome da imagem com a data e o titulo da imagem do dia
      String imageName = date + "_" + title.replaceAll("[^a-zA-Z0-9\\-_]", "_") + ".jpg";
      String folder = "downloadedImages";

      try {
        // Função para baixar a imagem, recebendo o link e o nome da imagem e a pasta onde será
        // criada a imagem
        downloadImage(imageUrl, folder, imageName);
      } catch (IOException | InterruptedException erro) {
        System.err.println("Erro ao baixar imagem:");
        erro.printStackTrace();
      }
    } catch (IOException | InterruptedException erro) {
      System.err.println("Erro geral: ");
      erro.printStackTrace();
    }
  }
}
