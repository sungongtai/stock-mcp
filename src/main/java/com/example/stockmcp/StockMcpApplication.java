package com.example.stockmcp;

import com.example.stockmcp.service.StockService;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StockMcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMcpApplication.class, args);
    }
    @Bean
    public List<ToolCallback> myTools(StockService stockService){
        return List.of(ToolCallbacks.from(stockService));
    }

}
