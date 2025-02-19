package com.turkcell.order_service.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


// product service ile iletişime geçecek yardımcı class
// url varsa direkt url kullanarak gider eğer url yoksa discovery-server'da name ile bir eşleşme arar
@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/api/v1/product")
    String get();

}
