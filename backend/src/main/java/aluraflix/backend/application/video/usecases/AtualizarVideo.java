package aluraflix.backend.application.video.usecases;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;
import aluraflix.backend.infra.controller.video.AtualizacaoVideoDTO;

public class AtualizarVideo {
    private final RepositorioDeVideo repositorioDeVideo;

    public AtualizarVideo(RepositorioDeVideo repositorioDeVideo) {
        this.repositorioDeVideo = repositorioDeVideo;
    }

    public Video atualizarVideo(Long id, AtualizacaoVideoDTO dados){
        return repositorioDeVideo.atualizarVideo(id, dados);
    }
}
