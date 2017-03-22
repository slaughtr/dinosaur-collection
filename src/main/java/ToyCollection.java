import java.util.List;
import java.util.ArrayList;

public class ToyCollection {
  private String mName;
  private static List<ToyCollection> instances = new ArrayList<ToyCollection>();
  private int mId;
  private static List<DinoToys> mToys;


  public ToyCollection(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mToys = new ArrayList<DinoToys>();
  }

  public String getName() {
    return mName;
  }

  // public static List<ToyCollection> all() {
  //   return instances;
  // }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static ToyCollection find(int id) {
    return instances.get(id - 1);
  }

  public static List<DinoToys> getDinoToys() {
    return mToys;
  }

  public static void addDinoToy(DinoToys toy) {
    mToys.add(toy);
  }

  public static List<ToyCollection> getAllCollections() {
    return instances;
  }
}
