import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class DinoToys {
  private String mDinoType;
  private int mSize;
  private String mRarity;
  private String mCondition;
  private String mManufactured;
  private int mPrice;
  private static List<DinoToys> jurassicPark = new ArrayList<DinoToys>();
  private int mId;

  public DinoToys(String type, int size, String rare, String condition, String manufactured, int price) {
    mDinoType = type;
    mSize = size;
    mRarity = rare;
    mCondition = condition;
    mManufactured = manufactured;
    mPrice = price;
    jurassicPark.add(this);
    mId = jurassicPark.size();// + Math.rand(1000);
  }

  public String getType() {
    return mDinoType;
  }

  public int getSize() {
    return mSize;
  }

  public String getRarity() {
    return mRarity;
  }

  public String getCondition() {
    return mCondition;
  }

  public String getManufactured() {
    return mManufactured;
  }

  public int getPrice() {
    return mPrice;
  }

  public int getId() {
    return mId;
  }

  public static DinoToys find(int id) {
    return jurassicPark.get(id - 1);
  }

  public static List<DinoToys> all() {
    return jurassicPark;
  }

}
