package search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class SearchController {

    private final WebClient webClient;

    public SearchController(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://openlibrary.org/search.json").build();

    }

    @GetMapping(value = "/search")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public String getSearchResults(@RequestParam String query, Model model) {
        //mono is a type string
        Mono <SearchResult> resultsMono = this.webClient.get()
            .uri("?q={query}", query)
            .retrieve().bodyToMono(SearchResult.class);
            SearchResult result = resultsMono.block();
            model.addAttribute("searchResult", result);

        return "search";

    }
    
}
