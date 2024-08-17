package aluraflix.backend.application.video.usecases;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;

public class CriarVideo {
    private final RepositorioDeVideo repositorio;

    public CriarVideo(RepositorioDeVideo repositorio) {
        this.repositorio = repositorio;
    }

    public Video cadastrarVideo(Video video) {
        return repositorio.cadastrarVideo(video);
    }
}
