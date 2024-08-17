package aluraflix.backend.domain.entities.video;

public class FabricaDeVideo {
    private Video video;

    public Video comTituloDescricaoUrl(String titulo, String descricao, String url){
        this.video = new Video(titulo,descricao,url);
        return this.video;
    }


}
