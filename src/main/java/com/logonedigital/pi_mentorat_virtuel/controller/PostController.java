package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Post;
import com.logonedigital.pi_mentorat_virtuel.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @Operation(
            summary = "Ajouter une nouvelle catégorie",
            description = "Cette méthode permet d'ajouter une nouvelle catégorie dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Catégorie ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides")
    })
    @PostMapping(path = "post/add")
    @ResponseBody
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        return ResponseEntity
                .ok(this.postService.addPost(post));
    }
    @Operation(
            summary = "Recuperer la liste des categories",
            description = "Cette méthode permet de recuperer une liste complete de toutes les catégories."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "liste des categories recuperee aec success")
    })
    @GetMapping(path = "post/get-all-post")
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity
                .ok(this.postService.getAllPost());
    }
    @Operation(
            summary = "Récupérer une catégorie par son identifiant",
            description = "Cette méthode permet de récupérer une catégorie spécifique en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été récupérée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @GetMapping(path = "post/get-post-by-id/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId){
        return ResponseEntity
                .ok(this.postService.getPostById(postId));
    }
    @Operation(
            summary = "Mettre à jour une catégorie existante",
            description = "Cette méthode permet de mettre à jour les informations d'une catégorie existante dans la base de données."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La catégorie a été mise à jour avec succès."),
            @ApiResponse(responseCode = "400", description = "Les données envoyées sont invalides ou incomplètes.")
    })
    @PutMapping(path = "post/update-post-by-id/{postId}")
    public ResponseEntity<Post> updatePostById(@RequestBody Post post,@PathVariable Integer postId){
        return ResponseEntity
                .ok(this.postService.updatePostById(post, postId));
    }
    @Operation(
            summary = "Supprimer une catégorie par son identifiant",
            description = "Cette méthode permet de supprimer une catégorie de la base de données en utilisant son identifiant unique."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie supprimée avec succès."),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée pour l'ID donné.")
    })
    @DeleteMapping(path = "post/delete-post-by-id/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer postId){
        this.postService.deletePostById(postId);
        return ResponseEntity
                .ok("post deleted successfully!!");
    }
}
