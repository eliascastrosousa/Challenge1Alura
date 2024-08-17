package aluraflix.backend.infra.controller.video;

import aluraflix.backend.infra.service.VideoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService service;

    @PostMapping
    @Transactional
    public  VideoDTO cadastrarVideo(@RequestBody VideoDTO dto){
        return service.cadastrarVideo(dto);
    }

    @GetMapping
    public List<VideoDTO> listarTodos(){
        return service.listarVideos();
    }

    @GetMapping("/{id}")
    public VideoDTO detalharVideo(@PathVariable Long id){
        return service.detalharVideo(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public VideoDTO atualizarVideo(@PathVariable Long id, @RequestBody AtualizacaoVideoDTO dados){
        return service.atualizarVideo(id, dados);
    }

    @DeleteMapping("/{id}")
    public void deletarVideo(@PathVariable Long id){
        service.deletarVideo(id);
    }



}
