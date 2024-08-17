package aluraflix.backend.application.video.usecases;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;

public class DetalharVideo {
    private final RepositorioDeVideo repositorio;

    public DetalharVideo(RepositorioDeVideo repositorio) {
        this.repositorio = repositorio;
    }

    public Video detalharVideo(Long id) {
        return repositorio.detalharVideo(id);
    }

}
