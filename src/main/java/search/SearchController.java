package search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


@Controller
public class SearchController {

    private final WebClient webClient;

    public SearchController(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://openlibrary.org/search.json").build();

    }

    public String getSearchResults(@RequestParam String query) {
        return "search";

    }
    
}
