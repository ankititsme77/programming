// ServiceA Application Main Method
public class ServiceAApplication {
    public static void main(String[] args) {
        // Configure and start Zuul server
        ZuulProperties properties = new ZuulProperties();
        properties.setRoute("/serviceB/**", "http://localhost:8081");
        ZuulServer server = new ZuulServer(properties);
        server.start();

        // Start ServiceA microservice
        // ...
    }
}
@RestController
public class ServiceAController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/someEndpoint")
    public String someEndpoint() {
        // Make a request to ServiceB through the Zuul proxy
        String response = restTemplate.getForObject("http://localhost:8080/serviceB/someOtherEndpoint", String.class);
        return "ServiceA response: " + response;
    }
}

@RestController
public class ServiceBController {
    @GetMapping("/someOtherEndpoint")
    public String someOtherEndpoint() {
        return "ServiceB response";
    }
}
