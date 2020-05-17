package book.controller;

import java.util.HashMap;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.MediaType;

import com.google.gson.Gson;

@Controller("/book")
public class IndexController {
  
  @Get(produces=MediaType.APPLICATION_JSON)
  public String index() {
    Gson gson = new Gson();

    HashMap<String, String> data = new HashMap<>();
    data.put("message", "buku-buku cerita");

    return gson.toJson(data);
  }

}
