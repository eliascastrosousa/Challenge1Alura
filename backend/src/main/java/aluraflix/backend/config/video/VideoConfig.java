package aluraflix.backend.config.video;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.application.video.usecases.*;
import aluraflix.backend.infra.gateways.RepositorioDeVideoJpa;
import aluraflix.backend.infra.gateways.VideoEntityMapper;
import aluraflix.backend.infra.persistence.video.VideoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfig {


    @Bean
    CriarVideo criarVideo(RepositorioDeVideo repositorioDeVideo){
        return new CriarVideo(repositorioDeVideo);
    }

    @Bean
    ListarVideos listarVideos(RepositorioDeVideo repositorioDeVideo){
        return new ListarVideos(repositorioDeVideo);
    }

    @Bean
    DetalharVideo detalharVideo(RepositorioDeVideo repositorioDeVideo){
        return new DetalharVideo(repositorioDeVideo);
    }

    @Bean
    AtualizarVideo atualizarVideo(RepositorioDeVideo repositorioDeVideo){
        return new AtualizarVideo(repositorioDeVideo);
    }

    @Bean
    DeletarVideo deletarVideo(RepositorioDeVideo repositorioDeVideo){
        return new DeletarVideo(repositorioDeVideo);
    }

    @Bean
    RepositorioDeVideoJpa criarRepositorioJpa(VideoRepository repository, VideoEntityMapper mapper){
        return new RepositorioDeVideoJpa(repository, mapper);
    }

    @Bean
    VideoEntityMapper retornaMapper(){
        return new VideoEntityMapper();
    }

}
