package cpe200;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.javafx.iio.png.PNGDescriptor;

public class PhotoPost extends Post {
    private String filename;
    private String caption;

    public PhotoPost() {
        super();
        this.filename = null;
        this.caption = null;
    }

    public PhotoPost(String u) {
        super();
        super.username = u;
    }

    public PhotoPost(String u, String f, String c) {
        super();
        super.username = u;

        if (isValidateFile(f)) {
            this.filename = f;
        }
        this.caption = c;

    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        if(isValidateFile(filename)) {
            this.filename = filename;
        }
    }


    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    private boolean isValidateFile(String f) {
        // only allow JPEG and PNG file
        if (f.contains(".png") || f.contains(".jpeg"))
        {
            return true;
    }
    return false;
    }

    @Override
    public void display() {
        String o = this.toString()+ "\n[" + this.filename +"]" + "\nCaption: "+ this.caption + "\n"+super.likes + "people like ths.";
        System.out.println(o);
        if (super.comments.isEmpty())
        {
            System.out.println("\nNo Comments.");
        }
        else {
            for(int i=0; i<super.comments.size();i++)
            {
                System.out.println("\t" + super.comments.get(i));
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {

        return super.username+"(posted : " + super.timestamp+")";
    }


}
