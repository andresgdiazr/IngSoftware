package com.StartupFinazas.cliente.controllers;

import com.StartupFinazas.cliente.entities.Cliente;
import com.StartupFinazas.cliente.entities.ClienteProducto;
import com.StartupFinazas.cliente.repositories.ClienteRepositorio;
import com.fasterxml.jackson.databind.JsonNode;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    public ClienteController(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder;
    }
    @Autowired
    ClienteRepositorio clienteRepositorio;

    private final WebClient.Builder webClient;

    HttpClient cliente = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000)
            .option(ChannelOption.SO_KEEPALIVE,true)
            .responseTimeout(Duration.ofSeconds(1))
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(5000,TimeUnit.MILLISECONDS));
            });

    @GetMapping()
    public List<Cliente> findAll(){

        return clienteRepositorio.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id){
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Cliente input){
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent()){
            Cliente cliente1 = cliente.get();
            cliente1.setNombre(input.getNombre());
            cliente1.setApellido(input.getApellido());
            cliente1.setTelf(input.getTelf());
            cliente1.setDireccion(input.getDireccion());
            cliente1.setCed(input.getCed());
            Cliente salvar = clienteRepositorio.save(cliente1);
            return  new ResponseEntity<>(salvar,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Cliente input){
        input.getProductoList().forEach( x -> x.setCliente(input));
        Cliente cliente = clienteRepositorio.save(input);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Cliente> findById = clienteRepositorio.findById(id);

        findById.ifPresent(cliente -> clienteRepositorio.delete(cliente));

        return ResponseEntity.ok().build();

    }
    private List<?> getTransaccion(String cuenta){

        WebClient build = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(cliente))
                .baseUrl("http://localhost:8091/transaction")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url","http://localhost:8080/product"))
                .build();

        List<?> transaction = build.method(HttpMethod.GET).uri(uriBuilder ->uriBuilder
                .path("cliente/transaction")
                .queryParam("cuenta",cuenta)
                .build())
                .retrieve().bodyToFlux(Object.class).collectList().block();

        return transaction;
    }


    private String getProductName(long id){

        WebClient build = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(cliente))
                .baseUrl("http://localhost:8090/product")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url","http://localhost:8080/product"))
                .build();
        JsonNode block = build.method(HttpMethod.GET).uri("/"+id)
                .retrieve().bodyToMono(JsonNode.class).block();
        String name = block.get("nombre").asText();
        return name;
    }

    @GetMapping("/full")
    public Cliente getByCed(@RequestParam String ced ) {
        Cliente cli = clienteRepositorio.findByCed(ced);
        List<ClienteProducto> productos = cli.getProductoList();
        productos.forEach(x -> {
            String productName = getProductName(x.getProductId());
            x.setNombreProducto(productName);
        });
        List<?>transaccion = getTransaccion(cli.getCuenta());
        cli.setTransacList(transaccion);
    return cli;
    }

}
