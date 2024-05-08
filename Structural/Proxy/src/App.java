import Downloader.ProxyVideoDownloader;
import Downloader.VideoDownloader;
import Internet.Internet;
import Internet.ProxyInternet;

public class App {
    public static void main(String[] args) throws Exception {
        Internet internet = new ProxyInternet();
        internet.connectTo("Http:\\www.google.com");
        internet.connectTo("Http:\\www.facebook.com");

        VideoDownloader downloader =  new ProxyVideoDownloader();
        downloader.downloadVideo("video1");
        downloader.downloadVideo("video2");
        downloader.downloadVideo("video1");
    }
}
