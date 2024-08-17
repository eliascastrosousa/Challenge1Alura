package aluraflix.backend.infra.controller.video;

public record VideoDTO(
        String titulo,
        String descricao,
        String url
) {
}
