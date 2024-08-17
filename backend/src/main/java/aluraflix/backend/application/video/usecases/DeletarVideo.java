package aluraflix.backend.application.video.usecases;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;

public class DeletarVideo {
    private final RepositorioDeVideo repositorio;

    public DeletarVideo(RepositorioDeVideo repositorio) {
        this.repositorio = repositorio;
    }

    public void deletarVideo(Long id) {
        repositorio.deletarVideo(id);
    }
}
