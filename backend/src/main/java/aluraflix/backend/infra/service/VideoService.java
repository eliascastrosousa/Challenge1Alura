package aluraflix.backend.infra.service;

import aluraflix.backend.application.video.usecases.*;
import aluraflix.backend.domain.entities.video.Video;
import aluraflix.backend.infra.controller.video.AtualizacaoVideoDTO;
import aluraflix.backend.infra.controller.video.VideoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private final CriarVideo criarVideo;
    private final ListarVideos listarVideos;
    private final DetalharVideo detalharVideo;
    private final AtualizarVideo atualizarVideo;
    private final DeletarVideo deletarVideo;

    public VideoService(CriarVideo criarVideo, ListarVideos listarVideos, DetalharVideo detalharVideo, AtualizarVideo atualizarVideo, DeletarVideo deletarVideo) {
        this.criarVideo = criarVideo;
        this.listarVideos = listarVideos;
        this.detalharVideo = detalharVideo;
        this.atualizarVideo = atualizarVideo;
        this.deletarVideo = deletarVideo;
    }

    public VideoDTO cadastrarVideo(VideoDTO dto) {
        Video video = criarVideo.cadastrarVideo(new Video(dto.titulo(), dto.descricao(), dto.url()));
        return new VideoDTO(video.getTitulo(), video.getDescricao(), video.getUrl());
    }


    public List<VideoDTO> listarVideos() {
        return listarVideos.obterTodosVideos().stream()
                .map(v -> new VideoDTO(v.getTitulo(), v.getDescricao(), v.getUrl()) ).collect(Collectors.toList());
    }

    public VideoDTO detalharVideo(Long id) {
        Video video = detalharVideo.detalharVideo(id);
        return new VideoDTO(video.getTitulo(), video.getDescricao(), video.getUrl());
    }

    public VideoDTO atualizarVideo(Long id, AtualizacaoVideoDTO dados) {
        Video videoAtualizado = atualizarVideo.atualizarVideo(id, dados);
        return new VideoDTO(videoAtualizado.getTitulo(), videoAtualizado.getDescricao(), videoAtualizado.getUrl());
    }


    public void deletarVideo(Long id) {
        deletarVideo.deletarVideo(id);
    }
}
