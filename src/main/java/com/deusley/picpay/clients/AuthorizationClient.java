package com.deusley.picpay.clients;

import com.deusley.picpay.dto.ResponseClientDto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "authorization",
        url = "${client.authorization-service.url}")
public interface AuthorizationClient {

    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();

}
