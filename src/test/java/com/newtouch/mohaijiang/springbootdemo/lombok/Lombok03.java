package com.newtouch.mohaijiang.springbootdemo.lombok;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootTest
public class Lombok03 {

    @Test
    public void testCleanup() throws IOException {

        Resource resource = new ClassPathResource("application.yml");
        @Cleanup
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        String line;
        while ((line = br.readLine())!= null){
            System.out.println(line);
        }

    }
}
