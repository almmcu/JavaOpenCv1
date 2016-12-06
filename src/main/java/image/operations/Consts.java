package image.operations;

/**
 * Created by Oda114 on 6.12.2016.
 */
public class Consts {

    /**
     * Image path
     */
    public static final String IMAGE_PATH = "C:\\Users\\Oda114\\Desktop\\Hilal_Deniz.jpg";

    public static final String IMAGE_PATH_2 = "C:\\Users\\Oda\\Desktop\\ICCESEN_2016_Pictures\\2.jpg";

    public static final String IMAGE_PATH_OUTPUT = "C:\\Users\\Oda114\\Desktop\\Hilal_Deniz_Output.jpg";


    /**
     The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
     and so on. Thus, the caller should be prevented from constructing objects of
     this class, by declaring this private constructor.
     */
    private Consts(){
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}

