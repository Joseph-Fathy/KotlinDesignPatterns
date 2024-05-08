package Downloader;

import java.util.HashMap;

public class ProxyVideoDownloader implements VideoDownloader {

    HashMap<String, Video> cachedVideos = new HashMap<>();
    VideoDownloader realVideoDownloader = new RealVideoDownloader();

    @Override
    public Video downloadVideo(String videoName) {
        if (cachedVideos.containsKey(videoName.toLowerCase())) {
            return cachedVideos.get(videoName.toLowerCase());
        } else {
            Video video = realVideoDownloader.downloadVideo(videoName);
            cachedVideos.put(video.name, video);
            return video;
        }

    }

}
