package sam.com.findhome;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class product  {
    public int ID;
    public String title;
    public String matn;
    public String image;
    public String guid;

public product(int ID,String title, String matn, String image, String guid){
    this.ID=ID;
    this.title=title;
    this.matn=matn;
    this.image=image;
    this.guid=guid;
}

}