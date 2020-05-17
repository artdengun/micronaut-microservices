package order;

import java.util.HashMap;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.MediaType;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;

@Controller("/orders")
public class IndexController {
  OkHttpClient client = new OkHttpClient();

  @Get(produces=MediaType.APPLICATION_JSON)
  public String index() throws Exception {
    Request request = new Request.Builder()
      .url("http://localhost:8080/book")
      .build();

    try (Response response = client.newCall(request).execute()) {
      Gson gson = new Gson();
      HashMap<String, String> data = new HashMap<>();
      data.put("message", "data orders");
      data.put("books", response.body().string());
      return gson.toJson(data);
    }

  }

}
