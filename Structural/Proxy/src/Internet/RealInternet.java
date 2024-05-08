package Internet;
public class RealInternet implements Internet{

    @Override
    public void connectTo(String url) {
        System.out.println("Internet connection established to the url: "+url);
    }


}
