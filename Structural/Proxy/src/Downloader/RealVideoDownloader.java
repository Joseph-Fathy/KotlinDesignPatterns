package Downloader;

public class RealVideoDownloader implements VideoDownloader{

    @Override
    public Video downloadVideo(String videoName) {
        System.out.println("Downloading "+videoName+" ...");
        System.out.println("Download Completed");
        return new Video(videoName.toLowerCase());
    }

}
