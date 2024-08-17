package aluraflix.backend.infra.gateways;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;
import aluraflix.backend.infra.controller.video.AtualizacaoVideoDTO;
import aluraflix.backend.infra.persistence.video.VideoEntity;
import aluraflix.backend.infra.persistence.video.VideoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeVideoJpa implements RepositorioDeVideo {

    private final VideoRepository repository;
    private final VideoEntityMapper mapper;

    public RepositorioDeVideoJpa(VideoRepository repository, VideoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Video cadastrarVideo(Video video) {
        VideoEntity entity = mapper.toEntity(video);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Video> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Video detalharVideo(Long id) {
        return mapper.toDomain(repository.getReferenceById(id));
    }

    @Override
    public Video atualizarVideo(Long id, AtualizacaoVideoDTO dados) {
        var video = repository.findById(id);
        if (video.isPresent()) {
            VideoEntity entity = video.get();
            if (dados.titulo() != null){
                entity.setTitulo(dados.titulo());
            }
            if (dados.descricao() != null){
                entity.setDescricao(dados.descricao());
            }
            if (dados.url() != null){
                entity.setUrl(dados.url());
            }
            repository.save(entity);
            return mapper.toDomain(entity);
        }
        return null;
    }

    @Override
    public void deletarVideo(Long id) {
        var video = repository.findById(id);
        if (video.isPresent()){
            repository.deleteById(id);
        }
    }


}
