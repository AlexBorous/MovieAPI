package com.borous.oauth0_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth0ServerApplication implements CommandLineRunner {
//    @Autowired
//    MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(Oauth0ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" +
//                "d5a7a7cb65a224121ee4dfa323f576fa" +
//                "&language=en-US&page=1");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Accept", "application/json");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        StringBuilder responseContent = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            responseContent.append(line);
//        }
//        reader.close();
//        con.disconnect();
//
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode actualObj = mapper.readTree(responseContent.toString());
//        JsonNode jsonObjects = actualObj.get("results");
//        Iterator<JsonNode> elements = jsonObjects.elements();
//        while (elements.hasNext()) {
//            JsonNode jsonNode = elements.next();
//            Movie movie = Movie.builder()
//                    .movieId(jsonNode.get("id").bigIntegerValue())
//                    .backdrop_path(jsonNode.get("backdrop_path").asText())
//                    .overview(jsonNode.get("overview").asText())
//                    .isLiked(false)
//                    .poster_path(jsonNode.get("poster_path").asText())
//                    .title(jsonNode.get("title").asText())
//                    .release_date(jsonNode.get("release_date").asText())
//                    .vote_average(jsonNode.get("vote_average").asDouble())
//                    .vote_count(jsonNode.get("vote_count").asDouble())
//                    .build();
//            System.out.println(movie);
//            movieService.addMovie(movie, null);
//        }
    }
}
