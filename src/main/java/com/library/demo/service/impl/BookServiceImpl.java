package com.library.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.library.demo.model.GoogleBooksApiResponse;
import com.library.demo.service.BookService;

import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    private final String GOOGLE_BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes?q=subject:books";
    private final RestTemplate restTemplate;

    public BookServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getRandomBook() {
        // Generar un número aleatorio para el índice de startIndex
        Random random = new Random();
        int randomIndex = random.nextInt(100); // Puedes ajustar el límite superior según tus necesidades

        String url = GOOGLE_BOOKS_API_URL + "&startIndex=" + randomIndex + "&maxResults=1";

        // Realizar la solicitud GET y obtener la respuesta como un objeto JSON
        GoogleBooksApiResponse response = restTemplate.getForObject(url, GoogleBooksApiResponse.class);

        // Extraer el título y el autor del libro aleatorio
        String title = response.getItems()[0].getVolumeInfo().getTitle();
        String author = response.getItems()[0].getVolumeInfo().getAuthors()[0];

        return "Título del libro aleatorio: " + title + " - Autor del libro aleatorio: " + author;
    }
}