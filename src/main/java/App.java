import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String collectionName = request.queryParams("collectionName");
      ToyCollection newCollection = new ToyCollection(collectionName);
      ArrayList<ToyCollection> collections = request.session().attribute("collections");

      model.put("collections", request.session().attribute("collections"));

      if (collections == null) {
        collections = new ArrayList<ToyCollection>();
        request.session().attribute("collections", collections);
      }

      model.put("collectionsAll", ToyCollection.getAllCollections());
      model.put("template", "templates/index.vtl");
      model.put("template2", "templates/collectionsForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/collections", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // model.put("collectionsObject", ToyCollection);
      model.put("collectionsAll", ToyCollection.getAllCollections());
      model.put("template", "templates/displayAllCollections.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/toys", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/dinoToy-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/toys", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String type = request.queryParams("type");
      int size = Integer.parseInt(request.queryParams("size"));
      String rarity = request.queryParams("rarity");
      String condition = request.queryParams("condition");
      String manufactured = request.queryParams("manufactured");
      int price = Integer.parseInt(request.queryParams("price"));
      DinoToys newToy = new DinoToys(type, size, rarity, condition, manufactured, price);
      model.put("template", "templates/dinoToy-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/inventory", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("collections", ToyCollection.all());
      model.put("toys", DinoToys.all());
      model.put("template", "templates/index.vtl");
      model.put("template", "templates/inventory.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




  }
}
