package Internet;
import java.util.ArrayList;

public class ProxyInternet implements Internet {
    static ArrayList<String> blockedSites;
    private final Internet realInternet = new RealInternet();

    static {
        blockedSites = new ArrayList<String>();
        blockedSites.add("facebook");
        blockedSites.add("youtube");
        blockedSites.add("instagram");
    }

    @Override
    public void connectTo(String url) {
        for (String site : blockedSites){
            if (url.contains(site)){
                System.out.println(site+" is blocked");
                return;
            }
        }
        realInternet.connectTo(url);
    }

}
