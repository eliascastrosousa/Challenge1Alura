package aluraflix.backend.infra.gateways;

import aluraflix.backend.domain.entities.video.Video;
import aluraflix.backend.infra.persistence.video.VideoEntity;

public class VideoEntityMapper {

    public VideoEntity toEntity(Video video){
        return new VideoEntity(video.getTitulo(), video.getDescricao(), video.getUrl());
    }

    public Video toDomain(VideoEntity entity){
        return new Video(entity.getTitulo(), entity.getDescricao(), entity.getUrl());
    }
}
