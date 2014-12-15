package raditya.labs.albahjah.model;

/**
 * Created by raditya on 12/15/2014.
 */
public class NavDrawerItemModel {

    private String title;
    private int icon;
    private String count = "0";
    private boolean isCounterVisible = false;

    public NavDrawerItemModel(){};

    public NavDrawerItemModel(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public NavDrawerItemModel(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.count = count;
        this.isCounterVisible = isCounterVisible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCounterVisible() {
        return isCounterVisible;
    }

    public void setCounterVisible(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
