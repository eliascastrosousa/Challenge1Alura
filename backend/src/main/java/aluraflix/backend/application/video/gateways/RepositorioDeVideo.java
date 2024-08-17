package aluraflix.backend.application.video.gateways;

import aluraflix.backend.domain.entities.video.Video;
import aluraflix.backend.infra.controller.video.AtualizacaoVideoDTO;

import java.util.List;

public interface RepositorioDeVideo {
    Video cadastrarVideo(Video video);

    List<Video> listarTodos();

    Video detalharVideo(Long id);

    Video atualizarVideo(Long id, AtualizacaoVideoDTO dados);

    void deletarVideo(Long id);
}
