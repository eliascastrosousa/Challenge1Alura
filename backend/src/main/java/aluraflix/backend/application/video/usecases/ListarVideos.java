package aluraflix.backend.application.video.usecases;

import aluraflix.backend.application.video.gateways.RepositorioDeVideo;
import aluraflix.backend.domain.entities.video.Video;

import java.util.List;

public class ListarVideos {
    private final RepositorioDeVideo repositorio;

    public ListarVideos(RepositorioDeVideo repositorio) {
        this.repositorio = repositorio;
    }

    public List<Video> obterTodosVideos(){
        return this.repositorio.listarTodos();
    }
}
